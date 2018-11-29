package com.easybuy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 我的收藏
 * <一句话功能简述>
 *  
 * @author  秦强
 * @version  [V1.00, 2018年10月9日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class MyCollection implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private int maxSize = 10;//最大收藏数
	private List<Product> productList = new ArrayList<Product>();//收藏的商品项
	public MyCollection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyCollection(int maxSize, List<Product> productList) {
		super();
		this.maxSize = maxSize;
		this.productList = productList;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	/*
	 * 添加收藏
	 */
	public boolean addCollection(Product product){
		boolean flag = false;
		for (Product productTemp : productList) {
			if (productTemp.getId()==product.getId()) {//如果存在该商品则不添加
				flag = true;
				break;
			}
		}
		if ((!flag)&&(productList.size()<maxSize)) {//如果存在该商品且超过最大数则不添加
			productList.add(product);
			return true;
		}
		return false;
	}
	
	/*
	 * 移除收藏
	 */
	public boolean removeProduct(Product product){
		boolean flag = true;
		int index = -1;//记录下标
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getId()==product.getId()) {
				index = i;
				break;
			}
		}
		if (index!=-1) {
			productList.remove(index);
		}else {
			flag = false;
		}
		return flag;
	}
}
