package com.easybuy.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.Order;
import com.easybuy.entity.OrderDetail;
import com.easybuy.entity.ShoppingCart;
import com.easybuy.entity.ShoppingCartItem;
import com.easybuy.entity.User;
import com.easybuy.entity.UserAddress;
import com.easybuy.service.OrderServiceImpl;
import com.easybuy.service.UserAddressServiceImpl;
import com.easybuy.utils.UuidUtils;

/**
 * Servlet implementation class NewOrderServlet
 */
public class NewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserAddressServiceImpl uasi = new UserAddressServiceImpl();
	private OrderServiceImpl osi = new OrderServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewOrderServlet() {
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
		String action = request.getParameter("action");
		if ("two".equals(action)) {
			gotoTwo(request, response);
		} else if ("three".equals(action)) {
			gotoThree(request, response);
		}
	}

	public void gotoTwo(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 查询出该用户的所有收货地址
		User user = (User) request.getSession().getAttribute("user");
		List<UserAddress> userAddressList = uasi.queryUserAdressByUserId(user
				.getId());
		request.getSession().setAttribute("userAddressList", userAddressList);
		response.sendRedirect(request.getContextPath() + "/back/buycar_two.jsp");
	}

	public void gotoThree(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		String addressId = request.getParameter("adressId");
		String adress = request.getParameter("adress");
		String remark = request.getParameter("remark");
		UserAddress userAddress = null;
		if ("-1".equals(addressId)) {// 此时用户选择新建地址
			userAddress = new UserAddress(adress, user.getId(), new Date(),
					remark, 0);
			uasi.createNewAddress(userAddress);
		} else {
			userAddress = uasi.queryAddressById(Integer.parseInt(addressId));
		}
		// 得到购物车
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession()
				.getAttribute("shoppingCart");
		// 遍历商品项
		int orderId = osi.getId();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		for (ShoppingCartItem shoppingCartItem : shoppingCart.getItems()) {
			// 创建订单详情
			OrderDetail orderDetail = new OrderDetail(orderId,
					shoppingCartItem.getQuantity(), shoppingCartItem.getCost(),
					shoppingCartItem.getProduct().getId(),
					shoppingCartItem.getProduct());
			orderDetailList.add(orderDetail);
		}
		// 获得订单号
		String serialNumber = UuidUtils.randomUUID();
		// 创建新的订单
		Order order = new Order(orderId, serialNumber, user.getId(),
				userAddress.getAddress(), new Date(),
				shoppingCart.getTotalMoney(), user.getLoginName(),
				orderDetailList);
		osi.createNewOrder(order);
		request.getSession().setAttribute("nowAddress", userAddress);
		request.getSession().setAttribute("newOrder", order);
		response.sendRedirect(request.getContextPath()
				+ "/back/buycar_three.jsp");
	}

}
