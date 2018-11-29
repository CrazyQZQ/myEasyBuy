package com.easybuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.Product;
import com.easybuy.service.ProductServiceImpl;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class ProductDetailServlet
 */
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetailServlet() {
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
		String productId = request.getParameter("productId");
		if (!StringUtils.isNullOrEmpty(productId)) {// 根据商品id获得商品
			ProductServiceImpl psi = new ProductServiceImpl();
			Product productDetail = psi.qeuryProductById(Integer
					.parseInt(productId));
			request.getSession().setAttribute("productDetail", productDetail);
			response.sendRedirect(request.getContextPath() + "/pre/product.jsp");
		}
	}

}
