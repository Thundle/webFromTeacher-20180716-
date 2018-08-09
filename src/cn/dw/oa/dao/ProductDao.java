package cn.dw.oa.dao;

import java.util.List;

import cn.dw.oa.model.Product;

public interface ProductDao {

	int insertToProduct(Product product);

	int updateTheProduct(Product product);

	//  看看delete方法，直接传入一个id就可以了，在父方法中是object...，不用强求一定要数组	
	//	public int deleteTheProduct(Product product) {
	//		String sql = "delete from product where id = ?";
	//		return super.unifyUpdate(sql, new Object[] {product.getId()});
	//	}
	int deleteTheProduct(int id);

	List<Product> selectByName(String name);
	
	Product selectById(int id);

}