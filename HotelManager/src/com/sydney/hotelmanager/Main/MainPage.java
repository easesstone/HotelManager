package com.sydney.hotelmanager.Main;

import java.util.Scanner;

import com.sydney.hotelmanager.entity.User;

public class MainPage {
	
	
	/**
	 * �û�����
	 */
	public static void initMainInterface(User user){
	
		//�д����ƣ�������Ϊ��������б䶯�Ļ��������Դ���������������
		System.out.println("-----------------�û�������--------------------");
		if ("3001".equals(user.getUsername())||"3002".equals(user.getUsername())) {
			MainPage.initMainInterface2();
			MainPage.doMainInterface();
		}else {
			MainPage.initMainInterface1();
			MainPage.doMainInterface();
		}
	}
	/**
	 * ��ͨ�û�������
	 */
	public static void initMainInterface1(){
		System.out.println("|----1,�������5��������Ϣ����6���ͷ�����----------|");
		System.out.println("|----7,��ס����8���������9���˳�----------|");
		System.out.println("----����������ѡ���ܲ�����1,5,6,7,8,9��---------");
	}
	
	/**
	 * ����Ա������
	 */
	public static void initMainInterface2(){
		System.out.println("|-----1���������2���û����� 3���Ƶ����-----------|");
		System.out.println("|-----4���ͷ����͹���5��������Ϣ����6���ͷ�����------|");
		System.out.println("|-----7����ס����8���������9���˳�-----------------|");
		System.out.println("----����������ѡ���ܲ�����1,2,3,4,5,6,7,8,9��---------");
	}
	/**
	 * �û���ҳ���ʼ��ģ��
	 * ��������ƴ��󣬶��ڹ���Ա���Ա��
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
