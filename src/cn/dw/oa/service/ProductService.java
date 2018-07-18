package cn.dw.oa.service;

import java.util.List;

import cn.dw.oa.dao.ProductDaoImpl;
import cn.dw.oa.model.Product;

//业务逻辑层，前端想做的传数据过来这个类即可调用此类里面的方法
public class ProductService {
	
	private ProductDaoImpl productDaoImpl = new ProductDaoImpl(); 
	
	public Product selectByID(int id) {
		return productDaoImpl.selectByID(id);
	}
	
	public List<Product> selectByName(String name) {
		return productDaoImpl.selectByName(name);
	}
	
	public int insertToProduct(Product product) {
		return productDaoImpl.insertToProduct(product);
	}
	
	public int updateOneProduct(Product product) {
		return productDaoImpl.updateTheProduct(product);
	}
	
	public int deleteOneProduct(int id) {
		return productDaoImpl.deleteTheProduct(id);
	}
}

