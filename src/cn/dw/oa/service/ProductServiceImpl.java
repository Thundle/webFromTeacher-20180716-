package cn.dw.oa.service;

import java.util.List;

import cn.dw.oa.dao.ProductDao;
import cn.dw.oa.model.Product;

//业务逻辑层，前端想做的传数据过来这个类即可调用此类里面的方法
public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao = null;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/* (non-Javadoc)
	 * @see cn.dw.oa.service.ProductServiceI#selectByID(int)
	 */
	@Override
	public Product selectByID(int id) {
		return productDao.selectById(id);
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.service.ProductServiceI#selectByName(java.lang.String)
	 */
	@Override
	public List<Product> selectByName(String keyword) {
		int startpage = 2;
		int pagesize = 5;
		return productDao.selectByName("%" + keyword + "%", (startpage-1)*pagesize,pagesize);
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.service.ProductServiceI#insertToProduct(cn.dw.oa.model.Product)
	 */
	@Override
	public int insertToProduct(Product product) {
		return productDao.insertToProduct(product);
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.service.ProductServiceI#updateOneProduct(cn.dw.oa.model.Product)
	 */
	@Override
	public int updateOneProduct(Product product) {
		return productDao.updateTheProduct(product);
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.service.ProductServiceI#deleteOneProduct(int)
	 */
	@Override
	public int deleteOneProduct(int id) {
		return productDao.deleteTheProduct(id);
	}
}

