package com.easybuy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车类 <一句话功能简述>
 * 
 * @author 秦强
 * @version [V1.00, 2018年9月29日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class ShoppingCart implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
	private double totalMoney;
	private int shoppingCartItemNum;

	public List<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItem> items) {
		this.items = items;
	}

	public double getTotalMoney() {
		return getSum();
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getShoppingCartItemNum() {
		return items.size();
	}

	public void setShoppingCartItemNum(int shoppingCartItemNum) {
		this.shoppingCartItemNum = shoppingCartItemNum;
	}

	/*
	 * 加入购物车
	 */
	public boolean addToCart(Product product, Integer quantity) {
		boolean flag = false;
		// 遍历商品项
		for (ShoppingCartItem shoppingCartItem : items) {
			// 如果商品已存在
			if (shoppingCartItem.getProduct().getId() == product.getId()) {
				if ((shoppingCartItem.getQuantity() + quantity) < product
						.getStock()) {
					shoppingCartItem.setQuantity(shoppingCartItem.getQuantity()
							+ quantity);
				} else {
					return false;
				}
				flag = true;
				break;
			}
		}
		if (!flag) {
			ShoppingCartItem sci = new ShoppingCartItem(product, quantity);
			items.add(sci);
		}
		return false;
	}

	/*
	 * 计算总价
	 */
	public double getSum() {
		double sum = 0;
		for (ShoppingCartItem shoppingCartItem : items) {
			sum += shoppingCartItem.getProduct().getPrice()
					* shoppingCartItem.getQuantity();
		}
		return sum;
	}
}
