/*
 * 布力布力布力布力布力布力布力布力布力
 */

package cn.dw.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import cn.dw.oa.model.Product;
import cn.dw.oa.utils.JdbcUtils;

// 完成基本product表的相关操作
public class ProductDaoImpl extends BasicDaoImpl<Product>{
	
	public static void main(String[] args) {
		ProductDaoImpl daoImpl = new ProductDaoImpl();
		Product product = new Product();
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
	
	public Product selectByID(int id) {                          //一开始这里定义了返回类型是ProductList，仔细想想就知道，返回的是某个product对象
		String sql = "select * from product where id =?";
		List<Product> productList = super.unifyQuery(sql, id);
		return productList.size()==0? null : productList.get(0);
	}
	
	public List<Product> selectByName(String name) {
		String sql = "select * from product where name like ?";
		return super.unifyQuery(sql, "%"+ name +"%");
		
	}
	
	@Override
	protected Product getRow(ResultSet rs) throws SQLException {  //对于商品，重写getRow方法
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setRemark(rs.getString("remark"));
		product.setDate(rs.getDate("date"));
		return product;
	}
	
	
	
	
	
//	public Product selectWhereId(int id) {
//		Product product = null;
//		String sql = "select * from product where id = ?";
//		JdbcUtils jdbcUtils = new JdbcUtils();
//		Connection conn = null;
//		PreparedStatement pre = null;//这里若定义成Statement pre =null，下面是没有pre.setInt方法的
//		ResultSet rs = null;
//		try {
//			conn = jdbcUtils.getConnection();
//			pre = conn.prepareStatement(sql);
//			pre.setInt(1,id);
//			rs = pre.executeQuery();
//		//到这一步，其实和insert等3个方法是一样的，只不过执行的是executeQuery
//		//因为得到一个结果集rs，现在要从rs中把数据拿出来
//			if (rs.next()) {
//				product = new Product();
//				product.setId(rs.getInt("id"));
//				product.setName(rs.getString("name"));
//				product.setPrice(rs.getDouble("price"));
//				product.setDate(rs.getDate("date"));
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException();
//		}finally {
//			jdbcUtils.close(conn, pre);
//		}
//		return product;
//	}
//	
//	public List<Product> selectWhereName(String name) {
//		List<Product> productList = new ArrayList<Product>();
//		String sql = "selcet * from product where name like ?";
//		JdbcUtils jdbcUtils = null;
//		Connection conn = null;
//		PreparedStatement pre = null;
//		ResultSet rs = null;
//		conn = jdbcUtils.getConnection();
//		try {
//			conn = jdbcUtils.getConnection();
//			pre = conn.prepareStatement(sql);
//			pre.setString(1, "%"+name+"%");
//			rs = pre.executeQuery();
//			while (rs.next()) {
////				productList.add(rs.getInt("id"));
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException();
//		}
//		return productList;
//		
//	}

	
	
	
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
