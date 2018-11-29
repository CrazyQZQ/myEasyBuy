package com.easybuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.service.NewsServiceImpl;
import com.easybuy.service.ProductServiceImpl;
import com.easybuy.service.UserServiceImpl;

/**
 * Servlet implementation class HanderDeleteServlet
 */
public class HanderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl usi = new UserServiceImpl();
	private ProductServiceImpl psi = new ProductServiceImpl();
	private NewsServiceImpl nsi = new NewsServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HanderDeleteServlet() {
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
		String aim = request.getParameter("aim");
		if ("user".equals(aim)) {
			deleteUser(request, response);
		} else if ("category".equals(aim)) {
			deleteCategory(request, response);
		} else if ("news".equals(aim)) {
			deleteNews(request, response);
		} else if ("product".equals(aim)) {
			deleteProduct(request, response);
		}
	}

	// 删除用户（数据库中仍存在）
	public void deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String userId = request.getParameter("userId");
		int result = usi.deleteUserById(Integer.parseInt(userId));
		if (result == 0) {
			response.sendRedirect(request.getContextPath()
					+ "/back?aim=userList&error=yes");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/back?aim=userList&error=no");
		}

	}

	// 删除分类
	public void deleteCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String categoryId = request.getParameter("categoryId");
		int result = psi.deleteCategory(Integer.parseInt(categoryId));
		if (result == 0) {
			response.sendRedirect(request.getContextPath()
					+ "/back?aim=categoryList&error=yes");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/back?aim=categoryList&error=no");
		}

	}

	// 删除资讯
	public void deleteNews(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String newsId = request.getParameter("newsId");
		int result = nsi.daleteNews(Integer.parseInt(newsId));
		if (result == 0) {
			response.sendRedirect(request.getContextPath()
					+ "/back?aim=newsList&error=yes");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/back?aim=newsList&error=no");
		}
	}

	// 删除商品
	public void deleteProduct(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String productId = request.getParameter("productId");
		int result = psi.deleteProduct(Integer.parseInt(productId));
		if (result == 0) {
			response.sendRedirect(request.getContextPath()
					+ "/back?aim=productList&error=yes");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/back?aim=productList&error=no");
		}
	}
}
