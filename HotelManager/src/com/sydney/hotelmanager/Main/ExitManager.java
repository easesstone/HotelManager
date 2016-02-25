package com.sydney.hotelmanager.Main;

import java.util.Scanner;

public class ExitManager {
	/**
	 * 退出
	 */
	public static void initExitManager(){
		System.out.println("----------退出--------------");
	}
	
	/**
	 * 退出操作
	 */
	@SuppressWarnings("resource")
	public static void doExitManager(){
		System.out.println("请输入0退出到登录界面,或者1取消.");
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		switch (num) {
		case 1:
			Login.initLogin();
			Login.login();
			break;
		case 2:
			MainPage.initMainInterface(Login.user);
			MainPage.doMainInterface();
			break;

		default:
			break;
		}
	}

}
