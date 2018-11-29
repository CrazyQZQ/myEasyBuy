package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.CheckCode;
import com.easybuy.utils.NumUtil;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class CheckCodeServlet
 */
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckCodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String checkCode = request.getParameter("checkCode");
		String info = request.getParameter("info");
		if (!StringUtils.isNullOrEmpty(checkCode)) {
			checkCode(request, response, checkCode);
		} else if (!StringUtils.isNullOrEmpty(info)) {
			changeCheckCode(request, response);
		}

	}

	public void checkCode(HttpServletRequest request,
			HttpServletResponse response, String checkCode) throws IOException {
		CheckCode defaultCheckCode = (CheckCode) request.getSession()
				.getAttribute("defaultCheckCode");
		PrintWriter out = response.getWriter();
		// 如果输入的验证码与默认验证码的值不同返回true
		if (checkCode != null) {
			if (!checkCode.toLowerCase().equals(defaultCheckCode.getValue())) {
				out.print("true");
			}
		}

	}

	public void changeCheckCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 获得当前验证码对象
		CheckCode defaultCheckCode = (CheckCode) request.getSession()
				.getAttribute("defaultCheckCode");
		// 获得当前验证码对象在列表中的位置
		int currentCheckCodeNo = (int) request.getSession().getAttribute(
				"currentCheckCodeNo");
		// 获得新位置
		int newCurrent = NumUtil.getRandomNum(0, 23, currentCheckCodeNo);
		// 获得验证码列表
		List<CheckCode> checkCodeList = (List<CheckCode>) request.getSession()
				.getAttribute("checkCodeList");
		// 重置验证码对象在列表中的位置
		request.getSession().setAttribute("currentCheckCodeNo", newCurrent);
		// 重置当前验证码对象
		request.getSession().setAttribute("defaultCheckCode",
				checkCodeList.get(newCurrent));
		PrintWriter out = response.getWriter();
		// 返回当前验证码名给页面
		out.print(checkCodeList.get(newCurrent).getName());
	}
}
