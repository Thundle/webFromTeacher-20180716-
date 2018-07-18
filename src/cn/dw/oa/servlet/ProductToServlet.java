package cn.dw.oa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dw.oa.model.Product;
import cn.dw.oa.service.ProductService;

@WebServlet("/ProductToServlet")
public class ProductToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProductService productService = new ProductService();
	
    public ProductToServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Product product = new Product();
    	product.setName(request.getParameter("thename"));
    	product.setPrice(Double.parseDouble(request.getParameter("theprice")));
    	productService.insertToProduct(product);
    	response.sendRedirect("/webBuli/QueryProduct.jsp");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryKeyword = request.getParameter("keyword");
		List<Product> pList = productService.selectByName(queryKeyword);
		System.out.println(pList.size());
		
	}
	

}
