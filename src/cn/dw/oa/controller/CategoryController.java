package cn.dw.oa.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dw.oa.model.Category;
import cn.dw.oa.service.CategoryService;

@RequestMapping("/category")
public class CategoryController extends BaseController {
	
	@RequestMapping("/ajax")
	@ResponseBody
	public Object ajax(String keyword) {
		return categoryService.queryByName(keyword);
	}
}

//	public Object ajax(String name,String pass) {
//		List<Category> cList = new ArrayList<Category>();
//		cList.add(new Category(1, "ios操作系统"));
//		cList.add(new Category(2, "android操作系统"));
//		return cList;
//	}