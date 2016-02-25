package com.sydney.hotelmanager.dao;

import java.sql.SQLException;
import java.util.List;

import com.sydney.hotelmanager.entity.RoomInfo;

public interface InRoomDao {
	public boolean bookRoom(String roomInfoNo)throws SQLException;
//	public void upBookRoom()throws SQLException;
//	public void orderRoom()throws SQLException;
//	public void ExitRoom()throws SQLException;
//	public void xuZhu()throws SQLException;
	public List<RoomInfo> bookButNotIn()throws SQLException;
	public List<RoomInfo> findEmptyRoom()throws SQLException;
	
}
