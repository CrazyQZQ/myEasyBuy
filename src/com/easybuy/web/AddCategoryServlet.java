package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.easybuy.entity.Product_category;
import com.easybuy.service.ProductServiceImpl;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class AddCategoryServlet
 */
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCategoryServlet() {
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
		String cate = request.getParameter("cate");
		ProductServiceImpl psi = new ProductServiceImpl();
		String action = request.getParameter("action");
		if (!StringUtils.isNullOrEmpty(cate)) {
			if ("first".equals(cate)) {// 查询一级菜单（此时添加二级分类）
				List<Product_category> firstMenu = psi.queryMenu(0);
				String fm = JSON.toJSONString(firstMenu);
				PrintWriter out = response.getWriter();
				out.print(fm);
			} else if ("second".equals(cate)) {// 查询二级菜单（此时添加三级分类）
				String id = request.getParameter("id");
				List<Product_category> secondMenu = psi.queryMenu(Integer
						.parseInt(id));
				String sm = JSON.toJSONString(secondMenu);
				PrintWriter out = response.getWriter();
				out.print(sm);
			}
		} else if (!StringUtils.isNullOrEmpty(action)) {// 添加分类
			String jibie = request.getParameter("jibie");
			String yiji = request.getParameter("yiji");
			String erji = request.getParameter("erji");
			String cattegoryName = request.getParameter("cattegoryName");
			if ("1".equals(jibie)) {// 添加一级分类
				Product_category product_category = new Product_category(
						cattegoryName, 0, 1, null);
				psi.addCategory(product_category);
			} else if ("2".equals(jibie)) {// 添加二级分类
				if (!"请选择".equals(yiji)) {
					Product_category product_category = new Product_category(
							cattegoryName, Integer.parseInt(yiji), 2, null);
					psi.addCategory(product_category);
				}
			} else if ("3".equals(jibie)) {// 添加三级分类
				if (!"请选择".equals(erji)) {
					Product_category product_category = new Product_category(
							cattegoryName, Integer.parseInt(erji), 3, null);
					psi.addCategory(product_category);
				}
			}
			response.sendRedirect(request.getContextPath()
					+ "/back?aim=categoryList");
		}

	}

}
