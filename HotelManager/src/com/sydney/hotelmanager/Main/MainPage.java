package com.sydney.hotelmanager.Main;

import java.util.Scanner;

import com.sydney.hotelmanager.entity.User;

public class MainPage {
	
	
	/**
	 * 用户界面
	 */
	public static void initMainInterface(User user){
	
		//有待改善，，，因为如果数据有变动的话，会难以处理。。。。。。。
		System.out.println("-----------------用户主界面--------------------");
		if ("3001".equals(user.getUsername())||"3002".equals(user.getUsername())) {
			MainPage.initMainInterface2();
			MainPage.doMainInterface();
		}else {
			MainPage.initMainInterface1();
			MainPage.doMainInterface();
		}
	}
	/**
	 * 普通用户主界面
	 */
	public static void initMainInterface1(){
		System.out.println("|----1,密码管理，5，宾客信息管理，6，客房管理----------|");
		System.out.println("|----7,入住管理，8，财务管理，9，退出----------|");
		System.out.println("----请输入数字选择功能操作（1,5,6,7,8,9）---------");
	}
	
	/**
	 * 管理员主界面
	 */
	public static void initMainInterface2(){
		System.out.println("|-----1，密码管理；2，用户管理； 3，酒店管理；-----------|");
		System.out.println("|-----4，客房类型管理；5，宾客信息管理；6，客房管理；------|");
		System.out.println("|-----7，入住管理；8，财务管理，9，退出-----------------|");
		System.out.println("----请输入数字选择功能操作（1,2,3,4,5,6,7,8,9）---------");
	}
	/**
	 * 用户主页面初始化模块
	 * 还存在设计错误，对于管理员难以辨别
	 * @return
	 */
	public static int doMainInterface(){
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		
		if ("3001".equals(Login.user.getUsername())||
				"3002".equals(Login.user.getUsername())) {
			if (num==1) {
				PasswordEdit.initPasswordEdit();
				PasswordEdit.doPasswordEdit();
				return 1;
			}else if (num==2) {
				UserManager.initUserManager();
				UserManager.doUserManager();
				return 2;
			}else if (num==3) {
				HotelManager.initHotelManager();
				HotelManager.doHotelManager();
				return 3;
			}else if (num==4) {
				RoomTypeManager.initRoomTypeManager();
				RoomTypeManager.doRoomTypeManager();
				return 4;
			}else if (num==5){
				GuestManager.initGuestManager();
				GuestManager.doGuestManager();
				return 5;
			}else if (num==6) {
				RoomInfoManager.initRoomInfoManager();
				RoomInfoManager.doRoomInfoManager();
				return 6;
			}else if (num==7) {
				InRoomManager.initInRoomManager();
				InRoomManager.doInRoomManager();
				return 7;
			}else if (num==8){
				MoneyManager.initMoneyManager();
				MoneyManager.doMoneyManager();
				return 8;
			}else if(num==9){
				ExitManager.initExitManager();
				ExitManager.doExitManager();
				return 9;
			}else {
				return -1;
			}
		}else {
			if (num==1) {
				PasswordEdit.initPasswordEdit();
				PasswordEdit.doPasswordEdit();
				return 1;
			}else if (num==5){
				GuestManager.initGuestManager();
				GuestManager.doGuestManager();
				return 5;
			}else if (num==6) {
				RoomInfoManager.initRoomInfoManager();
				RoomInfoManager.doRoomInfoManager();
				return 6;
			}else if (num==7) {
				InRoomManager.initInRoomManager();
				InRoomManager.doInRoomManager();
				return 7;
			}else if (num==8){
				MoneyManager.initMoneyManager();
				MoneyManager.doMoneyManager();
				return 8;
			}else if(num==9){ 
				ExitManager.initExitManager();
				ExitManager.doExitManager();
				return 9;
			}else {
				System.out.println("something error.......");
				return -1;
			}
		}

	}

}
