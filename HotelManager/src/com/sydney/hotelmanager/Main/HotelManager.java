package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sydney.hotelmanager.dao.HotelInfoDao;
import com.sydney.hotelmanager.daoImpl.HotelInfoDaoImpl;
import com.sydney.hotelmanager.entity.HotelInfo;

public class HotelManager {
	/**
	 * 酒店管理
	 */
	public static void initHotelManager(){
		System.out.println("----------酒店管理---------------");
		System.out.println("------1，酒店一览，2，新增酒店-------");
		System.out.println("------3，编辑酒店，4，删除酒店-------");
		System.out.println("----请输入数字选择功能操作（1,2,3,4）---------");
	}
	
	@SuppressWarnings("resource")
	public static void doHotelManager(){
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		switch (num) {
		case 1:
			HotelManager.findAll();
			break;
		case 2:
			HotelManager.add();
			break;
		case 3:
			HotelManager.update();
			break;
		case 4:
			HotelManager.delete();
			break;

		default:
			break;
		}
	}
	//查看所有酒店信息
	public static void findAll(){
		List<HotelInfo> hotelInfos=new ArrayList<HotelInfo>();
		try {
			hotelInfos=new HotelInfoDaoImpl().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("查找出的所有信息为：");
		for(HotelInfo hotelInfo:hotelInfos){
			System.out.println(hotelInfo);
		}
		
		BackUp.hotelManagerBackUp();
		return;
	}
	@SuppressWarnings("resource")
	public static void delete(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入要输入的酒店的编号：");
		String hotelNo=scanner.next();
		try {
			new HotelInfoDaoImpl().delete(hotelNo);
			System.out.println("delete success ,please continue.....");
			BackUp.hotelManagerBackUp();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("resource")
	public static void add(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入酒店编号:");
		String hotelNo=scanner.next();
		System.out.println("请输入酒店名字：");
		String hotelName=scanner.next();
		System.out.println("请输入酒店经理名字：");
		String hotelManager=scanner.next();
		System.out.println("请输入酒店电话号码：");
		String hotelTel=scanner.next();
		System.out.println("请输入酒店的地址：");
		String hotelAdress=scanner.next();
		System.out.println("请输入是否是主店（1，主店，0，不是主店");
		int isMainHotel=scanner.nextInt();
		
		HotelInfo hotelInfo=new HotelInfo(hotelNo, hotelName, hotelManager,
				hotelTel, hotelAdress, isMainHotel);
		
		try {
			new HotelInfoDaoImpl().add(hotelInfo);
			System.out.println("insert success,please continue");
			BackUp.hotelManagerBackUp();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("resource")
	public static void update(){
		System.out.println("请输入要修改的酒店编号：");
		Scanner scanner=new Scanner(System.in);
		String hotelNo=scanner.next();
		
		HotelInfoDao dao=new HotelInfoDaoImpl();
		try {
			HotelInfo hotelInfo=dao.findById(hotelNo);
			System.out.println("请输入要修改的字段好，1,旅馆名称,2，旅馆经理，3，旅馆电话，"
					+ "4，旅馆地址，5，是否主店，");
			int num=scanner.nextInt();
			while(num!=1&&num!=2&&num!=3&&num!=4&&num!=5){
				System.out.println("输入的数字只能是1到5之间。。。");
				num=scanner.nextInt();
			}
			boolean flag=false;
			switch (num) {
			case 1:
				System.out.println("请输入旅馆名称：：");
				String hotelName=scanner.next();
				hotelInfo.setHotelName(hotelName);
				flag=true;
				break;
			case 2:
				System.out.println("请输入旅馆经理姓名：");
				String hotelManager=scanner.next();
				hotelInfo.setHotelManager(hotelManager);
				flag=true;
				break;
			case 3:
				System.out.println("请输入旅馆电话：");
				String hotelTel=scanner.next();
				hotelInfo.setHotelTel(hotelTel);
				flag=true;
				break;
			case 4:
				System.out.println("请输入旅馆地址：");
				String hotelAdress=scanner.next();
				hotelInfo.setHotelAdress(hotelAdress);
				flag=true;
				break;
			case 5:
				System.out.println("请输入是否是主店：");
				int isMainHotel=scanner.nextInt();
				hotelInfo.setisMainHotel(isMainHotel);
				flag=true;
				break;
			default:
				break;
			}
			if (flag) {
				dao.update(hotelInfo);
				System.out.println("update success,please continue....");
				BackUp.hotelManagerBackUp();
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
