package com.easybuy.service;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.entity.Order;
import com.easybuy.entity.Page;
import com.easybuy.entity.Product_category;
import com.easybuy.entity.User;

public interface OrderService {

	/*
	 * 根据用户id查询订单
	 */
	List<Order> queryOrdersByUserId(String id);

	/*
	 * 分页查询
	 */
	Page<Order> queryOrderList(Integer currentPageNo, Integer pageSize);

	/*
	 * 创建新的订单
	 */
	int createNewOrder(Order order);

	/*
	 * 获得最新创建的订单id
	 */
	int getId();
}
