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
import cn.dw.oa.service.ProductServiceImpl;
import cn.dw.oa.service.ProductService;

@WebServlet("/ProductToServlet")
public class ProductToServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private ProductService productService = new ProductServiceImpl();
	
//	private String queryKeyword = null;
	
    public ProductToServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	this.doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String operateTypeInSvl = request.getParameter("operateTypeInJSP");
    	if (operateTypeInSvl.equals("insert")) {
        	Product product = new Product();
        	product.setName(request.getParameter("nameInJSP"));
        	product.setPrice(Double.parseDouble(request.getParameter("priceInJSP")));
        	product.setRemark(request.getParameter("remarkInJSP"));
        	productService.insertToProduct(product);
        	response.sendRedirect("/webBuli/QueryProduct.jsp");
    	}else if(operateTypeInSvl.equals("query")){
    		HttpSession session = request.getSession();
    		String querykeyword = request.getParameter("keywordInJSP");
    		session.setAttribute("querykeyword", querykeyword);
    		List<Product> pList = productService.selectByName(querykeyword);
    		request.setAttribute("pListFromSvl", pList);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/QueryProduct.jsp");
    		dispatcher.forward(request, response);
    		System.out.println("query:::"+session);
		}else if (operateTypeInSvl.equals("delete")) {
			String id = request.getParameter("id");
			productService.deleteOneProduct(Integer.parseInt(id));
			HttpSession session = request.getSession();
			System.out.println("delete:::"+session);
			String querykeyword = (String) session.getAttribute("querykeyword");
//这个错误很隐蔽，翻看上面的代码发现，在上面已经对session设置了属性名为querykeyword，在这里已经不是keywordInJSP了
			List<Product> pList = productService.selectByName(querykeyword);
			request.setAttribute("pListFromSvl", pList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/QueryProduct.jsp");
			dispatcher.forward(request, response);
			System.out.println("删除吗？？？？？？");
		}else if (operateTypeInSvl.equals("selectById")) {
			Integer id = (Integer) request.getAttribute("id");
			Product product = productService.selectByID(id);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
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

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	String queryKeyword = request.getParameter("keywordInJSP");
//    	List<Product> pList = productService.selectByName(queryKeyword);
//		System.out.println(pList.size());
//    	HttpSession session = request.getSession();
//    	session.setAttribute("pList",pList);
//    	response.sendRedirect("/webBuli/QueryProduct.jsp");

    }
	


