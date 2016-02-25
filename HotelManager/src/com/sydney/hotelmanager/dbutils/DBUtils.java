package com.sydney.hotelmanager.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * ���ݿ����ӹ����ࣺ
 * �������ģʽ
 * @author dell
 *
 */
public class DBUtils {
	private static String URL;//���ݿ��ַ
	private static String USER;//�û���
	private static String PASSWORD;//����
	private static String DRIVER;//����
	
	//resourcebundle ����
	private static ResourceBundle bundle=ResourceBundle.
			getBundle("com.sydney.hotelmanager.dbutils.config");
	private DBUtils() {}//˽�й��캯��
	//��ʼ��
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
			//System.out.println("���ݿ����ӳɹ���������");
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("���ݿ�����ʧ�ܡ�����");
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
