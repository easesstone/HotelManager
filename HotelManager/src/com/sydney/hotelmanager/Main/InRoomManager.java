package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import com.sydney.hotelmanager.daoImpl.GuestDaoImpl;
import com.sydney.hotelmanager.daoImpl.InRoomDaoImpl;
import com.sydney.hotelmanager.entity.Guest;
import com.sydney.hotelmanager.entity.RoomInfo;

public class InRoomManager {
	/**
	 * 入住信息管理
	 */
	public static void initInRoomManager(){
		System.out.println("--------------入住信息管理-----------------");
		System.out.println("------1,客房预订，2，取消预订，---------------");
		System.out.println("------3，入住，4，退房，5，续住---------------");
		System.out.println("------6，预订未入住客房信息查询---------------");
		System.out.println("----请输入数字选择功能操作（1,2,3,4,5,6）---------");
	}
	
	@SuppressWarnings("resource")
	public static void doInRoomManager(){
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while(num!=1&&num!=2&&num!=3&&num!=4&&num!=5&&num!=6){
			System.out.println("输入的数字只能是1到6，请从新输入。。。");
			num=scanner.nextInt();
		}
		switch (num) {
		case 1:
			preBookRoom();
			break;
		case 2:
			unPreBookRoom();
			break;
		case 3:
			BookRoom();
			break;
		case 4:
			exitRoom();
			break;
		case 5:
			continueInRoom();
			break;
		case 6:
			showBookButNotIn();
			break;

		default:
			break;
		}
	}

	private static void continueInRoom() {
		
	}

	private static void exitRoom() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 入住管理模块
	 * 1，存在问题，入住者编号应该是自动增长的，而不应该手动写入
	 * 2，关于入住的时间，手否可以取系统的时间，
	 * 3，关于Guest试题类的设计不合理，难以处理
	 * 4，关于一段Sql语句的问题，因为本模块中设计到多个表的变动，
	 * 5，多个查询和修改语句，利用事务进行处理
	 * 6，关于回退模块？？？
	 */
	@SuppressWarnings("resource")
	private static void BookRoom() {
		List<RoomInfo> roomInfos=showEmptyRoom();
		System.out.println("正在进行入住手续办理。。。。。");
		System.out.println("请输入上述空房号码或者预订但是未入住的房间号码");
		Scanner in=new Scanner(System.in);
		String roomInfoNo=in.next();
		while(true){
			boolean flag=false;
			for(RoomInfo roomInfo:roomInfos){
				if (roomInfoNo.equals(roomInfo.getRoomInfoNo())) {
					flag=true;
				}
			}
			if (flag) {
				break;
			}else {
				System.out.println("请输入正确的房间号码：房间号只能是如下的房间号之一");
				showEmptyRoom();
			}
		}
		
		System.out.println("请输入办理者编号，");
		String guestNo=in.next();
		System.out.println("请输入办理者名字，");
		String guestName=in.next();
		System.out.println("请输入办理者身份证号，");
		String guestShenFenNo=in.next();
		System.out.println("请输入办理者手机号，");
		String guestPhoneNo=in.next();
		System.out.println("请输入住的时间，格式xxxx-xx-xx,如2008-11-11");
		String bookDate=in.next();
		System.out.println("请输入住到几号，格式xxxx-xx-xx,如2008-11-11");
		String bookTime=in.next();
		System.out.println("请输入住房间号：");
		String roomInfoNo_In=in.next();
		Guest guest=new Guest(guestNo, guestName, guestShenFenNo, 
				guestPhoneNo, bookDate, bookTime, roomInfoNo_In);
		int a=-1;
		try {
			a=new GuestDaoImpl().addGuest(guest);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		boolean isAllRight=false;
		try {
			isAllRight=new InRoomDaoImpl().bookRoom(roomInfoNo_In);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isAllRight&&a!=-1) {
			System.out.println("入住办理成功。");
		}
	}

	private static void unPreBookRoom() {
		
	}

	private static void preBookRoom() {
		
	}

	private static List<RoomInfo> showBookButNotIn() {
		List<RoomInfo> roomInfos=new ArrayList<RoomInfo>();
		try {
			roomInfos=new InRoomDaoImpl().bookButNotIn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("所有预定未入住的情况如下：");
		if(roomInfos.size()!=0&&roomInfos!=null){
			for(RoomInfo roomInfo:roomInfos){
				System.out.println(roomInfo);
			}
		}
		return roomInfos;
	}
	private static List<RoomInfo> showEmptyRoom(){
		List<RoomInfo> roomInfos=new ArrayList<RoomInfo>();
		try {
			roomInfos=new InRoomDaoImpl().findEmptyRoom();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(roomInfos.size()!=0&&roomInfos!=null){
			System.out.println("所有空房情况如下：");
			for(RoomInfo roomInfo:roomInfos){
				System.out.println(roomInfo);
			}
		}else {
			System.out.println("没有空房了，请查看预订未入住情况。");
			showBookButNotIn();
		}
		return roomInfos;
		
	}
}
