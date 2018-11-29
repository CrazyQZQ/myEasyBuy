package com.easybuy.entity;

import java.io.Serializable;

/**
 * 
 * <一句话功能简述>
 * 
 * @author 秦强
 * @version [V1.00, 2018年9月27日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class OrderDetail implements Serializable {
	private Integer id;// ID
	private Integer orderId;// 订单ID
	private Integer quantity;// 数量
	private double cost;// 单价
	private Integer productId;

	private Product product;// 商品

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(Integer orderId, Integer quantity, double cost,
			Integer productId, Product product) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.cost = cost;
		this.productId = productId;
		this.product = product;
	}

	public OrderDetail(Integer id, Integer orderId, Integer quantity,
			double cost, Integer productId, Product product) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.quantity = quantity;
		this.cost = cost;
		this.productId = productId;
		this.product = product;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}
}
