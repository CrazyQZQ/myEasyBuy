package com.easybuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.News;
import com.easybuy.entity.Order;
import com.easybuy.entity.Page;
import com.easybuy.entity.Product;
import com.easybuy.entity.Product_category;
import com.easybuy.entity.User;
import com.easybuy.entity.UserAddress;
import com.easybuy.service.NewsServiceImpl;
import com.easybuy.service.OrderService;
import com.easybuy.service.OrderServiceImpl;
import com.easybuy.service.ProductServiceImpl;
import com.easybuy.service.UserAddressServiceImpl;
import com.easybuy.service.UserServiceImpl;
import com.easybuy.utils.RegUtils;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class BackServlet
 */
public class BackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageSize = 10;
	ProductServiceImpl psi = new ProductServiceImpl();
	UserServiceImpl usi = new UserServiceImpl();
	OrderServiceImpl osi = new OrderServiceImpl();
	NewsServiceImpl nsi = new NewsServiceImpl();
	UserAddressServiceImpl uasi = new UserAddressServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackServlet() {
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
		if (!StringUtils.isNullOrEmpty(aim)) {
			if ("order".equals(aim)) {
				initOrder(request, response);
			} else if ("productList".equals(aim)) {
				initProductList(request, response);
			} else if ("userList".equals(aim)) {
				initUserList(request, response);
			} else if ("orderList".equals(aim)) {
				initOrderList(request, response);
			} else if ("newsList".equals(aim)) {
				initNewsList(request, response);
			} else if ("addUser".equals(aim)) {
				addUser(request, response);
			} else if ("categoryList".equals(aim)) {
				initCategoryList(request, response);
			} else if ("userAddressList".equals(aim)) {
				initUserAddressList(request, response);
			}
		}
	}

	// 我的订单
	public void initOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		OrderService osi = new OrderServiceImpl();
		List<Order> orderList = osi.queryOrdersByUserId(user.getId() + "");
		request.getSession().setAttribute("orderList", orderList);
		response.sendRedirect(request.getContextPath() + "/back/order.jsp");
	}

	// 全部商品
	public void initProductList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String error = request.getParameter("error");
		String currt = request.getParameter("currentPageNo");
		// 当前页
		int currPageNo = 0;
		if (currt == null || currt == "") {
			currPageNo = 1;
		} else {
			currPageNo = Integer.parseInt(currt);
		}
		Page<Product> productPage = null;
		productPage = psi.queryProductPage(currPageNo, pageSize);
		request.getSession().setAttribute("productPage", productPage);
		if ("yes".equals(error)) {
			response.sendRedirect(request.getContextPath()
					+ "/back/productList.jsp?error=yes");
		} else if ("no".equals(error)) {
			response.sendRedirect(request.getContextPath()
					+ "/back/productList.jsp?error=no");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/back/productList.jsp");
		}
	}

	// 所有用户
	public void initUserList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String error = request.getParameter("error");
		String currt = request.getParameter("currentPageNo");
		// 当前页
		int currPageNo = 0;
		if (currt == null || currt == "") {
			currPageNo = 1;
		} else {
			currPageNo = Integer.parseInt(currt);
		}
		Page<User> userPage = null;
		userPage = usi.queryUserList(currPageNo, pageSize);
		request.getSession().setAttribute("userPage", userPage);
		if ("yes".equals(error)) {
			response.sendRedirect(request.getContextPath()
					+ "/back/userList.jsp?error=yes");
		} else if ("no".equals(error)) {
			response.sendRedirect(request.getContextPath()
					+ "/back/userList.jsp?error=no");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/back/userList.jsp");
		}
	}

	// 所有订单
	public void initOrderList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String currt = request.getParameter("currentPageNo");
		// 当前页
		int currPageNo = 0;
		if (currt == null || currt == "") {
			currPageNo = 1;
		} else {
			currPageNo = Integer.parseInt(currt);
		}
		Page<Order> orderPage = null;
		orderPage = osi.queryOrderList(currPageNo, 3);
		request.getSession().setAttribute("orderPage", orderPage);
		response.sendRedirect(request.getContextPath() + "/back/orderList.jsp");
	}

	// 资讯列表
	public void initNewsList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String error = request.getParameter("error");
		String currt = request.getParameter("currentPageNo");
		// 当前页
		int currPageNo = 0;
		if (currt == null || currt == "") {
			currPageNo = 1;
		} else {
			currPageNo = Integer.parseInt(currt);
		}
		Page<News> newsPage = null;
		newsPage = nsi.queryNewsPage(currPageNo, pageSize);
		request.getSession().setAttribute("newsPage", newsPage);
		if ("yes".equals(error)) {
			response.sendRedirect(request.getContextPath()
					+ "/back/newsList.jsp?error=yes");
		} else if ("no".equals(error)) {
			response.sendRedirect(request.getContextPath()
					+ "/back/newsList.jsp?error=no");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/back/newsList.jsp");
		}
	}

	// 添加用户
	public void addUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String loginName = request.getParameter("loginName");
		String userName = request.getParameter("userName");
		String identityCode = request.getParameter("identityCode");
		String password = request.getParameter("password1");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String type = request.getParameter("type");
		User user = new User(loginName, userName, password,
				Integer.parseInt(sex), identityCode, email, mobile,
				Integer.parseInt(type), 0);
		UserServiceImpl usi = new UserServiceImpl();
		boolean flag = false;
		if (RegUtils.checkMobile(mobile) && RegUtils.checkEmail(email)
				&& RegUtils.checkIdentityCodeReg(identityCode)) {
			flag = usi.regist(user);
		}
		response.sendRedirect(request.getContextPath() + "/back?aim=userList");
	}

	// 分类管理
	public void initCategoryList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String error = request.getParameter("error");
		String currt = request.getParameter("currentPageNo");
		// 当前页
		int currPageNo = 0;
		if (currt == null || currt == "") {
			currPageNo = 1;
		} else {
			currPageNo = Integer.parseInt(currt);
		}
		Page<Product_category> product_categoryPage = null;
		product_categoryPage = psi.queryMenu(currPageNo, pageSize);
		request.getSession().setAttribute("product_categoryPage",
				product_categoryPage);
		if ("yes".equals(error)) {
			response.sendRedirect(request.getContextPath()
					+ "/back/categoryList.jsp?error=yes");
		} else if ("no".equals(error)) {
			response.sendRedirect(request.getContextPath()
					+ "/back/categoryList.jsp?error=no");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/back/categoryList.jsp");
		}

	}

	// 用户地址
	public void initUserAddressList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String currt = request.getParameter("currentPageNo");
		User user = (User) request.getSession().getAttribute("user");
		// 当前页
		int currPageNo = 0;
		if (currt == null || currt == "") {
			currPageNo = 1;
		} else {
			currPageNo = Integer.parseInt(currt);
		}
		Page<UserAddress> userAddressPage = null;
		userAddressPage = uasi.queryUserAddressList(user.getId(), currPageNo,
				pageSize);
		request.getSession().setAttribute("userAddressPage", userAddressPage);
		response.sendRedirect(request.getContextPath()
				+ "/back/userAddressList.jsp");
	}

}
