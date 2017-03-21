////自己写一个简单的连接池
package com.itheima.jd;

import java.sql.Connection;

public class Utils {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Connection con=(new MyDataSource()).getConnection();
		System.out.println(con);
		MyDataSource.close(con);
	}
}
