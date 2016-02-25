package com.sydney.hotelmanager.dao;

import java.sql.SQLException;
import java.util.List;

import com.sydney.hotelmanager.entity.RoomInfo;

public interface RoomInfoDao {
	public int add(RoomInfo roomInfo)throws SQLException;
	public int update(RoomInfo roomInfo)throws SQLException;
	public int delete(String roomInfoNo)throws SQLException;
	public RoomInfo findById(String roomInfoNo)throws SQLException;
	public List<RoomInfo> findAll()throws SQLException;
}
