package com.sydney.hotelmanager.dao;

import java.sql.SQLException;
import java.util.List;

import com.sydney.hotelmanager.entity.User;

public interface UserDao {
	public int add(User user)throws SQLException;
	public int delete(String userNo)throws SQLException;
	public int update(User user)throws SQLException;
	public User findById(String username)throws SQLException;
	public List<User> findAll()throws SQLException;
}
