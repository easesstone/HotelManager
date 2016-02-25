package com.sydney.hotelmanager.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 数据库连接工具类：
 * 单例设计模式
 * @author dell
 *
 */
public class DBUtils {
	private static String URL;//数据库地址
	private static String USER;//用户名
	private static String PASSWORD;//密码
	private static String DRIVER;//驱动
	
	//resourcebundle 对象
	private static ResourceBundle bundle=ResourceBundle.
			getBundle("com.sydney.hotelmanager.dbutils.config");
	private DBUtils() {}//私有构造函数
	//初始化
	static{
		URL=bundle.getString("jdbc.url");
		USER=bundle.getString("jdbc.user");
		PASSWORD=bundle.getString("jdbc.password");
		DRIVER=bundle.getString("jdbc.driver");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnectTion(){
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(URL, USER,PASSWORD);
			//System.out.println("数据库连接成功。。。。");
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("数据库连接失败。。。");
		}
		return connection;
	}
	
	public static void close(Connection connection,
			PreparedStatement ps,ResultSet rs)
	{
		
		try {
			if (connection!= null) {
				connection.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (rs!=null) {
				rs.close();
			}
			//System.out.println("close success....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
