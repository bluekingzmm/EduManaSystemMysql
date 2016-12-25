/**
 * 
 */
package com.edu.run;

import java.util.Scanner;

import com.edu.dao.ITeacher;
import com.edu.dao.impl.TeacherImplMysql;
import com.edu.dto.Teacher;
import com.edu.service.AdminAssit;
import com.edu.service.AssessAiist;
import com.edu.service.StuScoreAiist;
import com.edu.service.StudentAiist;
import com.edu.service.TeacherAiist;

/**
 * @author Administrator
 *
 */
public class TeacherRun {

	static Scanner sc = new Scanner(System.in);
	static ITeacher teacher = new TeacherImplMysql();
	static TeacherAiist ta = new TeacherAiist();
	static StudentAiist sa = new StudentAiist();
	static StuScoreAiist ssa = new StuScoreAiist();
	static AssessAiist Aa = new AssessAiist();
	static AdminAssit aa = new AdminAssit();

	public static void dispTeacherMenu() {
		System.out.println("1:*******************************��ʾ������Ϣ");
		System.out.println("2:*****************************�鿴����ѧ����Ϣ");
		System.out.println("3:**********************�鿴����ѧ���ɼ���Ϣ****");
		System.out.println("4:**********************�޸�����*************");
		System.out.println("5:*******************�޸ĸ�����Ϣ*************");
		System.out.println("6:*****************��ӱ���ѧ���ɼ�*************");
		System.out.println("7:*******************��ʾ�Լ�����**************");
		System.out.println("0:********************************����ϵͳ****");
		System.out.println("**************���������ѡ��*******************");

	}

	/*
	 * ����:��ʦ���˵�
	 */
	public static void TeacherMain() {
		try {

			boolean flag = true;
			System.out.println("��������Ľ�ʦ���");
			String code = sc.next();

			System.out.println("�������������");
			String tea_password = sc.next();

			Teacher tea = teacher.loginTeacher(code, tea_password);
			if (tea != null) {
				System.out.println("��ӭ��:" + tea.getName());
				while (flag) {
					dispTeacherMenu();
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("1:*******************************��ʾ������Ϣ");
						aa.findOneTeacher(code);

						break;
					case 2:
						System.out.println("2:*******************************�鿴����ѧ����Ϣ");
						aa.dispStudentInfo(code);
						break;
					case 3:
						System.out.println("3:********************************�鿴����ѧ���ɼ���Ϣ****");
						aa.dispStudentScore(code);
						break;
					case 4:
						System.out.println("4:**********************�޸�����****");
						aa.changePassword();
						break;
					case 5:
						System.out.println("5:*******************�޸ĸ�����Ϣ****");
						aa.modifyTeacher(code);
						break;
					case 6:
						System.out.println("6:*****************��ӱ���ѧ���ɼ�*************");
						ssa.addStuScore(code);
						break;
					case 7:
						System.out.println("7:*******************��ʾ�Լ�����**************");
						Aa.findMemoByTeacher(code);

						break;
					case 0:
						System.out.println("********************************����ϵͳ****");
						flag = false;

						break;
					default:
						break;

					}
				}

			} else {
				System.out.println("��ʦ�����ڣ���");
			}
		} catch (Exception e) {

		}

	}

}
