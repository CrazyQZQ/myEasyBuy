package com.easybuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.CheckCode;
import com.easybuy.entity.MyCollection;
import com.easybuy.entity.News;
import com.easybuy.entity.Page;
import com.easybuy.entity.ShoppingCart;
import com.easybuy.entity.User;
import com.easybuy.service.CheckCodeServiceImpl;
import com.easybuy.service.NewsServiceImpl;
import com.easybuy.service.ProductService;
import com.easybuy.service.ProductServiceImpl;
import com.easybuy.service.UserServiceImpl;
import com.easybuy.utils.NumUtil;
import com.easybuy.utils.Product_categoryUtil;

/**
 * 加载商品分类信息 Servlet implementation class LoadServlet
 */
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ProductService ps = new ProductServiceImpl();
		// 加载所有1级商品信息
		// 加载所有的商品分类信息
		List<Product_categoryUtil> allMenu = ps.queryAllMenu();
		request.getSession().setAttribute("allMenu", allMenu);
		// 加载所有的用户信息
		UserServiceImpl usi = new UserServiceImpl();
		List<User> userList = usi.queryUserList();
		request.getSession().setAttribute("userList", userList);
		// 加载所有的新闻信息
		NewsServiceImpl nsi = new NewsServiceImpl();
		Page<News> loadNewsPage = nsi.queryNewsPage(1, 5);
		request.getSession().setAttribute("loadNewsPage", loadNewsPage);
		// 加载所有的验证码
		CheckCodeServiceImpl ccs = new CheckCodeServiceImpl();
		List<CheckCode> checkCodeList = ccs.queryCheckCode();
		int currentCheckCodeNo = NumUtil.getRandomNum(0, 23);
		// 每次加载获得一个随机验证码
		request.getSession().setAttribute("defaultCheckCode",
				checkCodeList.get(currentCheckCodeNo));
		request.getSession().setAttribute("currentCheckCodeNo",
				currentCheckCodeNo);
		request.getSession().setAttribute("checkCodeList", checkCodeList);

		// 初始化购物车
		ShoppingCart shoppingCart1 = (ShoppingCart) request.getSession()
				.getAttribute("shoppingCart");
		if (shoppingCart1 == null) {
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setShoppingCartItemNum(0);
			request.getSession().setAttribute("shoppingCart", shoppingCart);
		}
		//初始化我的收藏
		MyCollection myCollection = (MyCollection) request.getSession().getAttribute("myCollection");
		if (myCollection == null) {
			myCollection = new MyCollection();
			request.getSession().setAttribute("myCollection", myCollection);
		}
		response.sendRedirect(request.getContextPath() + "/pre/index.jsp");

	}

}
