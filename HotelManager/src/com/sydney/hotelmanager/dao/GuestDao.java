package com.sydney.hotelmanager.dao;

import java.sql.SQLException;
import java.util.List;

import com.sydney.hotelmanager.entity.Guest;

public interface GuestDao {
	public int addGuest(Guest guest)throws SQLException;
	public List<Guest> findById(String guestShenfenNo)throws SQLException;//查找客人住房记录
	public List<Guest> findByInNow()throws SQLException;//查找当前在店客人信息
	public List<Guest>findByDate(String date)throws SQLException;//根据日期查询客人信息
}
