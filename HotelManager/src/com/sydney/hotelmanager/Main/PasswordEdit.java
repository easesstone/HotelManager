package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.Scanner;

import com.sydney.hotelmanager.daoImpl.UserDaoImpl;

public class PasswordEdit {
	
	/**
	 * �����޸�
	 */
	public static void initPasswordEdit(){
		System.out.println("----------�����޸�----------------");
	}

	
	/**
	 * �û��޸�����ģ��
	 */
	public static void doPasswordEdit(){
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.println("----�����������ȷ��,��������exit�˳�����ҳ��---------------");
		String checkPassword=scanner.next();
		while(true){
			if (checkPassword.equals(Login.user.getPassword())) {
				System.out.println("�����������룺");
				String newpassword=scanner.next();
				Login.user.setPassword(newpassword);
				break;
			}if ("exit".equals(checkPassword)) {
				MainPage.initMainInterface(Login.user);
				return;
			}
			System.out.println("��������������ȷ��,��������exit�˻���һ����");
			checkPassword=scanner.next();
		} 
		try {
			if (Login.user!=null) {
				new UserDaoImpl().update(Login.user);
				System.out.println("sucess");
				MainPage.initMainInterface(Login.user);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		}
	}

}
