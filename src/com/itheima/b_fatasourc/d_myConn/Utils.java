//装饰者模式的连接池
package com.itheima.b_fatasourc.d_myConn;

import java.sql.Connection;
import java.sql.SQLException;

public class Utils {

	public static void main(String[] args) throws SQLException {
		// TODO 自动生成的方法存根
		Connection con=(new MyDataSource()).getConnection();
		Connection con1=(new MyDataSource()).getConnection();
		Connection con2=(new MyDataSource()).getConnection();
		Connection con3=(new MyDataSource()).getConnection();
		System.out.println(con);
		con.close();
		con1.close();
		con2.close();
		con3.close();
	}
}
