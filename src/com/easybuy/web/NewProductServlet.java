package com.easybuy.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;
import com.easybuy.entity.Product;
import com.easybuy.entity.Product_category;
import com.easybuy.service.ProductServiceImpl;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class NewProductServlet
 */
public class NewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl psi = new ProductServiceImpl();
		String action = request.getParameter("action");
		String jibie = request.getParameter("jibie");
		String aim = request.getParameter("aim");

		// 初始化一级分类
		if (!StringUtils.isNullOrEmpty(action)) {
			List<Product_category> firMenu = psi.queryMenu(0);
			request.getSession().setAttribute("firMenu", firMenu);
			response.sendRedirect(request.getContextPath()
					+ "/back/newProduct.jsp");
		} else if (!StringUtils.isNullOrEmpty(jibie)) {// 使用ajax
			String id = request.getParameter("id");
			if ("first".equals(jibie)) {// 使用ajax切换一级分类时改变二级分类
				List<Product_category> secondMenu = psi.queryMenu(Integer
						.parseInt(id));
				String sm = JSON.toJSONString(secondMenu);
				PrintWriter out = response.getWriter();
				out.print(sm);
			} else if ("second".equals(jibie)) {// 使用ajax切换二级分类时改变三级分类
				List<Product_category> thirdMenu = psi.queryMenu(Integer
						.parseInt(id));
				String tm = JSON.toJSONString(thirdMenu);
				PrintWriter out = response.getWriter();
				out.print(tm);
			}
		} else if (!StringUtils.isNullOrEmpty(aim)) {// 商品上架
			File fe = new File(
					"E:\\java_workspace\\easybuy\\WebContent\\statics\\common\\images");
			if (!fe.isDirectory() && !fe.exists()) {
				fe.mkdirs();
			}
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			Product product = new Product();
			boolean mpc = ServletFileUpload.isMultipartContent(request);
			if (mpc) {
				try {
					List<FileItem> parseRequest = upload.parseRequest(request);
					for (FileItem item : parseRequest) {
						if (item.isFormField()) {
							String name = item.getFieldName();
							String value = item.getString("UTF-8");
							if (name.equals("yiji")) {
								product.setCategoryLevel1Id(Integer
										.parseInt(value));
							} else if (name.equals("erji")) {
								product.setCategoryLevel2Id(Integer
										.parseInt(value));
							} else if (name.equals("sanji")) {
								product.setCategoryLevel3Id(Integer
										.parseInt(value));
							} else if (name.equals("cattegoryName")) {
								product.setName(value);
							} else if (name.equals("price")) {
								product.setPrice(Double.parseDouble(value));
							} else if (name.equals("stock")) {
								product.setStock(Integer.parseInt(value));
							} else if (name.equals("description")) {
								product.setDescription(value);
							}
						} else {
							String fieldName = item.getName();
							String[] temp = fieldName.split("////");
							if (temp.length > 1) {
								fieldName = temp[temp.length - 1];
							}
							product.setFileName(fieldName);
							File file = new File(
									"E:\\java_workspace\\easybuy\\WebContent\\statics\\common\\images",
									fieldName);
							item.write(file);
						}
					}
					psi.addProduct(product);
					response.sendRedirect(request.getContextPath()
							+ "/back?aim=productList");
				} catch (FileUploadException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				response.getWriter().print("文件不合法");
			}
		}
	}

}
