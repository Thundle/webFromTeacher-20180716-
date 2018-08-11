package cn.dw.oa.service;

import java.util.List;

import cn.dw.oa.dao.CategoryDao;
import cn.dw.oa.model.Category;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao category;
	
	
	public void setCategory(CategoryDao category) {
		this.category = category;
	}


	@Override
	public List<Category> queryByName(String name) {
		return category.queryByName("%"+ name + "%" );
	}

}
