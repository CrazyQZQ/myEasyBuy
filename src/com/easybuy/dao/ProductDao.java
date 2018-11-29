package com.easybuy.dao;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.entity.Product;
import com.easybuy.entity.Product_category;

public interface ProductDao {
	/*
	 * 查询所有分类信息
	 */
	List<Product_category> queryMenu(Integer currentPageNo, Integer pageSize)
			throws SQLException;

	/*
	 * 根据parentId查询菜单
	 */
	List<Product_category> queryMenu(int id) throws SQLException;

	/*
	 * 根据1/2/3级菜单id查询商品
	 */
	List<Product> queryGoodsByFirMenu(Integer id, Integer currentPageNo,
			Integer pageSize) throws SQLException;

	/*
	 * 模糊查询
	 */
	List<Product> queryGoodsByFirMess(String mess, Integer currentPageNo,
			Integer pageSize) throws SQLException;

	/*
	 * 根据ID查询商品
	 */
	public Product qeuryProductById(int id) throws SQLException;

	/*
	 * 分页查询所有商品
	 */
	List<Product> queryAllProduct(Integer currentPageNo, Integer pageSize)
			throws SQLException;

	/*
	 * 增加分类
	 */
	int addCategory(Product_category product_category) throws SQLException;

	/*
	 * 增加商品
	 */
	int addProduct(Product product) throws SQLException;

	/*
	 * 删除分类
	 */
	int deleteCategory(int id) throws SQLException;

	/*
	 * 删除商品
	 */
	int deleteProduct(int id) throws SQLException;

	/*
	 * 修改商品
	 */
	int updateProduct(Product product) throws SQLException;
}
