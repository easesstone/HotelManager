package com.sydney.hotelmanager.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sydney.hotelmanager.dao.HotelInfoDao;
import com.sydney.hotelmanager.dbutils.DBUtils;
import com.sydney.hotelmanager.entity.HotelInfo;

public class HotelInfoDaoImpl implements HotelInfoDao {

	@Override
	public int add(HotelInfo hotelInfo) throws SQLException {
		String sql="insert into hotelinfo(hotelNo,hotelName,hotelManager,"
				+ "hotelTel,hotelAdress,isMainHotel) values(?,?,?,?,?,?)";
		Connection conn=DBUtils.getConnectTion();
		int a=new QueryRunner().update(conn,sql,hotelInfo.getHotelNo(),
				hotelInfo.getHotelName(),hotelInfo.getHotelManager(),
				hotelInfo.getHotelTel(),hotelInfo.getHotelAdress(),
				hotelInfo.getisMainHotel());
		conn.close();
		if(a>0){
			return 1;
		}else {
			return -1;
		}
		
	}

	@Override
	public int delete(String hotelNo) throws SQLException {
		String sql="delete from hotelinfo where hotelNo=?";
		Connection conn=DBUtils.getConnectTion();
		int a=new QueryRunner().update(conn, sql, hotelNo);
		conn.close();
		return a;
	}

	@Override
	public int update(HotelInfo hotelInfo) throws SQLException {
		String sql="update  hotelinfo set hotelName=?,hotelManager=?,"
				+ "hotelTel=?,hotelAdress=?,isMainHotel=? where hotelNo=?";
		Connection conn=DBUtils.getConnectTion();
		
		int a=new QueryRunner().update(conn,sql,
				hotelInfo.getHotelName(),hotelInfo.getHotelManager(),
				hotelInfo.getHotelTel(),hotelInfo.getHotelAdress(),
				hotelInfo.getisMainHotel(),hotelInfo.getHotelNo());
		conn.close();
		return a;
	}

	@Override
	public HotelInfo findById(String hotelNo) throws SQLException {
		String sql="select hotelNo,hotelName,hotelManager,hotelTel,"
				+ "hotelAdress,isMainHotel from hotelinfo where hotelNo=?";
		Connection conn=DBUtils.getConnectTion();
		
		HotelInfo hotelInfo=new QueryRunner().query(conn, sql,new 
				BeanHandler<HotelInfo>(HotelInfo.class),hotelNo);
		conn.close();
		return hotelInfo;
	}

	@Override
	public List<HotelInfo> findAll() throws SQLException {
		String sql="select hotelNo,hotelName,hotelManager,hotelTel,"
				+ "hotelAdress,isMainHotel from hotelinfo";
		Connection conn=DBUtils.getConnectTion();
		List<HotelInfo> hotelInfos=(List<HotelInfo>)new QueryRunner().query(conn, sql, new BeanListHandler<HotelInfo>(HotelInfo.class));
		conn.close();
		return hotelInfos;
	}

}
