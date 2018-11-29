package com.easybuy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.ProductDao;
import com.easybuy.dao.ProductDaoImpl;
import com.easybuy.entity.Order;
import com.easybuy.entity.Page;
import com.easybuy.entity.Product;
import com.easybuy.entity.Product_category;
import com.easybuy.utils.Product_categoryUtil;

public class ProductServiceImpl implements ProductService {
	private ProductDao pd;

	public ProductServiceImpl() {
		this.pd = new ProductDaoImpl();
	}

	/*
	 * 根据parentId查询菜单
	 */
	@Override
	public List<Product_category> queryMenu(int id) {
		List<Product_category> product_categoryList = new ArrayList<Product_category>();
		try {
			product_categoryList = pd.queryMenu(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product_categoryList;
	}

	/*
	 * 查询所有分类信息
	 */
	@Override
	public Page<Product_category> queryMenu(Integer currentPageNo,
			Integer pageSize) {
		Page<Product_category> page = null;
		List<Product_category> product_categoryList = new ArrayList<Product_category>();
		try {
			product_categoryList = pd.queryMenu(currentPageNo, pageSize);
			int totalCount = pd.queryMenu(null, null).size();
			page = new Page<Product_category>(currentPageNo, pageSize,
					totalCount, product_categoryList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	/*
	 * 根据1级&&2级菜单查询出3级菜单
	 */
	@Override
	public List<Product_categoryUtil> queryAllMenu() {
		// 1级菜工具单集合
		List<Product_categoryUtil> pcu1List = new ArrayList<Product_categoryUtil>();
		try {
			// 1级菜单集合
			List<Product_category> pc1List = pd.queryMenu(0);
			for (Product_category product_category : pc1List) {
				Product_categoryUtil pc1 = new Product_categoryUtil();
				pc1.setProduct_category(product_category);
				// 2级菜工具单集合
				List<Product_categoryUtil> pcu2List = new ArrayList<Product_categoryUtil>();
				// 2级菜单集合
				List<Product_category> pc2List = pd.queryMenu(product_category
						.getId());
				for (Product_category product_category2 : pc2List) {
					Product_categoryUtil pc2 = new Product_categoryUtil();
					pc2.setProduct_category(product_category2);
					// 3级菜工具单集合
					List<Product_categoryUtil> pcu3List = new ArrayList<Product_categoryUtil>();
					// 3级菜单集合
					List<Product_category> pc3List = pd
							.queryMenu(product_category2.getId());
					for (Product_category product_category3 : pc3List) {
						Product_categoryUtil pc3 = new Product_categoryUtil();
						pc3.setProduct_category(product_category3);
						pcu3List.add(pc3);
					}
					pc2.setPcList(pcu3List);
					pcu2List.add(pc2);
				}

				pc1.setPcList(pcu2List);
				pcu1List.add(pc1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pcu1List;
	}

	/*
	 * 根据1/2/3级菜单查询商品列表
	 */
	@Override
	public List<Product> queryGoodsByFirMenu(Integer id, Integer currentPageNo,
			Integer pageSize) {
		List<Product> productList = new ArrayList<Product>();
		try {
			productList = pd.queryGoodsByFirMenu(id, currentPageNo, pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	/*
	 * 模糊查询商品列表
	 */
	@Override
	public List<Product> queryGoodsByFirMess(String mess,
			Integer currentPageNo, Integer pageSize) {
		List<Product> productList = new ArrayList<Product>();
		try {
			productList = pd.queryGoodsByFirMess(mess, currentPageNo, pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	/*
	 * 根据1/2/3级菜单查询page对象
	 */
	@Override
	public Page<Product> queryPageByFirMenu(Integer id, Integer currentPageNo,
			Integer pageSize) {
		Page<Product> page = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			productList = pd.queryGoodsByFirMenu(id, currentPageNo, pageSize);
			int totalCount = pd.queryGoodsByFirMenu(id, null, null).size();
			page = new Page<Product>(currentPageNo, pageSize, totalCount,
					productList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	/*
	 * 模糊查询page对象
	 */
	@Override
	public Page<Product> queryPageByFirMess(String mess, Integer currentPageNo,
			Integer pageSize) {
		Page<Product> page = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			productList = pd.queryGoodsByFirMess(mess, currentPageNo, pageSize);
			int totalCount = pd.queryGoodsByFirMess(mess, null, null).size();
			page = new Page<Product>(currentPageNo, pageSize, totalCount,
					productList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	/*
	 * 根据ID查询商品
	 */
	@Override
	public Product qeuryProductById(int id) {
		Product product = null;
		try {
			product = pd.qeuryProductById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	/*
	 * 使用page展示商品
	 */
	@Override
	public Page<Product> queryProductPage(Integer currentPageNo,
			Integer pageSize) {
		Page<Product> page = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			productList = pd.queryAllProduct(currentPageNo, pageSize);
			int totalCount = pd.queryAllProduct(null, null).size();
			page = new Page<Product>(currentPageNo, pageSize, totalCount,
					productList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	/*
	 * 增加分类
	 */
	@Override
	public int addCategory(Product_category product_category) {
		int result = 0;
		try {
			result = pd.addCategory(product_category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 增加商品
	 */
	@Override
	public int addProduct(Product product) {
		int result = 0;
		try {
			result = pd.addProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 删除分类
	 */
	@Override
	public int deleteCategory(int id) {
		int result = 0;
		try {
			result = pd.deleteCategory(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 删除商品
	 */
	@Override
	public int deleteProduct(int id) {
		int result = 0;
		try {
			result = pd.deleteProduct(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 修改商品
	 */
	@Override
	public int updateProduct(Product product) {
		int result = 0;
		try {
			result = pd.updateProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
