package cn.dw.oa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dw.oa.model.Product;
import cn.dw.oa.service.ProductService;

@WebServlet("/ProductToServlet")
public class ProductToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProductService productService = new ProductService();
	
	private String queryKeyword = null;
	
    public ProductToServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String queryKeyword = request.getParameter("keywordInJSP");
    	List<Product> pList = productService.selectByName(queryKeyword);
//		System.out.println(pList.size());
    	HttpSession session = request.getSession();
    	session.setAttribute("pList",pList);
    	response.sendRedirect("/webBuli/QueryProduct.jsp");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String operateTypeInSvl = request.getParameter("operateTypeInJSP");
    	if (operateTypeInSvl.equals("insert")) {
        	Product product = new Product();
        	product.setName(request.getParameter("nameInJSP"));
        	product.setPrice(Double.parseDouble(request.getParameter("priceInJSP")));
        	productService.insertToProduct(product);
        	response.sendRedirect("/webBuli/QueryProduct.jsp");
    	}else if(operateTypeInSvl.equals("query")){
    		queryKeyword = request.getParameter("keywordInJSP");
    		List<Product> pList = productService.selectByName(queryKeyword);
    		request.setAttribute("pListFromSvl", pList);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/QueryProduct.jsp");
    		dispatcher.forward(request, response);
		}else if (operateTypeInSvl.equals("delete")) {
			String id = request.getParameter("id");
			productService.deleteOneProduct(Integer.parseInt(id));
			productService.selectByName(queryKeyword);
			List<Product> pList = productService.selectByName(queryKeyword);
			request.setAttribute("pList", pList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/QueryProduct.jsp");
			dispatcher.forward(request, response);
		}
    }
    
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	Product product = new Product();
//    	product.setName(request.getParameter("thename"));
//    	product.setPrice(Double.parseDouble(request.getParameter("theprice")));
//    	productService.insertToProduct(product);
//    	response.sendRedirect("/webBuli/QueryProduct.jsp");
//    }

	

}
