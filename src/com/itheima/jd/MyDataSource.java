//自己写一个简单的连接池
package com.itheima.jd;

import java.sql.Connection;
import java.util.LinkedList;

import com.itheima.utils.JdbcUtils_;
public class MyDataSource{
	static LinkedList<Connection> conn=new LinkedList<>();
	static{
		System.out.println("1");
		for(int i=0;i<3;i++)
		{
			try {
				Connection con=JdbcUtils_.getConnection();
				conn.add(con);
				System.out.println("1");
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection()
	{
		System.out.println("2");
		if(conn.isEmpty())
		{
			for(int i=0;i<3;i++)
			{
				try {
					Connection con=JdbcUtils_.getConnection();
					conn.add(con);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}	
		}
		return conn.removeFirst();
	}
	public static void close(Connection con)
	{
		System.out.println("guihaila");
		conn.add(con);
	}
	
}
