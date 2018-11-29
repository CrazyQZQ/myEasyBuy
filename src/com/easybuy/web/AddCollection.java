package com.easybuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.MyCollection;
import com.easybuy.entity.Product;
import com.easybuy.service.ProductServiceImpl;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class AddCollection
 */
public class AddCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCollection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl psi = new ProductServiceImpl();
		String action = request.getParameter("action");
		if ("clickAdd".equals(action)) {
			//获得我的收藏
			MyCollection myCollection = getMyCollection(request, response);
			String productId = request.getParameter("productId");
			Product product = psi.qeuryProductById(Integer.parseInt(productId));
			boolean result = myCollection.addCollection(product);
			if (result) {
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}else if("collection".equals(action)){
			initMyCollection(request, response);
		}else if("delete".equals(action)){
			String productId = request.getParameter("productId");
			Product product = psi.qeuryProductById(Integer.parseInt(productId));
			MyCollection myCollection = getMyCollection(request, response);
			boolean flag = myCollection.removeProduct(product);
			request.getSession().setAttribute("myCollection", myCollection);
			if (flag) {
				response.sendRedirect(request.getContextPath()+"/back/collection.jsp?error=no");
			}else {
				response.sendRedirect(request.getContextPath()+"/back/collection.jsp?error=yes");
			}
		}
	}
	
	//获得我的收藏
	public MyCollection getMyCollection(HttpServletRequest request, HttpServletResponse response){
		MyCollection myCollection = (MyCollection) request.getSession().getAttribute("myCollection");
		if (myCollection == null) {
			myCollection = new MyCollection();
			request.getSession().setAttribute("myCollection", myCollection);
		}
		return myCollection;
	}
	
	public void initMyCollection(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//获得我的收藏
		MyCollection myCollection = getMyCollection(request, response);
		request.getSession().setAttribute("myCollection", myCollection);
		response.sendRedirect(request.getContextPath()+"/back/collection.jsp");
	}
}
