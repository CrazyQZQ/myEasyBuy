package com.easybuy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.OrderDao;
import com.easybuy.dao.OrderDaoImpl;
import com.easybuy.entity.Order;
import com.easybuy.entity.Page;
import com.easybuy.entity.Product_category;
import com.easybuy.entity.User;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao;

	public OrderServiceImpl() {
		orderDao = new OrderDaoImpl();
	}

	/*
	 * 根据用户id查询订单
	 */
	@Override
	public List<Order> queryOrdersByUserId(String id) {
		List<Order> orderList = null;
		try {
			orderList = orderDao.queryOrdersByUserId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

	/*
	 * 分页查询
	 */
	@Override
	public Page<Order> queryOrderList(Integer currentPageNo, Integer pageSize) {
		Page<Order> page = null;
		List<Order> orderList = new ArrayList<Order>();
		try {
			orderList = orderDao.queryOrders(currentPageNo, pageSize);
			int totalCount = orderDao.queryOrders(null, null).size();
			page = new Page<Order>(currentPageNo, pageSize, totalCount,
					orderList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	/*
	 * 创建新的订单
	 */
	@Override
	public int createNewOrder(Order order) {
		int result = 0;
		try {
			result = orderDao.createNewOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 获得最新创建的订单id
	 */
	@Override
	public int getId() {
		int id = 0;
		try {
			id = orderDao.getId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}
