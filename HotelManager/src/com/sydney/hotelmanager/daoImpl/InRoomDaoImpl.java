package com.sydney.hotelmanager.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sydney.hotelmanager.dao.InRoomDao;
import com.sydney.hotelmanager.dbutils.DBUtils;
import com.sydney.hotelmanager.entity.RoomInfo;

public class InRoomDaoImpl implements InRoomDao{

	@Override
	public List<RoomInfo> bookButNotIn() throws SQLException {
		Connection conn=DBUtils.getConnectTion();
		String sql="SELECT roomInfoNo,roomTypeNo,hotelNo,"
				+ "isOrdered,isPreOrder,preOrderGuestNo,preOrderGuestPhone"
				+" FROM roominfo "
				+" WHERE isOrdered=0 AND isPreOrder=1";
		List<RoomInfo>roomInfos=new ArrayList<RoomInfo>();
		
		roomInfos=new QueryRunner().query(conn, sql,new 
				BeanListHandler<RoomInfo>(RoomInfo.class));
		conn.close();
		return roomInfos;
	}

	@Override
	public List<RoomInfo> findEmptyRoom() throws SQLException {
		Connection conn=DBUtils.getConnectTion();
		String sql="SELECT roomInfoNo,roomTypeNo,hotelNo,"
				+ "isOrdered,isPreOrder,preOrderGuestNo,preOrderGuestPhone"
				+" FROM roominfo "
				+" WHERE isOrdered=0 AND isPreOrder=0";
		List<RoomInfo>roomInfos=new ArrayList<RoomInfo>();
		
		roomInfos=new QueryRunner().query(conn, sql,new 
				BeanListHandler<RoomInfo>(RoomInfo.class));
		conn.close();
		
		return roomInfos;
	}

	@Override
	public boolean bookRoom(String roomInfoNo) throws SQLException {
		Connection conn=DBUtils.getConnectTion();
		String sql="update roomInfo set isOrdered=1 where roomInfoNo=?";
		int a=new QueryRunner().update(conn,sql,roomInfoNo);
		if (a!=-1) {
			return true;
		}else {
			return false;
		}
	}
}
