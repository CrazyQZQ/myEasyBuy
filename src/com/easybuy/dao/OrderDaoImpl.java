package com.easybuy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.entity.Order;
import com.easybuy.entity.OrderDetail;
import com.easybuy.entity.Product;
import com.easybuy.entity.User;

public class OrderDaoImpl extends BaseDao implements OrderDao {
	/*
	 * 根据用户id查询订单
	 */
	@Override
	public List<Order> queryOrdersByUserId(String id) throws SQLException {
		String sql = "select * from easybuy_order where userId=?";
		Object[] params = { id };
		ResultSet rs = excuteSelect(sql, params);
		List<Order> orderList = new ArrayList<Order>();
		while (rs.next()) {
			Order order = new Order(rs.getInt("id"),
					rs.getString("serialNumber"), rs.getInt("userId"),
					rs.getString("userAddress"), rs.getTimestamp("createTime"),
					rs.getDouble("cost"), rs.getString("loginName"), null);
			List<OrderDetail> orderDetailList = queryOrdersByOrderId(order
					.getId() + "");
			order.setOrderDetailList(orderDetailList);
			orderList.add(order);
		}
		return orderList;
	}

	/*
	 * 根据订单id查询订单详情
	 */
	@Override
	public List<OrderDetail> queryOrdersByOrderId(String id)
			throws SQLException {
		ProductDao pd = new ProductDaoImpl();
		String sql = "select * from easybuy_order_detail where orderId=?";
		Object[] params = { id };
		ResultSet rs = excuteSelect(sql, params);
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		while (rs.next()) {
			OrderDetail orderDetail = new OrderDetail(rs.getInt("id"),
					rs.getInt("orderId"), rs.getInt("quantity"),
					rs.getFloat("cost"), rs.getInt("productId"), null);
			Product product = pd.qeuryProductById(orderDetail.getProductId());
			orderDetail.setProduct(product);
			orderDetailList.add(orderDetail);
		}
		return orderDetailList;
	}

	/*
	 * 分页查询
	 */
	@Override
	public List<Order> queryOrders(Integer currentPageNo, Integer pageSize)
			throws SQLException {
		StringBuffer sql = new StringBuffer("select * from easybuy_order");
		List<Object> params = new ArrayList<Object>();
		if (currentPageNo != null) {
			params.add((currentPageNo - 1) * pageSize);
			params.add(pageSize);
			sql.append(" limit ?,?");
		}
		ResultSet rs = excuteSelect(sql.toString(), params.toArray());
		List<Order> orderList = new ArrayList<Order>();
		while (rs.next()) {
			Order order = new Order(rs.getInt("id"),
					rs.getString("serialNumber"), rs.getInt("userId"),
					rs.getString("userAddress"), rs.getTimestamp("createTime"),
					rs.getDouble("cost"), rs.getString("loginName"), null);
			List<OrderDetail> orderDetailList = queryOrdersByOrderId(order
					.getId() + "");
			order.setOrderDetailList(orderDetailList);
			orderList.add(order);
		}
		return orderList;
	}

	/*
	 * 创建新的订单
	 */
	@Override
	public int createNewOrder(Order order) throws SQLException {
		int result = 0;
		String sql = "insert into easybuy_order (userId,loginName,userAddress,createTime,cost,serialNumber) values(?,?,?,?,?,?)";
		Object[] params = { order.getUserId(), order.getLoginName(),
				order.getUserAddress(), order.getCreateTime(), order.getCost(),
				order.getSerialNumber() };
		for (OrderDetail orderDetail : order.getOrderDetailList()) {
			String sqlTemp = "insert into easybuy_order_detail (orderId,productId,quantity,cost) values(?,?,?,?)";
			Object[] paramsTemp = { orderDetail.getOrderId(),
					orderDetail.getProductId(), orderDetail.getQuantity(),
					orderDetail.getCost() };
			excuteUpdate(sqlTemp, paramsTemp);
			// 修改库存
			orderDetail.getProduct().setStock(
					orderDetail.getProduct().getStock()
							- orderDetail.getQuantity());
		}
		result = excuteUpdate(sql, params);
		return result;
	}

	/*
	 * 获得最新创建的订单id
	 */
	@Override
	public int getId() throws SQLException {
		String sql = "select max(id) from easybuy_order";
		ResultSet rs = excuteSelect(sql, null);
		int id = 0;
		if (rs.next()) {
			id = rs.getInt(1) + 1;
		}
		return id;
	}
}
