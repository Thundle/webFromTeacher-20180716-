package cn.dw.oa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import cn.dw.oa.model.Product;
import cn.dw.oa.service.ProductService;

@RequestMapping("/productCtrl")//看看CreateProduct.jsp你就明白
public class ProductController {
	
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Resource
	private HttpServletRequest request;
	@Resource
	private HttpSession session;
	
	@RequestMapping("/insert")//这里就是jsp用来访问的相对路径吧，可以这么理解
	public String insert(Product product) {
		productService.insertToProduct(product);
		return "redirect:/QueryProduct.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Product product) {
		productService.updateOneProduct(product);
		return "redirect:/QueryProduct.jsp";
	}
	
	@RequestMapping("/selectById")
	public String selectById(Integer id) {
		productService.selectByID(id);
		return "forward:/Update.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		productService.deleteOneProduct(id);
		String name = (String) session.getAttribute("name");
		List<Product> pList = productService.selectByName(name);
		return "forward:/QueryProduct.jsp";
	}
	
	@RequestMapping("/selectByName")//记得改QueryProduct.jsp的相关参数，那些request、session.scope
	public String selectByName(String querykeyword) {
		session.setAttribute("querykeyword", querykeyword );
		List<Product> pList = productService.selectByName(querykeyword);
		request.setAttribute("pListFromCtrl", pList);
		return "forward:/QueryProduct.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
}
