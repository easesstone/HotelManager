package com.sydney.hotelmanager.Main;

import java.util.Scanner;

public class BackUp {

	@SuppressWarnings("resource")
	public static void hotelManagerBackUp(){
		System.out.println("输入0返回上一界面或者1返回主界面");
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while(num!=0&&num!=1){
			System.out.println("输入的数字只能是0或者1,请从新输入");
			num=scanner.nextInt();
		}
		switch (num) {
		case 0:
			HotelManager.initHotelManager();
			HotelManager.doHotelManager();
			break;
		case 1:
			MainPage.initMainInterface(Login.user);
			break;
		default:
			break;
		}
	}
	
	@SuppressWarnings("resource")
	public static void roomTypeManagerBackUp(){
		System.out.println("输入0返回上一界面或者1返回主界面");
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while(num!=0&&num!=1){
			System.out.println("输入的数字只能是0或者1,请从新输入");
			num=scanner.nextInt();
		}
		switch (num) {
		case 0:
			RoomTypeManager.initRoomTypeManager();
			RoomTypeManager.doRoomTypeManager();
			break;
		case 1:
			MainPage.initMainInterface(Login.user);
			break;
		default:
			break;
		}
		
	}
	@SuppressWarnings("resource")
	public static void roomInfoManagerBackUp(){
		System.out.println("输入0返回上一界面或者1返回主界面");
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while(num!=0&&num!=1){
			System.out.println("输入的数字只能是0或者1,请从新输入");
			num=scanner.nextInt();
		}
		switch (num) {
		case 0:
			RoomInfoManager.initRoomInfoManager();
			RoomInfoManager.doRoomInfoManager();
			break;
		case 1:
			MainPage.initMainInterface(Login.user);
			break;
		default:
			break;
		}
		
	}
	@SuppressWarnings("resource")
	public static void guestManagerBackUp(){
		System.out.println("输入0返回上一界面或者1返回主界面");
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while(num!=0&&num!=1){
			System.out.println("输入的数字只能是0或者1,请从新输入");
			num=scanner.nextInt();
		}
		switch (num) {
		case 0:
			GuestManager.initGuestManager();
			GuestManager.doGuestManager();
			break;
		case 1:
			MainPage.initMainInterface(Login.user);
			break;
		default:
			break;
		}
		
	}
	public static void MoneyManagerBackUp(){
		System.out.println("输入0返回上一界面或者1返回主界面");
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while(num!=0&&num!=1){
			System.out.println("输入的数字只能是0或者1,请从新输入");
			num=scanner.nextInt();
		}
		switch (num) {
		case 0:
			MoneyManager.initMoneyManager();
			MoneyManager.doMoneyManager();
			break;
		case 1:
			MainPage.initMainInterface(Login.user);
			break;
		default:
			break;
		}
		
	}
	
}
