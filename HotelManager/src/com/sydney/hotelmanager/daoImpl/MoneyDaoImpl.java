package com.sydney.hotelmanager.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.sydney.hotelmanager.dao.MoneyDao;
import com.sydney.hotelmanager.dbutils.DBUtils;
import com.sydney.hotelmanager.entity.BusinessDetails;

public class MoneyDaoImpl implements MoneyDao {

	@Override
	public int currentDaysMoney() throws SQLException {
		String sql="SELECT "
				+ "sum(r2.roomprice) "
				+ "FROM roomtype r2,"
				+ "("
				+ "SELECT "
				+ "r1.*"
				+ "  FROM"
				+ " roominfo r1,guest g"
				+ "  WHERE g.roomInfoNo = r1.roomInfoNo &&"
				+ " ("
				+ "CURDATE() BETWEEN g.bookDate AND g.bookTime"
				+ ")"
				+ ")"
				+ "AS result "
				+ "WHERE r2.roomTypeNo = result.roomTypeNo";
		Connection conn=DBUtils.getConnectTion();
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		int moneysDay=0;
		if(rs.next()){
			moneysDay=rs.getInt(1);
		}
		rs.close();
		ps.close();
		conn.close();
		return moneysDay;
	}

	@Override
	public int currentMonthsMoney() throws SQLException {
		String sql="SELECT SUM((to_days(g.bookTime)-to_days(g.bookDate))*r2.roomprice) as sumPrice"
				+" FROM guest g,roominfo r1,roomtype r2"
				+" WHERE g.bookDate LIKE CONCAT(SUBSTR(CURDATE(),1,7),'-__')&&"
				+"g.roomInfoNo=r1.roomInfoNo&&"
				+"r1.roomTypeNo=r2.roomTypeNo";
		Connection conn=DBUtils.getConnectTion();
		
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		int money=0;
		if(rs.next()){
			money=rs.getInt(1);
		}
		return money;
	}

	@Override
	public int currentYearsMoney() throws SQLException {
		String sql="SELECT SUM((to_days(g.bookTime)-to_days(g.bookDate))*r2.roomprice) as sumPrice"
				+" FROM guest g,roominfo r1,roomtype r2"
				+" WHERE g.bookDate LIKE CONCAT(SUBSTR(CURDATE(),1,4),'-__-__')&&"
				+"g.roomInfoNo=r1.roomInfoNo&&"
				+"r1.roomTypeNo=r2.roomTypeNo";
		Connection conn=DBUtils.getConnectTion();
		
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		int money=0;
		if(rs.next()){
			money=rs.getInt(1);
		}
		return money;
	}

	@Override
	public List<BusinessDetails> currentDaysDetails() throws SQLException {
		Connection conn=DBUtils.getConnectTion();
		String sql="SELECT CURDATE(),r2.roomTypeName,r2.roomprice,"
				+"h.hotelName,h.hotelAdress,g.bookDate,g.bookTime,"
				+ "to_days(g.bookDate)-to_days(g.bookDate)+1 AS howLong"
				+" FROM guest g,roominfo r1,hotelinfo h,roomtype r2 "
				+" WHERE g.roomInfoNo=r1.roomInfoNo&&"
				+"(CURDATE() BETWEEN bookDate AND bookTime)&&"
				+"h.hotelNo=r1.hotelNo&&"
				+"r1.roomTypeNo=r2.roomTypeNo";
		List<BusinessDetails>businessDetails=new ArrayList<BusinessDetails>();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		BusinessDetails bDetails=null;
		while(rs.next()){
			String curDate=rs.getString(1);
			String roomTypeme=rs.getString(2);
			double roomPrice=rs.getDouble(3);
			String hotelName=rs.getString(4);
			String hotelAdress=rs.getString(5);
			String bookDate=rs.getString(6);
			String bookTime=rs.getString(7);
			int howLong=rs.getInt(8);
			bDetails=new BusinessDetails(curDate, roomTypeme, roomPrice, hotelName, 
					hotelAdress, bookDate, bookTime, howLong);
			businessDetails.add(bDetails);
		}
		
		rs.close();
		ps.close();
		conn.close();
		return businessDetails;
	}

	@Override
	public List<BusinessDetails> currentMonthsDetails() throws SQLException {
		String sql="SELECT CURDATE(),r2.roomTypeName,r2.roomprice,h.hotelName,h.hotelAdress,"
				+"g.bookDate,g.bookTime,"
				+ "to_days(g.bookTime)-to_days(g.bookDate) AS howLong"
				+" FROM guest g,roominfo r1,roomtype r2,hotelinfo h"
				+" WHERE g.bookDate LIKE CONCAT(SUBSTR(CURDATE(),1,7),'-__')&&"
				+"g.roomInfoNo=r1.roomInfoNo&&"
				+"r2.roomTypeNo=r1.roomTypeNo&&"
				+"h.hotelNo=r1.hotelNo";
		Connection conn=DBUtils.getConnectTion();
		List<BusinessDetails>businessDetails=new ArrayList<BusinessDetails>();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		BusinessDetails bDetails=null;
		while(rs.next()){
			String curDate=rs.getString(1);
			String roomTypeme=rs.getString(2);
			double roomPrice=rs.getDouble(3);
			String hotelName=rs.getString(4);
			String hotelAdress=rs.getString(5);
			String bookDate=rs.getString(6);
			String bookTime=rs.getString(7);
			int howLong=rs.getInt(8);
			bDetails=new BusinessDetails(curDate, roomTypeme, roomPrice, hotelName, 
					hotelAdress, bookDate, bookTime, howLong);
			businessDetails.add(bDetails);
		}
		
		rs.close();
		ps.close();
		conn.close();
		conn.close();
		return businessDetails;
	}

	@Override
	public List<BusinessDetails> currentYearsDetails() throws SQLException {
		String sql="SELECT CURDATE(),r2.roomTypeName,r2.roomprice,h.hotelName,h.hotelAdress,"
				+"g.bookDate,g.bookTime,"
				+ "to_days(g.bookTime)-to_days(g.bookDate) AS howLong"
				+" FROM guest g,roominfo r1,roomtype r2,hotelinfo h"
				+" WHERE g.bookDate LIKE CONCAT(SUBSTR(CURDATE(),1,4),'-__-__')&&"
				+"g.roomInfoNo=r1.roomInfoNo&&"
				+"r2.roomTypeNo=r1.roomTypeNo&&"
				+"h.hotelNo=r1.hotelNo";
		Connection conn=DBUtils.getConnectTion();
		List<BusinessDetails>businessDetails=new ArrayList<BusinessDetails>();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		BusinessDetails bDetails=null;
		while(rs.next()){
			String curDate=rs.getString(1);
			String roomTypeme=rs.getString(2);
			double roomPrice=rs.getDouble(3);
			String hotelName=rs.getString(4);
			String hotelAdress=rs.getString(5);
			String bookDate=rs.getString(6);
			String bookTime=rs.getString(7);
			int howLong=rs.getInt(8);
			bDetails=new BusinessDetails(curDate, roomTypeme, roomPrice, hotelName, 
					hotelAdress, bookDate, bookTime, howLong);
			businessDetails.add(bDetails);
		}
		
		rs.close();
		ps.close();
		conn.close();
		return businessDetails;		
	}

}
