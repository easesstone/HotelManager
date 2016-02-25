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
	 * ��ס��Ϣ����
	 */
	public static void initInRoomManager(){
		System.out.println("--------------��ס��Ϣ����-----------------");
		System.out.println("------1,�ͷ�Ԥ����2��ȡ��Ԥ����---------------");
		System.out.println("------3����ס��4���˷���5����ס---------------");
		System.out.println("------6��Ԥ��δ��ס�ͷ���Ϣ��ѯ---------------");
		System.out.println("----����������ѡ���ܲ�����1,2,3,4,5,6��---------");
	}
	
	@SuppressWarnings("resource")
	public static void doInRoomManager(){
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while(num!=1&&num!=2&&num!=3&&num!=4&&num!=5&&num!=6){
			System.out.println("���������ֻ����1��6����������롣����");
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
	 * ��ס����ģ��
	 * 1���������⣬��ס�߱��Ӧ�����Զ������ģ�����Ӧ���ֶ�д��
	 * 2��������ס��ʱ�䣬�ַ����ȡϵͳ��ʱ�䣬
	 * 3������Guest���������Ʋ��������Դ���
	 * 4������һ��Sql�������⣬��Ϊ��ģ������Ƶ������ı䶯��
	 * 5�������ѯ���޸���䣬����������д���
	 * 6�����ڻ���ģ�飿����
	 */
	@SuppressWarnings("resource")
	private static void BookRoom() {
		List<RoomInfo> roomInfos=showEmptyRoom();
		System.out.println("���ڽ�����ס����������������");
		System.out.println("�����������շ��������Ԥ������δ��ס�ķ������");
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
				System.out.println("��������ȷ�ķ�����룺�����ֻ�������µķ����֮һ");
				showEmptyRoom();
			}
		}
		
		System.out.println("����������߱�ţ�");
		String guestNo=in.next();
		System.out.println("��������������֣�");
		String guestName=in.next();
		System.out.println("��������������֤�ţ�");
		String guestShenFenNo=in.next();
		System.out.println("������������ֻ��ţ�");
		String guestPhoneNo=in.next();
		System.out.println("������ס��ʱ�䣬��ʽxxxx-xx-xx,��2008-11-11");
		String bookDate=in.next();
		System.out.println("������ס�����ţ���ʽxxxx-xx-xx,��2008-11-11");
		String bookTime=in.next();
		System.out.println("������ס����ţ�");
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
			System.out.println("��ס����ɹ���");
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
		System.out.println("����Ԥ��δ��ס��������£�");
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
			System.out.println("���пշ�������£�");
			for(RoomInfo roomInfo:roomInfos){
				System.out.println(roomInfo);
			}
		}else {
			System.out.println("û�пշ��ˣ���鿴Ԥ��δ��ס�����");
			showBookButNotIn();
		}
		return roomInfos;
		
	}
}
