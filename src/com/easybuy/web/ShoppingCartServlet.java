package com.easybuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.Product;
import com.easybuy.entity.ShoppingCart;
import com.easybuy.service.ProductServiceImpl;
import com.easybuy.utils.NumUtil;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class ShoppingCartServlet
 */
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCartServlet() {
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
		ProductServiceImpl psi = new ProductServiceImpl();
		String action = request.getParameter("action");
		String productId = request.getParameter("productId");
		String quantity = request.getParameter("quantity");
		String id = request.getParameter("id");
		ShoppingCart shoppingCart = getShoppingCart(request, response);
		if (!StringUtils.isNullOrEmpty(action)) {// 商品页面添加购物车
			Product product = psi.qeuryProductById(Integer.parseInt(productId));
			if (NumUtil.isInteger(quantity)) {//检查输入
				if (product.getStock()>=Integer.parseInt(quantity)) {//检查库存
					shoppingCart.addToCart(product, Integer.parseInt(quantity));
				}
			}
			request.getSession().setAttribute("shoppingCart", shoppingCart);
			response.sendRedirect(request.getContextPath()
					+ "/common/pre/tempSearchBar.jsp");
		} else if (!StringUtils.isNullOrEmpty(id)) {// 订单结算页面点击+/-按钮修改购物车
			String doAction = request.getParameter("do");
			if ("jia".equals(doAction)) {
				Product product = psi.qeuryProductById(Integer.parseInt(id));
				shoppingCart.addToCart(product, 1);
				request.getSession().setAttribute("shoppingCart", shoppingCart);
				response.sendRedirect(request.getContextPath()
						+ "/common/pre/tempSearchBar.jsp");
			} else if ("jian".equals(doAction)) {
				Product product = psi.qeuryProductById(Integer.parseInt(id));
				shoppingCart.addToCart(product, -1);
				request.getSession().setAttribute("shoppingCart", shoppingCart);
				response.sendRedirect(request.getContextPath()
						+ "/common/pre/tempSearchBar.jsp");
			}
		}
	}

	/*
	 * 获得购物车
	 */
	public ShoppingCart getShoppingCart(HttpServletRequest request,
			HttpServletResponse response) {
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession()
				.getAttribute("shoppingCart");
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
		}
		return shoppingCart;
	}

}
