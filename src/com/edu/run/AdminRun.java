/**
 * 
 */
package com.edu.run;

import java.util.Scanner;

import com.edu.service.AssessAiist;
import com.edu.service.CourseAiist;
import com.edu.service.ScourseAiist;
import com.edu.service.StuScoreAiist;
import com.edu.service.StudentAiist;
import com.edu.service.TeacherAiist;

/**
 * @author Administrator
 *
 */
public class AdminRun {

	/**
	 * @param args
	 */

	static Scanner sc = new Scanner(System.in);
	static TeacherAiist ta = new TeacherAiist();
	static StudentAiist si = new StudentAiist();
	static AssessAiist aa = new AssessAiist();
	static CourseAiist ca = new CourseAiist();
	static StuScoreAiist Sa = new StuScoreAiist();
	static ScourseAiist sa = new ScourseAiist();

	/*
	 * ������ѧ�����˵� switch����ѡ��
	 */

	public static void StudentMain() {
		try {
			boolean flag = true;
			while (flag) {
				dispMenu();
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:***********    ���ѧ����Ϣ       ***********");
					si.addStudent();
					break;
				case 2:
					System.out.println("2:***********    ��ʾѧ����Ϣ       ***********");
					si.dispAllStudent();
					break;
				case 3:
					System.out.println("3:***********    ɾ��ѧ����Ϣ       ***********");
					si.deleteStudent();
					break;
				case 4:
					System.out.println("4:***********    �޸�ѧ����Ϣ       ***********");
					si.modifyStudent();
					break;

				case 5:
					System.out.println("5:***********    ��ѯѧ����Ϣ       ***********");
					si.findStudent();
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
	 * �������γ����˵�
	 */
	public static void courseInfo() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				System.out.println("1:*******************************���ӿγ���Ϣ");
				System.out.println("2:*******************************ɾ���γ���Ϣ");
				System.out.println("3:*******************************�޸Ŀγ���Ϣ");
				System.out.println("4:*************************���տγ̱�Ų�ѯ�γ���Ϣ");
				System.out.println("5:*******************************��ѯ�γ�������Ϣ");
				System.out.println("0:**********************************�������˵�");

				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:*******************************���ӿγ���Ϣ");
					ca.AddCourse();
					break;
				case 2:
					System.out.println("2:*******************************ɾ���γ���Ϣ");
					ca.DelectCourse();
					break;
				case 3:
					System.out.println("3:*******************************�޸Ŀγ���Ϣ");
					ca.ModifyCourse();
					break;
				case 4:
					System.out.println("4:**************************���տγ̱�Ų�ѯ�γ���Ϣ");
					ca.findByCode();
					break;
				case 5:
					System.out.println("5:*******************************��ѯ�γ�������Ϣ");
					ca.dispAllCourse();
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
	 * ����:ѧ�����˵���Ϣ
	 */
	public static void dispMenu() {
		System.out.println("1:***********    ���ѧ����Ϣ       ***********");
		System.out.println("2:***********    ��ʾѧ����Ϣ       ***********");
		System.out.println("3:***********    ɾ��ѧ����Ϣ       ***********");
		System.out.println("4:***********    �޸�ѧ����Ϣ       ***********");
		System.out.println("5:***********    ��ѯѧ����Ϣ   *****");
		// System.out.println("6:*********** ����������ѯѧ����Ϣ *****");
		// System.out.println("7:*********** ����ѧ����Ϣ ***********");
		System.out.println("0:***********    ����ѧ���˵�       ***********");
		System.out.println("                ���������ѡ��");
	}

	/*
	 * ��������ʦ���˵�
	 */
	public static void TeacherMain() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				dispTeacherMenu();
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:***********    ��ӽ�ʦ��Ϣ       ***********");
					ta.addTeacher();

					break;

				case 2:
					System.out.println("2:***********    ��ʾ��ʦ��Ϣ       ***********");
					ta.dispAllTeacher();

					break;
				case 3:
					System.out.println("3:***********    ɾ����ʦ��Ϣ       ***********");
					ta.deleteTeacher();

					break;
				case 4:
					System.out.println("4:***********    �޸Ľ�ʦ��Ϣ       ***********");
					ta.modifyTeacher();

					break;
				case 5:
					System.out.println("5:***********    ��ѯ��ʦ��Ϣ       ***********");
					ta.findTeacher();

					break;
				case 6:
					System.out.println("6:***********    �����ʦ��Ϣ       ***********");
					ta.sortTeacher();
				case 0:
					flag = false;
				default:
					break;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * ��������ʦ�������˵�
	 */
	public static void AssessMain() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				dispAssessMenu();
				int key = sc.nextInt();
				switch (key) {

				case 1:
					System.out.println("1:***********    ��ʾ������Ϣ       ***********");
					aa.dispAllAssess();
					break;
				case 2:
					System.out.println("3:***********    ɾ��������Ϣ       ***********");
					aa.deleteAssess();
					break;
				case 3:
					System.out.println("4:***********    �޸�������Ϣ       ***********");
					aa.modeifyAssess();
					break;
				case 4:
					System.out.println("5:***********    ��ѯ������Ϣ       ***********");
					aa.findAssess();
					break;
				case 0:
					flag = false;
				default:
					break;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * ��������ʦ���˵���Ϣ
	 */
	public static void dispTeacherMenu() {
		System.out.println("1:***********    ���ӽ�ʦ��Ϣ       ***********");
		System.out.println("2:***********    ��ʾ��ʦ��Ϣ       ***********");
		System.out.println("3:***********    ɾ����ʦ��Ϣ       ***********");
		System.out.println("4:***********    �޸Ľ�ʦ��Ϣ       ***********");
		System.out.println("5:***********    ��ѯ��ʦ��Ϣ       ***********");
		System.out.println("6:***********    �����ʦ��Ϣ       ***********");
		System.out.println("0:***********    ���ؽ�ʦ�˵�       ***********");
		System.out.println("                ���������ѡ��");
	}

	/*
	 * ��������ʦ�������˵���Ϣ
	 */
	public static void dispAssessMenu() {
		System.out.println("1:***********    ��ʾ������Ϣ       ***********");
		System.out.println("2:***********    ɾ��������Ϣ       ***********");
		System.out.println("3:***********    �޸�������Ϣ       ***********");
		System.out.println("4:***********    ��ѯ������Ϣ       ***********");
		System.out.println("0:***********    ���ز˵�       ***********");
		System.out.println("                ���������ѡ��");
	}

	/*
	 * �������ɼ����˵���Ϣ
	 */
	public static void scoreInfo() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				// System.out.println("1:*******************************��ӳɼ���Ϣ");
				System.out.println("1:********************************ɾ���ɼ���Ϣ****");
				System.out.println("2:********************************�޸ĳɼ���Ϣ****");
				System.out.println("3:********************����ѧ��ѧ��ɾ�����гɼ���Ϣ****");
				System.out.println("4:*******************���տγ̱��ɾ�����гɼ���Ϣ�ɼ�****");
				System.out.println("5:*******************���տγ̱�Ų�ѯ���гɼ���Ϣ�ɼ�****");
				System.out.println("6:*******************����ѧ��ѧ�Ų�ѯ���гɼ���Ϣ�ɼ�****");
				System.out.println("7:*******************�鿴���гɼ�*******************");
				System.out.println("8:***************���տγ̱�Ž��з��������ɸߵ��ͣ���ʾ**");
				System.out.println("9:***************���տγ̱�Ų鿴���γ̳ɼ����ֺܷ�ƽ����**");
				System.out.println("0:*******************************�������˵�*********");

				int key = sc.nextInt();
				switch (key) {

				// case 1:
				// System.out.println("1:*******************************��ӳɼ���Ϣ");
				// Sa.addStuScore();
				// break;
				case 1:
					System.out.println("1:********************************ɾ���ɼ���Ϣ****");
					Sa.deleteScore();
					break;
				case 2:
					System.out.println("2:********************************�޸ĳɼ���Ϣ****");
					Sa.modifyStuScore();
					break;
				case 3:
					System.out.println("3:********************����ѧ��ѧ��ɾ�����гɼ���Ϣ****");
					Sa.deleteScoreByStu();
					break;
				case 4:
					System.out.println("4:*******************���տγ̱��ɾ�����гɼ���Ϣ�ɼ�****");
					Sa.deleteScoreByCourse();
					break;
				case 5:
					System.out.println("5:*******************���տγ̱�Ų�ѯ���гɼ���Ϣ�ɼ�****");
					Sa.findScoreByCourse();
					break;
				case 6:
					System.out.println("6:*******************����ѧ��ѧ�Ų�ѯ���гɼ���Ϣ�ɼ�****");
					Sa.findScoreByStu();
					break;
				case 7:
					System.out.println("7:*******************�鿴���гɼ�()***************");
					Sa.ListAllScore();
					break;
				case 8:
					System.out.println("8:***************���տγ̱�Ž��з��������ɸߵ��ͣ���ʾ**");
					Sa.disp();
					break;
				case 9:
					System.out.println("9:***************���տγ̱�Ų鿴���γ̳ɼ����ֺܷ�ƽ����**");
					Sa.findCourseScoreLookExam();
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
	 * ���������˵���Ϣ
	 */
	public static void MainMenu() {
		boolean flag = true;
		try {
			while (flag) {
				System.out.println("1��ѧ������ ");
				System.out.println("2:��ʦ����");
				System.out.println("3:�γ̹���");
				System.out.println("4:�ɼ�����");
				System.out.println("5:���۹���");
				System.out.println("6:ѡ�ι���");
				System.out.println("0:�������˵�");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					StudentMain();
					break;
				case 2:
					TeacherMain();
					break;
				case 3:
					courseInfo();
					break;
				case 4:
					scoreInfo();
					break;
				case 5:
					AssessMain();
					break;
				case 6:
					selectCourse();

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
	 * ������ѡ�����˵���Ϣ
	 */
	public static void selectCourse() throws Exception {
		boolean flag = true;
		try {
			while (flag) {
				System.out.println("1����ѯ�γ̵Ĵ�����ʦ");
				System.out.println("2:�鿴ѡ�����");
				System.out.println("3:�ſ�");
				System.out.println("0: �������˵�");
				int key = sc.nextInt();
				switch (key) {

				case 1:
					System.out.println("1����ѯ�γ̵Ĵ�����ʦ\n");
					sa.selectBytea();
					break;
				case 2:
					System.out.println("2:�鿴ѡ�����");
					sa.dispScourse();
					break;
				case 3:
					System.out.println("3:�ſ�");
					ca.dispAllCourse();
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

}
