package com.sydney.hotelmanager.dao;

import java.sql.SQLException;
import java.util.List;

import com.sydney.hotelmanager.entity.HotelInfo;

public interface HotelInfoDao {
	public int add(HotelInfo hotelInfo)throws SQLException;
	public int delete(String hotelNo)throws SQLException;
	public int update(HotelInfo hotelInfo)throws SQLException;
	public HotelInfo findById(String hotelNo)throws SQLException;
	public List<HotelInfo> findAll()throws SQLException;
}
