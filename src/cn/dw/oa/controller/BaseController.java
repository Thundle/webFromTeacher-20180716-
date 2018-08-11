package cn.dw.oa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.dw.oa.service.CategoryService;
import cn.dw.oa.service.ProductService;

public class BaseController {
	
	protected ProductService productService;
	
	protected CategoryService categoryService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Resource
	protected HttpServletRequest request;
	
	@Resource
	protected HttpSession session;
}
