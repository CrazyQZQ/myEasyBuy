package com.easybuy.utils;

import java.io.Serializable;
import java.util.List;

import com.easybuy.entity.Product_category;

/**
 * 保存各级菜单以及其子菜单信息 <一句话功能简述>
 * 
 * @author 秦强
 * @version [V1.00, 2018年9月27日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class Product_categoryUtil implements Serializable {
	private Product_category product_category;
	private List<Product_categoryUtil> pcList;

	public Product_category getProduct_category() {
		return product_category;
	}

	public void setProduct_category(Product_category product_category) {
		this.product_category = product_category;
	}

	public List<Product_categoryUtil> getPcList() {
		return pcList;
	}

	public void setPcList(List<Product_categoryUtil> pcList) {
		this.pcList = pcList;
	}

}
