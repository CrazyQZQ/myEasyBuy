package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.CheckCode;
import com.easybuy.entity.User;
import com.easybuy.service.UserServiceImpl;
import com.easybuy.utils.RegUtils;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		String mess = request.getParameter("mess");
		String ajaxLoginName = request.getParameter("ajaxLoginName");
		String ifExsitName = request.getParameter("ifExsitName");
		if ("regist".equals(mess)) {// 注册
			doReist(request, response);
		} else if ("login".equals(mess)) {// 登录
			doLogin(request, response);
		} else if ("unlogin".equals(mess)) {// 注销
			doUnlogin(request, response);
		} else if (ajaxLoginName != null || ajaxLoginName != "") {// 登录时ajax判断用户是否未注册
			checkLoginName(request, response, ajaxLoginName);
		}
		if (ifExsitName != null || ifExsitName != "") {// 注册时ajax判断用户是否已注册
			checkIfExsitName(request, response, ifExsitName);
		}
	}

	/*
	 * 处理登录
	 */
	public void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		UserServiceImpl usi = new UserServiceImpl();
		if (usi.login(loginName, password)) {
			// 获得已经登录的用户信息
			User user = usi.queryUser(loginName);
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/load");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/pre/login.jsp?error=yes");
		}
	}

	/*
	 * 处理注册
	 */
	public void doReist(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		CheckCode defaultCheckCode = (CheckCode) request.getSession()
				.getAttribute("defaultCheckCode");
		String loginname = request.getParameter("loginname");
		String username = request.getParameter("username");
		String identityCode = request.getParameter("identityCode");
		String password = request.getParameter("password1");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String checkCode = request.getParameter("checkCode");
		User user = new User(loginname, username, password,
				Integer.parseInt(sex), identityCode, email, mobile, 0, 0);
		UserServiceImpl usi = new UserServiceImpl();
		boolean flag = false;
		if (RegUtils.checkMobile(mobile) && RegUtils.checkEmail(email)
				&& RegUtils.checkIdentityCodeReg(identityCode)
				&& checkCode.toLowerCase().equals(defaultCheckCode.getValue())) {
			flag = usi.regist(user);
		}
		if (flag) {
			response.sendRedirect(request.getContextPath() + "/pre/login.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/pre/regist.jsp");
		}
	}

	/*
	 * 处理注销
	 */
	public void doUnlogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("shoppingCart");
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/load");
	}

	/*
	 * AJAX判断注册时该用户名是否已被注册
	 */
	public void checkLoginName(HttpServletRequest request,
			HttpServletResponse response, String ajaxLoginName)
			throws IOException {
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.queryUser(ajaxLoginName);
		PrintWriter out = response.getWriter();
		if (user.getLoginName() != null && user.getLoginName() != "") {
			out.print("true");
		}
	}

	/*
	 * AJAX判断登录时该用户名是否未被注册
	 */
	public void checkIfExsitName(HttpServletRequest request,
			HttpServletResponse response, String ifExsitName)
			throws IOException {
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.queryUser(ifExsitName);
		PrintWriter out = response.getWriter();
		if (user.getLoginName() == null || user.getLoginName() == "") {
			out.print("true");
		}
	}

}
