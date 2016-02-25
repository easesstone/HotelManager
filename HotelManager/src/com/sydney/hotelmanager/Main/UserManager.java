package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sydney.hotelmanager.dao.UserDao;
import com.sydney.hotelmanager.daoImpl.UserDaoImpl;
import com.sydney.hotelmanager.entity.User;

public class UserManager {
	
	/**
	 * �û������ʼ��
	 */
	public static void initUserManager(){
		System.out.println("------------�û�����---------------");
		System.out.println("|-----1���û�һ����2�������û�--------|");
		System.out.println("|-----3���༭�û���4��ɾ���û�--------|");
		System.out.println("----����������ѡ���ܲ�����1,2,3,4��---------");
		UserManager.doUserManager();
	}
	
	/**
	 * �û�����ģ��
	 */
	@SuppressWarnings("resource")
	public static void doUserManager(){
		Scanner scanner=new Scanner(System.in);
		int num=0;
		while(true){
			num=scanner.nextInt();
			if (num==1) {
				doFindAllUserManager();
			}else if (num==2) {
				doAddUserManager();
			}else if (num==3) {
				doUpdateUserManager();
			}else if (num==4) {
				doDeleteUserManager();
			}else if (num==-1) {
				
			}else {
				System.out.println("����ֻ����1��4֮�䣬��������-1���������档��");
			}
		}
	}
	@SuppressWarnings("resource")
	public static void doAddUserManager(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("�������û��˺ţ�");
		String username=scanner.next();
		System.out.println("�������û����룺");
		String password=scanner.next();
		System.out.println("�������û�������");
		String realname=scanner.next();
		System.out.println("�����������Ƶ����");
		String hotelNo=scanner.next();
		System.out.println("�������Ƿ��Ǿ���");
		int isManager=scanner.nextInt();
		
		User user=new User(username, password, realname, hotelNo, isManager);
		UserDao dao=new UserDaoImpl();
		try {
			dao.add(user);
			System.out.println("insert success....");
			System.out.println("������0������һҳ������1������������");
			int num=scanner.nextInt();
			while (num!=0&&num!=1) {
				System.out.println("����ֵֻ����0��1,���������");
				num=scanner.nextInt();
			}
			switch (num) {
			case 0:
				UserManager.initUserManager();
				UserManager.doUserManager();
				break;
			case 1:
				MainPage.initMainInterface(Login.user);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("resource")
	public static void doFindAllUserManager(){
		UserDao dao=new UserDaoImpl();
		List<User>users=new ArrayList<User>();
		try {
			users=dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("���ҳɹ��������û����£�");
		for(User user:users){
			System.out.println(user);
		}
		System.out.println("������0������һҳ������1������������");
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while (num!=0&&num!=1) {
			System.out.println("����ֵֻ����0��1,���������");
			num=scanner.nextInt();
		}
		switch (num) {
		case 0:
			UserManager.initUserManager();
			UserManager.doUserManager();
			break;
		case 1:
			MainPage.initMainInterface(Login.user);
			break;
		default:
			break;
		}
	}
	@SuppressWarnings("resource")
	public static void doDeleteUserManager(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("������Ҫɾ�����˻����˻����룺");
		String username=scanner.next();
		if (username.equals(Login.user.getUsername())) {
			System.out.println("����ɾ����ǰ�û���������������û�����������");
			username=scanner.next();
		}
		UserDao dao=new UserDaoImpl();
		try {
			dao.delete(username);
			System.out.println("delete success......");
			System.out.println("������0������һҳ������1������������");
			int num=scanner.nextInt();
			while (num!=0&&num!=1) {
				System.out.println("����ֵֻ����0��1,���������");
				num=scanner.nextInt();
			}
			switch (num) {
			case 0:
				UserManager.initUserManager();
				UserManager.doUserManager();
				break;
			case 1:
				MainPage.initMainInterface(Login.user);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("resource")
	public static void doUpdateUserManager(){
		System.out.println("������Ҫ�޸ĵ��û����û�����");
		Scanner scanner=new Scanner(System.in);
		String username=scanner.next();
		User user=null;
		UserDao dao=new UserDaoImpl();
		try {
			user=dao.findById(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("������Ҫ�޸ĵ��ֶΣ�1���û����룬2���û�������3���û������Ƶ��ţ�"
				+"4,�Ƿ���Manager(����1��2��3��4)");
		int num=0;
		while(true){
			num=scanner.nextInt();
			if(num==1||num==2||num==3||num==4){
				break;
			}
			System.out.println("��������룬����ֻ����1��4֮�������");
		}
		
		boolean lable=false;
		switch (num) {
		case 1:
			System.out.println("----------�޸��û�����--------");
			System.out.println("�������û����룺");
			String password=scanner.next();
			user.setPassword(password);
			try {
				dao.update(user);
				System.out.println("success.......");
				lable=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("----------�޸��û�����----------");
			System.out.println("�����û�������");
			String realname=scanner.next();
			user.setRealname(realname);
			try {
				dao.update(user);
				System.out.println("success.......");
				lable=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("-------�޸��û������Ƶ���------------");
			System.out.println("�����������Ƶ��ţ�");
			String hotelNo=scanner.next();
			user.setPassword(hotelNo);
			try {
				dao.update(user);
				System.out.println("success.......");
				lable=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("-------�޸��û��Ƿ���Manager------");
			System.out.println("�������û��Ƿ���Manager0����1");
			int isManager=scanner.nextInt();
			user. setIsManager(isManager);
			try {
				dao.update(user);
				System.out.println("success.......");
				lable=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("something error.....");
			break;
		}
		if (lable) {
			System.out.println("������0������һҳ������1������������");
			int num1=scanner.nextInt();
			while (num1!=0&&num1!=1) {
				System.out.println("����ֵֻ����0��1,���������");
				num1=scanner.nextInt();
			}
			switch (num1) {
			case 0:
				UserManager.initUserManager();
				UserManager.doUserManager();
				break;
			case 1:
				MainPage.initMainInterface(Login.user);
				break;
			default:
				break;
			}
		}
	}
}
