package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sydney.hotelmanager.dao.RoomTypeDao;
import com.sydney.hotelmanager.daoImpl.RoomTypeDaoImpl;
import com.sydney.hotelmanager.entity.RoomType;

public class RoomTypeManager {
	/**
	 * 客房类型管理
	 */
	public static void initRoomTypeManager(){
		System.out.println("-----------客房类型管理-------------");
		System.out.println("-----1，客房类型一览，2，新增客房类型----");
		System.out.println("-----3，编辑客房类型，4，删除客房类型----");
		System.out.println("----请输入数字选择功能操作（1,2,3,4）---------");
	}
	
	/**
	 * doRoomTypeManager
	 */
	@SuppressWarnings("resource")
	public static void doRoomTypeManager(){
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		switch (num) {
		case 1:
			RoomTypeManager.findAll();
			break;
		case 2:
			RoomTypeManager.add();
			break;
		case 3:
			RoomTypeManager.update();
			break;
		case 4:
			RoomTypeManager.delete();
			break;

		default:
			break;
		}
	}
	public static void findAll(){
		List<RoomType>roomTypes=new ArrayList<RoomType>();
		try {
			roomTypes=new RoomTypeDaoImpl().findAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("查找的客房类型信息如下：");
		for(RoomType roomType:roomTypes){
			System.out.println(roomType);
		}
		BackUp.roomTypeManagerBackUp();
		
	}
	@SuppressWarnings("resource")
	public static void add(){
		System.out.println("添加客房类型信息：");
		System.out.println("请输入客房类型编号：");
		Scanner scanner=new Scanner(System.in);
		String roomTypeNo=scanner.next();
		System.out.println("请输入客房类型名称：");
		String roomTypeName=scanner.next();
		System.out.println("请输入客房价格：");
		double roomPrice=scanner.nextDouble();
		
		RoomType roomType=new RoomType(roomTypeNo, roomTypeName, roomPrice);
		
		try {
			new RoomTypeDaoImpl().add(roomType);
			BackUp.roomTypeManagerBackUp();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("resource")
	public static void delete(){
		System.out.println("请输入要删除的客房类型编号：");
		Scanner scanner=new Scanner(System.in);
		
		String roomTypeNo=scanner.next();
		
		try {
			new RoomTypeDaoImpl().delete(roomTypeNo);
			System.out.println("delete success,please continue....");
			BackUp.roomTypeManagerBackUp();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public static void update(){
		System.out.println("请输入要修改的客房类型编号。");
		Scanner scanner=new Scanner(System.in);
		
		String roomTypeNo=scanner.next();
		RoomTypeDao dao=new RoomTypeDaoImpl();
		try {
			RoomType roomType=dao.findById(roomTypeNo);
			
			System.out.println("请输入要修改的字段的编号：1，客房类型名称，2，客房价格：");
			
			int num=scanner.nextInt();
			while(num!=1&&num!=2){
				System.out.println("请从新输入，输入的数字只能是1或者2");
				num=scanner.nextInt();
			}
			
			boolean flag=false;
			switch (num) {
			case 1:
				System.out.println("---------修改客房类型名称----------");
				System.out.println("请输入客房类型名称：");
				String roomTypeName=scanner.next();
				roomType.setRoomTypeName(roomTypeName);
				flag=true;
				break;
			case 2:
				System.out.println("-------修改客房价格-----------");
				System.out.println("请输入客房价格；；；；");
				double roomPrice=scanner.nextDouble();
				roomType.setPrice(roomPrice);
				flag=true;
				break;
			default:
				break;
			}
			if (flag) {
				dao.update(roomType);
				System.out.println("update success,please continue.....");
				BackUp.roomTypeManagerBackUp();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

