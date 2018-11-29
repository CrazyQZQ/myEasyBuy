package com.easybuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.entity.Product;
import com.easybuy.entity.Product_category;
import com.easybuy.utils.JdbcUtil;

public class ProductDaoImpl extends BaseDao implements ProductDao {
	/*
	 * 查询所有分类信息
	 */
	@Override
	public List<Product_category> queryMenu(Integer currentPageNo,
			Integer pageSize) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"select * from easybuy_product_category order by type");
		List<Object> params = new ArrayList<Object>();
		if (currentPageNo != null) {
			params.add((currentPageNo - 1) * pageSize);
			params.add(pageSize);
			sql.append(" limit ?,?");
		}
		ResultSet rs = excuteSelect(sql.toString(), params.toArray());
		List<Product_category> product_categoryList = new ArrayList<Product_category>();
		while (rs.next()) {
			Product_category product_category = new Product_category(
					rs.getInt("id"), rs.getString("name"),
					rs.getInt("parentId"), rs.getInt("type"),
					rs.getString("iconClass"));
			String parentName;
			if (product_category.getParentId() == 0) {
				parentName = "无";
			} else {
				if (queryMenuById(product_category.getParentId()).size() > 0) {
					parentName = queryMenuById(product_category.getParentId())
							.get(0).getName();
				} else {
					parentName = "无";
				}
			}
			product_category.setParentName(parentName);
			product_categoryList.add(product_category);
		}
		return product_categoryList;
	}

	/*
	 * 根据Id查询菜单
	 */
	public List<Product_category> queryMenuById(int id) throws SQLException {
		String sql = "select * from easybuy_product_category where Id=?";
		Object[] params = { id };
		ResultSet rs = excuteSelect(sql, params);
		List<Product_category> product_categoryList = new ArrayList<Product_category>();
		while (rs.next()) {
			Product_category product_category = new Product_category(
					rs.getInt("id"), rs.getString("name"),
					rs.getInt("parentId"), rs.getInt("type"),
					rs.getString("iconClass"));
			product_categoryList.add(product_category);
		}
		return product_categoryList;
	}

	/*
	 * 根据parentId查询菜单
	 */
	@Override
	public List<Product_category> queryMenu(int id) throws SQLException {
		String sql = "select * from easybuy_product_category where parentId=?";
		Object[] params = { id };
		ResultSet rs = excuteSelect(sql, params);
		List<Product_category> product_categoryList = new ArrayList<Product_category>();
		while (rs.next()) {
			Product_category product_category = new Product_category(
					rs.getInt("id"), rs.getString("name"),
					rs.getInt("parentId"), rs.getInt("type"),
					rs.getString("iconClass"));
			product_categoryList.add(product_category);
		}
		return product_categoryList;
	}

	/*
	 * 根据ID查询商品
	 */
	@Override
	public List<Product> queryGoodsByFirMenu(Integer id, Integer currentPageNo,
			Integer pageSize) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"select * from easybuy_product where categoryLevel1Id=? or categoryLevel2Id=? or categoryLevel3Id=?");
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		params.add(id);
		params.add(id);
		if (currentPageNo != null) {
			params.add((currentPageNo - 1) * pageSize);
			params.add(pageSize);
			sql.append(" limit ?,?");
		}
		ResultSet rs = excuteSelect(sql.toString(), params.toArray());
		List<Product> productList = new ArrayList<Product>();
		while (rs.next()) {
			Product product = new Product(rs.getInt("id"),
					rs.getString("name"), rs.getString("description"),
					rs.getDouble("price"), rs.getInt("stock"),
					rs.getInt("categoryLevel1Id"),
					rs.getInt("categoryLevel2Id"),
					rs.getInt("categoryLevel3Id"), rs.getString("fileName"),
					rs.getInt("isDelete"));
			productList.add(product);
		}
		return productList;
	}

	/*
	 * 模糊查询
	 */
	@Override
	public List<Product> queryGoodsByFirMess(String mess,
			Integer currentPageNo, Integer pageSize) throws SQLException {
		Connection conn = JdbcUtil.getConnection();
		StringBuffer sql = new StringBuffer(
				"select * from  easybuy_product where name like ?");
		List<Object> params = new ArrayList<Object>();
		params.add(mess);
		if (currentPageNo != null) {
			params.add((currentPageNo - 1) * pageSize);
			params.add(pageSize);
			sql.append("limit ?,?");
		}
		PreparedStatement pstm = conn.prepareStatement(sql.toString());
		pstm.setString(1, "%" + mess + "%");
		for (int i = 1; i < params.size(); i++) {
			pstm.setObject(i + 1, params.get(i));
		}

		ResultSet rs = pstm.executeQuery();
		List<Product> productList = new ArrayList<Product>();
		while (rs.next()) {
			Product product = new Product(rs.getInt("id"),
					rs.getString("name"), rs.getString("description"),
					rs.getDouble("price"), rs.getInt("stock"),
					rs.getInt("categoryLevel1Id"),
					rs.getInt("categoryLevel2Id"),
					rs.getInt("categoryLevel3Id"), rs.getString("fileName"),
					rs.getInt("isDelete"));
			productList.add(product);
		}
		return productList;
	}

	/*
	 * 根据ID查询商品
	 */
	@Override
	public Product qeuryProductById(int id) throws SQLException {
		String sql = "select * from easybuy_product where id=?";
		Object[] params = { id };
		ResultSet rs = excuteSelect(sql, params);
		Product product = new Product();
		while (rs.next()) {
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getDouble("price"));
			product.setStock(rs.getInt("stock"));
			product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
			product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
			product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
			product.setFileName(rs.getString("fileName"));
			product.setIsDelete(rs.getInt("isDelete"));
		}
		return product;
	}

	/*
	 * 分页查询所有商品
	 */
	@Override
	public List<Product> queryAllProduct(Integer currentPageNo, Integer pageSize)
			throws SQLException {
		StringBuffer sql = new StringBuffer("select * from easybuy_product");
		List<Object> params = new ArrayList<Object>();
		if (currentPageNo != null) {
			params.add((currentPageNo - 1) * pageSize);
			params.add(pageSize);
			sql.append(" limit ?,?");
		}
		ResultSet rs = excuteSelect(sql.toString(), params.toArray());
		List<Product> proList = new ArrayList<Product>();
		while (rs.next()) {
			Product product = new Product(rs.getInt("id"),
					rs.getString("name"), rs.getString("description"),
					rs.getDouble("price"), rs.getInt("stock"),
					rs.getInt("categoryLevel1Id"),
					rs.getInt("categoryLevel2Id"),
					rs.getInt("categoryLevel3Id"), rs.getString("fileName"),
					rs.getInt("isDelete"));
			proList.add(product);
		}
		return proList;
	}

	/*
	 * 增加分类
	 */
	@Override
	public int addCategory(Product_category product_category)
			throws SQLException {
		String sql = "insert into easybuy_product_category (name,parentId,type,iconClass) values(?,?,?,?)";
		Object[] params = { product_category.getName(),
				product_category.getParentId(), product_category.getType(),
				product_category.getIconClass() };
		int result = excuteUpdate(sql, params);
		return result;
	}

	/*
	 * 增加商品
	 */
	@Override
	public int addProduct(Product product) throws SQLException {
		String sql = "insert into easybuy_product (name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete) values(?,?,?,?,?,?,?,?,?)";
		Object[] params = { product.getName(), product.getDescription(),
				product.getPrice(), product.getStock(),
				product.getCategoryLevel1Id(), product.getCategoryLevel2Id(),
				product.getCategoryLevel3Id(), product.getFileName(), 0 };
		int result = excuteUpdate(sql, params);
		return result;
	}

	/*
	 * 删除分类
	 */
	@Override
	public int deleteCategory(int id) throws SQLException {
		int result = 0;
		// 查询该分类下有没有子类
		List<Product_category> product_categoryList = queryMenu(id);
		// 查询该分类下有没有商品
		List<Product> productList = queryGoodsByFirMenu(id, null, null);
		if (product_categoryList.size() == 0 && productList.size() == 0) {
			String sql = "delete from easybuy_product_category where id=?";
			Object[] params = { id };
			result = excuteUpdate(sql, params);
		}
		return result;
	}

	/*
	 * 删除商品
	 */
	@Override
	public int deleteProduct(int id) throws SQLException {
		int result = 0;
		String sql = "delete from easybuy_product where id=?";
		Object[] params = { id };
		result = excuteUpdate(sql, params);
		return result;
	}

	/*
	 * 修改商品
	 */
	@Override
	public int updateProduct(Product product) throws SQLException {
		int result = 0;
		String sql = "update easybuy_product set name=?,description=?,price=?,stock=?,"
				+ "categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,fileName=?,isDelete=? where id=?";
		Object[] params = { product.getName(), product.getDescription(),
				product.getPrice(), product.getStock(),
				product.getCategoryLevel1Id(), product.getCategoryLevel2Id(),
				product.getCategoryLevel3Id(), product.getFileName(),
				product.getIsDelete(), product.getId() };
		result = excuteUpdate(sql, params);
		return result;
	}
}
