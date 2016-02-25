package com.sydney.hotelmanager.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;


import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sydney.hotelmanager.dao.UserDao;
import com.sydney.hotelmanager.dbutils.DBUtils;
import com.sydney.hotelmanager.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public int add(User user) throws SQLException {
		Connection conn=DBUtils.getConnectTion();
		String sql="insert into user(username,password,realname,hotelNo,isManager)"
				+ " values(?,?,?,?,?)";
		QueryRunner runner=new QueryRunner();
		int a = runner.update(conn, sql, user.getUsername(),
				user.getPassword(),user.getRealname(),user.getHotelNo()
				,user.getIsManager());
//		if (a>0) {
//			System.out.println("insert success....");
//		}else {
//			System.out.println("insert fails....");
//		}
		conn.close();
		return a;
	}

	@Override
	public int delete(String username) throws SQLException {
		String sql="delete from user where username=?";
		Connection conn=DBUtils.getConnectTion();
		int a=new QueryRunner().update(conn, sql,username);
//		if (a>0) {
//			System.out.println("delete success...");
//		}else {
//			System.out.println("delete fails...");
//		}
		conn.close();
		return a;
	}

	@Override
	public int update(User user) throws SQLException {
		String sql="update user set password=?,realname=?,hotelNo=?,"
				+ "isManager=?"
				+ " where username=?";
		Connection conn=DBUtils.getConnectTion();
		int a=new QueryRunner().update(conn,sql, user.getPassword(),
				user.getRealname(),user.getHotelNo(),user.getIsManager(),
				user.getUsername());
//		if (a>0) {
//			System.out.println("update success....");
//		}else {
//			System.out.println("update fails...");
//		}
		conn.close();
		return a;
	}

	@Override
	public User findById(String username) throws SQLException {
		String sql="select username,password,realname,hotelNo,"
				+ "isManager from user where username=?";
		Connection conn=DBUtils.getConnectTion();
		User user=new QueryRunner().query(conn, sql, new BeanHandler<User>(User.class), username);
		conn.close();
		return user;
	}

	@Override
	public List<User> findAll() throws SQLException {
		String sql="select username,password,realname,hotelNo,"
				+ "isManager from user";
		Connection conn=DBUtils.getConnectTion();
		List<User> users=(List<User>) new QueryRunner().query(conn,sql,new BeanListHandler<User>(User.class));
		conn.close();
		return users;
	}

}
