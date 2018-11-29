package com.easybuy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * <一句话功能简述>
 * 
 * @author 秦强
 * @version [V1.00, 2018年9月27日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class Order implements Serializable {

	private Integer id;// ID
	private String serialNumber;
	private Integer userId;// 登录id
	private String userAddress;// 收货地址
	private Date createTime;// 创建时间
	private Double cost;// 订单总计价格

	private String loginName;// 登录名

	private List<OrderDetail> orderDetailList;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, String serialNumber, Integer userId,
			String userAddress, Date createTime, Double cost, String loginName,
			List<OrderDetail> orderDetailList) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.userId = userId;
		this.userAddress = userAddress;
		this.createTime = createTime;
		this.cost = cost;
		this.loginName = loginName;
		this.orderDetailList = orderDetailList;
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public int getId() {
		return id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Order) {
			if (((Order) obj).id == id) {
				return true;
			}
		}
		return false;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
}
