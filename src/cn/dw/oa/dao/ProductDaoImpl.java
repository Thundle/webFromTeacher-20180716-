package cn.dw.oa.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

import cn.dw.oa.model.Product;
import cn.dw.oa.utils.JdbcUtils;

// 完成基本product表的相关操作
public class ProductDaoImpl extends BasicDaoImpl{
	
	public static void main(String[] args) {
		ProductDaoImpl daoImpl = new ProductDaoImpl();
		Product product = new Product();
		product.setName("Vivo");
		product.setPrice(3000.00);
		product.setRemark("7月17日22:56");
		daoImpl.insertToProduct(product);
	}
	
	public int insertToProduct(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		return super.unifyUpdate(sql, new Object[] {product.getName(), product.getPrice(), product.getRemark()});
	}
	
	public int updateTheProduct(Product product) {
		String sql = "update product set name = ?, price = ?, remark = ? where id = ?";
		return super.unifyUpdate(sql, new Object[] {product.getName(), product.getPrice(), product.getRemark(),product.getId()});
		
	}
//  看看delete方法，直接传入一个id就可以了，在父方法中是object...，不用强求一定要数组	
//	public int deleteTheProduct(Product product) {
//		String sql = "delete from product where id = ?";
//		return super.unifyUpdate(sql, new Object[] {product.getId()});
//	}
	public int deleteTheProduct(int id) {
		String sql = "delete from product where id = ?";
		return super.unifyUpdate(sql, id);
	}

	
	
	
	
	
	// 所有的字段封装到Product中
//    private int save(Product product) {
//    	String sql = "insert into product (name,price,remark) values (?,?,?)";
//    	// 1: 创建连接数据库的对象
//    	JdbcUtils jdbcUtils = new JdbcUtils();
//    	Connection conn = null;
//    	PreparedStatement pre = null;
//    	// 2: prepareStatement(操作数据库的对象)
//    	try {
//    		conn = jdbcUtils.getConnection();
//    		// 此处称为预编译SQL语句(目前sql并没有真正执行)
//			pre = conn.prepareStatement(sql);
//			// 参数的下标从1开始
//			pre.setString(1, product.getName());
//			pre.setDouble(2, product.getPrice());
//			pre.setString(3, product.getRemark());
//			// 执行真正的sql语句, update、delete、insert都统一调用: executeUpdate()
//			return pre.executeUpdate(); 
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}finally {
//			jdbcUtils.close(conn, pre);
//		}
//    }
    
//    private int delete_product(Product product) {
//    	String sql = "delete from product where id = ? ";
//    	JdbcUtils jdbcUtils = new JdbcUtils();
//    	Connection conn = null;
//    	PreparedStatement pre = null;
//    	conn = jdbcUtils.getConnection();
//    	try {
//			pre = conn.prepareStatement(sql);
//			pre.setInt(1, product.getId());
//			return pre.executeUpdate();
//		} catch (Exception e) {
//			throw new RuntimeException();
//		}finally {
//			jdbcUtils.close(conn, pre);
//		}
//	}
    
//    private int update_product(Product product) {
//    	String sql = "update product set name = ?, price = ?, remark = ? where id = ? ";//一开始，逗号和问号中间有空格，失败了
//    	JdbcUtils jdbcUtils = new JdbcUtils();
//    	Connection conn = null;
//    	PreparedStatement pre = null;
//    	conn = jdbcUtils.getConnection();
//    	try {
//			pre = conn.prepareStatement(sql);
//	    	pre.setString(1, product.getName());  //傻逼了，id一直觉得index是1，这里是按照参数的传递顺序来
//	    	pre.setDouble(2, product.getPrice());
//	    	pre.setString(3, product.getRemark());
//	    	pre.setInt(4, product.getId());
//	    	return pre.executeUpdate();
//		} catch (Exception e) {
//			throw new RuntimeException(); 
//		}finally {
//			jdbcUtils.close(conn, pre);
//		}
//	}
    
    
}
