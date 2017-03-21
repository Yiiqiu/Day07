package com.itheima.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtils_ {

	static final String DRIVERCLASS;
	static final String URL;
	static final String USER ;
	static final String PASSWORD;
	// 获取连接
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		DRIVERCLASS = bundle.getString("driverClass");
		URL = bundle.getString("url");
		USER = bundle.getString("user");
		PASSWORD = bundle.getString("password");
		System.out.println(USER);
		System.out.println(URL);
		System.out.println(PASSWORD);
	}
	static {
		// 注册驱动
		//System.out.println(DRIVERCLASS);
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception{
		// 获取连接
		Connection conn = DriverManager.getConnection(
				URL, USER, PASSWORD);
		return conn;
	}

	// 释放资源
	public static void closeResource(ResultSet rs, PreparedStatement ps,
			Connection conn){
		closeConn(conn);
		closeResultSet(rs);
		closePrepared(ps);
	}

	// 釋放連接
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			conn = null;// 垃圾回收快速收回它
		}
	}

	// 釋放連接
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			rs = null;// 垃圾回收快速收回它
		}
	}

	// 釋放連接
	public static void closePrepared(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			ps = null;// 垃圾回收快速收回它
		}
	}
}
