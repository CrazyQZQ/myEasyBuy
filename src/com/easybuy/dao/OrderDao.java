package com.easybuy.dao;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.entity.Order;
import com.easybuy.entity.OrderDetail;

public interface OrderDao {

	/*
	 * 根据用户id查询订单
	 */
	List<Order> queryOrdersByUserId(String id) throws SQLException;

	/*
	 * 根据订单id查询订单详情
	 */
	List<OrderDetail> queryOrdersByOrderId(String id) throws SQLException;

	/*
	 * 分页查询
	 */
	List<Order> queryOrders(Integer currentPageNo, Integer pageSize)
			throws SQLException;

	/*
	 * 创建新的订单
	 */
	int createNewOrder(Order order) throws SQLException;

	/*
	 * 获得最新创建的订单id
	 */
	int getId() throws SQLException;
}
