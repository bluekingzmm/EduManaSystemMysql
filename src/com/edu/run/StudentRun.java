/**
 * 
 */
package com.edu.run;

import java.util.Scanner;

import com.edu.dao.IScore;
import com.edu.dao.IStudent;
import com.edu.dao.impl.ScoreImplMysql;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dto.Student;
import com.edu.service.AdminAssit;
import com.edu.service.CourseAiist;
import com.edu.service.ScourseAiist;
import com.edu.service.StudentAiist;

/**
 * @author Administrator
 *
 */
public class StudentRun {

	static Scanner sc = new Scanner(System.in);
	static IStudent si = new StudentImplMysql();
	static IScore is = new ScoreImplMysql();
	static CourseAiist ic = new CourseAiist();
	static StudentAiist sa = new StudentAiist();
	static ScourseAiist s = new ScourseAiist();
	static AdminAssit aa=new AdminAssit();

	/*
	 * ������ѧ�����˵���Ϣ
	 */

	public static void dispStudentMenu() {
		System.out.println("1:*******************************��ʾ������Ϣ");
		System.out.println("2:*******************************�鿴�ɼ�����Ϣ");
		System.out.println("3:********************************������****");
		System.out.println("4:******************************�޸ĸ�����Ϣ****");
		System.out.println("5:*****************����ѡ��(ѡ����Ҳ���޸�)***********");
		System.out.println("6:**************************�鿴�Լ�ѡ��***********");
		System.out.println("7:**************************ѡ����Ϣ***********");
		System.out.println("0:********************************����ϵͳ****");
		System.out.println("**************���������ѡ��*******************");

	}


	/*
	 * ���ܣ�ѡ�����˵���Ϣ
	 */
	public static void selectCourse() throws Exception {
		boolean flag = true;
		try {
			while (flag) {
				System.out.println("1:  �˽�γ���Ϣ");
				System.out.println("2����ѯ�γ̵Ĵ�����ʦ");
				System.out.println("0: �������˵�");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:  �˽�γ���Ϣ");
					// knowCourse();
					ic.dispAllCourse();

					break;
				case 2:
					System.out.println("2����ѯ�γ̵Ĵ�����ʦ\n");

					s.selectBytea();
					break;
				case 0:
					flag = false;
					break;

				default:
					break;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * ѧ���������˵� ��Ҫ����ѧ�ź����룬���ɽ���ϵͳ
	 */
	public static void StuMenu() {
		try {
			boolean flag = true;
			System.out.println("���������ѧ��ѧ��");
			String stu_id = sc.next();
			System.out.println("�������������");
			String stu_password = sc.next();
			Student stu = si.loginStudent(stu_id, stu_password);
			if (stu != null) {
				System.out.println("��ӭ��:" + stu.getName());
				while (flag) {
					dispStudentMenu();
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("1:*******************************��ʾ������Ϣ");
						sa.findStudent(stu_id);
						break;
					case 2:
						System.out.println("2:*******************************�鿴���˳ɼ���Ϣ");
						aa.findOneScore(stu_id);

						break;
					case 3:
						System.out.println("********************************����ϵͳ****");
						aa.changePassword();
						break;
					case 4:
						System.out.println("4:******************************�޸ĸ�����Ϣ****");
						aa.modifyStudent(stu_id);
						break;
					case 5:
						System.out.println("5:*****************����ѡ��(ѡ����Ҳ���޸�)***********");

						s.addScourse(stu_id);

						break;
					case 6:
						System.out.println("6:**************************�鿴�Լ�ѡ��***********");
						s.dispOneScourse(stu_id);
						break;
					case 7:
						System.out.println("***********************ѡ����Ϣ****");
						selectCourse();
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
				System.out.println("ѧ�������ڣ���");
			}
		} catch (Exception e) {

		}

	}

}
