/**
 * 
 */
package com.edu.run;

import java.util.Scanner;

import com.edu.service.AdminAssit;

/**
 * @author Administrator
 *
 */
public class Menu {
	static Scanner sc = new Scanner(System.in);
	static AdminAssit aa = new AdminAssit();

	public static void login() {
		try {
			disp();
			boolean flag = true;
			while (flag) {
				System.out.println("1������Ա��¼");
				System.out.println("2����ʦ��½");
				System.out.println("3:ѧ����½");
				System.out.println("0:�˳�ϵͳ");
				System.out.println("�����ѡ��");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					if (aa.loginAdmin()) {
						AdminRun.MainMenu();
					} else {
						System.out.println("�����������룡");
					}

					break;
				case 2:
					TeacherRun.TeacherMain();
					break;
				case 3:
					StudentRun.StuMenu();
					break;
				case 0:
					System.out.println("�����˳������Ժ�");
					for (int i = 0; i < 20; i++) {
						Thread.sleep(200);
						System.out.print("*");
					}

					System.exit(0);
					break;
				default:
					break;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void disp() throws Exception {
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������������\n");
		System.out.println(
				"��                                                                        ��\n");
		System.out.println(
				"��                                            **  ��ӭ������                                        ��\n");
		System.out.println(
				"��                                                �������ϵͳ                                    ��\n");
		System.out.println(
				"��                                                                       ��\n");
		System.out.println( 
				"��                                                                       ��\n");
		System.out.println(
				"��                          ******    ��������Ա�������������ƣ���̶��¬��ǿ                   ��\n");
		System.out.println(
				"��                                                            2016.6.17  ��\n");
		System.out.println(
				"��������������������������������������������������������������������������������������������������������������������������������������������������\n");
		for (int a = 0;  a < 40; a++) {
			Thread.sleep(40);
			System.out.print("<*");

		}
		System.out.println();
	}

}
