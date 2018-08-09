package cn.dw.oa.service;

import java.util.List;

import cn.dw.oa.model.Product;

public interface ProductService {

	Product selectByID(int id);

	List<Product> selectByName(String name);

	int insertToProduct(Product product);

	int updateOneProduct(Product product);

	int deleteOneProduct(int id);

}