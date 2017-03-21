//写了一个工具类JdbcUtils_，用来测试
package com.itheima.a_jdbc.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.itheima.utils.JdbcUtils;
import com.itheima.utils.JdbcUtils_;

public class Curd {

	@Test
	public void f1() {
		System.out.println("hello!");
	}

	//
	@Test
	public void f2() throws Exception {
		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/day07", "root", "123456");
		// 1、以上2部是固定的,所以弄一个JDBC的类

		// 编写SQL，随意
		String sql = "select * from category";
		// 创建语句执行者
		PreparedStatement st = conn.prepareStatement(sql);

		// SQL
		ResultSet rs = st.executeQuery();
		// jieguo
		while (rs.next()) {
			System.out.println(rs.getString("cid") + rs.getString("cname"));
		}
		rs.close();
		st.close();
		conn.close();
	}

	@Test
	public void f3() throws Exception {

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils_.getConnection();
			String sql = "insert into category values(?,?)";
			// 创建语句执行者
			st = conn.prepareStatement(sql);
			// 设置参数
			st.setString(1, "c021");
			st.setString(2, "户外");
			// 执行SQL
			int a = st.executeUpdate();
			System.out.println("更新了" + a);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(rs, st, conn);

		}

	}

	@Test
	public void f4() throws Exception {
		Connection conn = JdbcUtils_.getConnection();
		String sql = "DELETE FROM category WHERE cid =?";
		// 创建语句执行者
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "c001");
		int a = st.executeUpdate();
		System.out.println("更新了" + a);
		JdbcUtils.closeResource(null, st, conn);
	}

	@Test
	public void f5() throws Exception {
		Connection conn = JdbcUtils_.getConnection();
		String sql = "UPDATE CATEGORY SET cname =? WHERE cid =?";
		// 创建语句执行者
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "la");
		st.setString(2, "c002");

		int a = st.executeUpdate();
		System.out.println("更新了" + a);
		JdbcUtils.closeResource(null, st, conn);
	}

	// 删除
	@Test
	public void f12() throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from category where cid = ?";
			st = conn.prepareStatement(sql);

			st.setString(1, "c007");

			int i = st.executeUpdate();
			if (i == 1) {
				System.out.println("success");
			} else {
				System.out.println("fail");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(rs, st, conn);
		}
	}
}
