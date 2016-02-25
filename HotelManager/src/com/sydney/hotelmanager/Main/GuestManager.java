package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sydney.hotelmanager.dao.GuestDao;
import com.sydney.hotelmanager.daoImpl.GuestDaoImpl;
import com.sydney.hotelmanager.entity.Guest;

public class GuestManager {
	/**
	 * 宾客信息管理
	 */
	public static void initGuestManager(){
		System.out.println("-------宾客信息管理------------");
		System.out.println("-------1，在店宾客查询-----------");
		System.out.println("-------2，宾客入住记录查询------------");
		System.out.println("----请输入数字选择功能操作（1,2）---------");
	}
	/**
	 * 宾客管理相关操作
	 */
	@SuppressWarnings("resource")
	public static void doGuestManager(){
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while(num!=1&&num!=2){
			System.out.println("输入的数字只能是1或者2,请从新输入：");
			num=scanner.nextInt();
		}
		switch (num) {
		case 1:
			finInNow();
			break;

		case 2:
			GuestRecord();
			break;
		default:
			break;
		}
	}
	@SuppressWarnings("resource")
	private static void GuestRecord() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入要根据什么查找客人记录：1，根据身份证号，2，根据日期");
		int num=scanner.nextInt();
		while(num!=1&&num!=2){
			System.out.println("输入的数字只能是1或者2");
			num=scanner.nextInt();
		}
		switch (num) {
		case 1:
			findByShenFenNo();
			break;
			
		case 2:
			findByDate();
			break;
		default:
			break;
		}
	}
	@SuppressWarnings("resource")
	private static void findByDate() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入要查询的日期：格式为xxxx-xx-xx");
		String bookDate=scanner.next();
		
		//增加检测的步骤，检查日期格式是否正确。
		List<Guest>guests=new ArrayList<Guest>();
		
		GuestDao dao=new GuestDaoImpl();
		try {
			guests=dao.findByDate(bookDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("按照日期查找的客人记录如下：");
		for(Guest guest:guests){
			System.out.println(guest);
		}
		BackUp.guestManagerBackUp();
	}
	@SuppressWarnings("resource")
	private static void findByShenFenNo() {
		System.out.println("请输入客人身份号码：");
		Scanner scanner=new Scanner(System.in);
		
		String guestShenFenNo=scanner.next();
		GuestDao dao=new GuestDaoImpl();
		List<Guest>guests=new ArrayList<Guest>();
		
		try {
			guests=dao.findById(guestShenFenNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("查找的顾客信息为：");
		for(Guest guest:guests){
			System.out.println(guest);
		}
		System.out.println();
		BackUp.guestManagerBackUp();
	}
	private static void finInNow() {
		GuestDao dao=new GuestDaoImpl();
		List<Guest>guests=new ArrayList<Guest>();
		try {
			guests=dao.findByInNow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("在店客人如下：");
		for(Guest guest:guests){
			System.out.println(guest);
		}
		System.out.println();
		BackUp.guestManagerBackUp();
	}
}
