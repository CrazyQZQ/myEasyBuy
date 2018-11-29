package com.easybuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.Page;
import com.easybuy.entity.Product;
import com.easybuy.service.ProductServiceImpl;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 页面容量
	private int pageSize = 3;
	ProductServiceImpl psi = new ProductServiceImpl();
	int totalProduct;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
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
		request.setCharacterEncoding("utf-8");
		String mess = request.getParameter("mess");
		String pcId = request.getParameter("pcId");
		if ("center".equals(mess)) {
			showProductFromCenter(request, response, pcId);
		} else if ("search".equals(mess)) {
			showProductFromSearch(request, response);
		} else if ("pageMess".equals(mess)) {
			changePage(request, response);
		}
	}

	/*
	 * 点击首页1/2/3级菜单进入
	 */
	public void showProductFromCenter(HttpServletRequest request,
			HttpServletResponse response, String pcId) throws IOException {
		String pc1Name = request.getParameter("pc1Name");
		pc1Name = new String(pc1Name.getBytes("iso-8859-1"), "utf-8");
		// 由此获得总商品列表
		List<Product> productList = psi.queryGoodsByFirMenu(
				Integer.parseInt(pcId), null, null);
		totalProduct = productList.size();
		// 由此获得第一页
		Page<Product> page = psi.queryPageByFirMenu(Integer.parseInt(pcId), 1,
				pageSize);
		request.getSession().setAttribute("productList", productList);
		request.getSession().setAttribute("page", page);
		request.getSession().setAttribute("pc1Name", pc1Name);
		request.getSession().setAttribute("pcId", pcId);
		request.getSession().removeAttribute("search");
		request.getSession().setAttribute("totalProduct", totalProduct);
		response.sendRedirect(request.getContextPath() + "/pre/showProduct.jsp");
	}

	/*
	 * 搜索进入
	 */
	public void showProductFromSearch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String search = request.getParameter("search");
		// 由此获得总商品列表
		List<Product> productList = psi.queryGoodsByFirMess(search, null, null);
		totalProduct = productList.size();
		// 由此获得第一页
		Page<Product> page = psi.queryPageByFirMess(search, 1, pageSize);
		request.getSession().setAttribute("page", page);
		request.getSession().setAttribute("productList", productList);
		request.getSession().setAttribute("search", search);
		request.getSession().removeAttribute("pcId");
		request.getSession().setAttribute("totalProduct", totalProduct);
		response.sendRedirect(request.getContextPath() + "/pre/showProduct.jsp");
	}

	/*
	 * 翻页
	 */
	public void changePage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String pcId = (String) request.getSession().getAttribute("pcId");
		String currt = request.getParameter("currentPageNo");
		// 当前页
		int currPageNo = 0;
		if (currt == null || currt == "") {
			currPageNo = 1;
		} else {
			currPageNo = Integer.parseInt(currt);
		}
		Page<Product> page = null;
		// search不为空则当前为模糊查询所在的页面
		if (!StringUtils.isNullOrEmpty((String) request.getSession()
				.getAttribute("search"))) {
			page = psi.queryPageByFirMess((String) request.getSession()
					.getAttribute("search"), currPageNo, pageSize);
		} else {
			page = psi.queryPageByFirMenu(Integer.parseInt(pcId), currPageNo,
					pageSize);
		}
		request.getSession().setAttribute("page", page);
		response.sendRedirect(request.getContextPath() + "/pre/showProduct.jsp");
	}
}
