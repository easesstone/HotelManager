package com.sydney.hotelmanager.Main;

import java.util.Scanner;

public class InitMain {
	/**
	 * ��ʼ������
	 */
	@SuppressWarnings("resource")
	public static void initMain() {
		System.out.println("|--------------��ӭ��¼�Ƶ����ϵͳ----------------|");
		System.out.println("|-------------------��Ҫ����-----------------------|");
		System.out.println("|-----1���������2���û����� 3���Ƶ����-----------|");
		System.out.println("|-----4���ͷ����͹���5��������Ϣ����6���ͷ�����------|");
		System.out.println("|-----7����ס����8���������9���˳�-----------------|");
		Scanner scanner=new Scanner(System.in);
		System.out.println("������0�ȵ�¼����������-2����");
		int num=-1;
		while(true){
			num=scanner.nextInt();
			if(num==0){
				break;
			}else if (num==-1) {
				initMain();
			}
			System.out.println("������0�ȵ�¼����������-2����");
		}
		Login.initLogin();
	}
}
