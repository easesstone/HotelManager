package com.sydney.hotelmanager.Main;

import java.util.Scanner;

public class ExitManager {
	/**
	 * �˳�
	 */
	public static void initExitManager(){
		System.out.println("----------�˳�--------------");
	}
	
	/**
	 * �˳�����
	 */
	@SuppressWarnings("resource")
	public static void doExitManager(){
		System.out.println("������0�˳�����¼����,����1ȡ��.");
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
