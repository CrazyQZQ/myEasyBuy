package com.easybuy.entity;

import java.io.Serializable;

/**
 * 购物车商品项 <一句话功能简述>
 * 
 * @author 秦强
 * @version [V1.00, 2018年9月29日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class ShoppingCartItem implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private Integer quantity;
	private double cost;

	public ShoppingCartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoppingCartItem(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
		this.cost = product.getPrice() * quantity;
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
		return product.getPrice() * quantity;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
