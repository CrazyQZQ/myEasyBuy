package com.easybuy.service;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.entity.Page;
import com.easybuy.entity.Product;
import com.easybuy.entity.Product_category;
import com.easybuy.utils.Product_categoryUtil;

public interface ProductService {
	/*
	 * 根据parentId查询菜单
	 */
	List<Product_category> queryMenu(int id);

	/*
	 * 查询所有分类信息
	 */
	Page<Product_category> queryMenu(Integer currentPageNo, Integer pageSize);

	/*
	 * 根据1级&&2级菜单查询出3级菜单
	 */
	List<Product_categoryUtil> queryAllMenu();

	/*
	 * 根据1/2/3级菜单查询商品列表
	 */
	List<Product> queryGoodsByFirMenu(Integer id, Integer currentPageNo,
			Integer pageSize);

	/*
	 * 根据1/2/3级菜单查询page对象
	 */
	Page<Product> queryPageByFirMenu(Integer id, Integer currentPageNo,
			Integer pageSize);

	/*
	 * 模糊查询商品列表
	 */
	List<Product> queryGoodsByFirMess(String mess, Integer currentPageNo,
			Integer pageSize);

	/*
	 * 模糊查询page对象
	 */
	Page<Product> queryPageByFirMess(String mess, Integer currentPageNo,
			Integer pageSize);

	/*
	 * 根据ID查询商品
	 */
	Product qeuryProductById(int id);

	/*
	 * 使用page展示商品
	 */
	Page<Product> queryProductPage(Integer currentPageNo, Integer pageSize);

	/*
	 * 增加分类
	 */
	int addCategory(Product_category product_category);

	/*
	 * 增加商品
	 */
	int addProduct(Product product);

	/*
	 * 删除分类
	 */
	int deleteCategory(int id);

	/*
	 * 删除商品
	 */
	int deleteProduct(int id);

	/*
	 * 修改商品
	 */
	int updateProduct(Product product);
}
