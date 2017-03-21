//装饰者模式的连接池
package com.itheima.b_fatasourc.d_myConn;

import java.sql.Connection;
import java.util.LinkedList;

import com.itheima.utils.JdbcUtils_;
public class MyDataSource{
	static LinkedList<Connection> pool=new LinkedList<>();
	static{
		System.out.println("1");
		for(int i=0;i<3;i++)
		{
			try {
				Connection con=JdbcUtils_.getConnection();
				pool.add(con);
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
		if(pool.isEmpty())
		{
			for(int i=0;i<3;i++)
			{
				try {
					Connection con=JdbcUtils_.getConnection();
					pool.add(con);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}	
		}
		Connection conn=pool.removeFirst();
		ConnectionWarp myConn=new ConnectionWarp(conn,pool);
		return myConn;
	}
	public static void close(Connection con)
	{
		System.out.println("guihaila");
		pool.add(con);
	}
	
}
