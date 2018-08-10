package cn.dw.oa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.dw.oa.service.ProductService;

public class BaseController {
	
	protected ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Resource
	protected HttpServletRequest request;
	
	@Resource
	protected HttpSession session;
}
