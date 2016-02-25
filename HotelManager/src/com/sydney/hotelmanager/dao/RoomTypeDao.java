package com.sydney.hotelmanager.dao;

import java.sql.SQLException;
import java.util.List;

import com.sydney.hotelmanager.entity.RoomType;

public interface RoomTypeDao {
	public int update(RoomType roomTypeNo)throws SQLException;
	public int delete(String roomTypeNo)throws SQLException;
	public int add(RoomType roomType)throws SQLException;
	public RoomType findById(String roomTypeNo)throws SQLException;
	public List<RoomType> findAll()throws SQLException;
}
