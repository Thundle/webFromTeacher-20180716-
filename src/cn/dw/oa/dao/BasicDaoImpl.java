package cn.dw.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dw.oa.model.Product;
import cn.dw.oa.utils.JdbcUtils;

public abstract class BasicDaoImpl<T> {
	
	protected abstract T getRow(ResultSet rs) throws SQLException;
	
	protected int unifyUpdate(String sql,Object... param) {
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection conn = null;
		PreparedStatement pre = null;
		conn = jdbcUtils.getConnection();
		try {
			pre = conn.prepareStatement(sql);
			//这里开始很烦，如何根据传入的param来确定预编译的相关语句，传入相关参数
			//这里的object，就是对象数组，元素将会是product.getName()之类的
			for (int i = 0; i < param.length; i++) {
			pre.setObject(i+1, param[i]);
			}
			return pre.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			jdbcUtils.close(conn, pre);
		}
	}

	protected List<T> unifyQuery(String sql,Object... param) {
		List<T> anythingList = new ArrayList<T>();
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			pre = conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {  //查询、删除都比较舒服，只有一个param里面只有一个参数
				pre.setObject(i+1, param[i]);
			}
			rs = pre.executeQuery();
			while (rs.next()) {
				anythingList.add(this.getRow(rs));    //getRow方法主要就是以后调用时由子类自行创建对象
			}                                         //比如product，以后就product.setName
			return anythingList;
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			jdbcUtils.close(conn, pre, rs);
		}
		
	}
}
