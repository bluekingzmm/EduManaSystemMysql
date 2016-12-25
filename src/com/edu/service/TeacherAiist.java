/**
 * 
 */
package com.edu.service;

import java.util.List;

import java.util.Scanner;

import com.edu.dao.IAdmin;
import com.edu.dao.ICourse;
import com.edu.dao.IStudent;
import com.edu.dao.ITeacher;
import com.edu.dao.impl.AdminMysqlImpl;
import com.edu.dao.impl.CourseImplMysql;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dao.impl.TeacherImplMysql;
import com.edu.dto.Teacher;
/**
 * @author ��̶
 *  ���ܣ����ӣ�ɾ�����޸ģ���ѯ����ʾ�����򣬽�ʦ��¼
 *
 */
public class TeacherAiist {

	static ITeacher teacher = new TeacherImplMysql();
	static Scanner sc = new Scanner(System.in);
	static IStudent student = new StudentImplMysql();
	static ICourse course = new CourseImplMysql();
	static IAdmin admin=new AdminMysqlImpl();

	/*
	 * ���ܣ���ӽ�ʦ 
	 */
	public void addTeacher() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Teacher tea = new Teacher();
				System.out.println("�������ʦ���");
				tea.setNum(sc.next());
				System.out.println("�������ʦ����");
				tea.setName(sc.next());
				System.out.println("�������ʦ�Ա�");
				tea.setSex(sc.next());
				System.out.println("�������ʦ����");
				tea.setAge(sc.nextInt());
				System.out.println("�������ʦ���ڿεı��");
				tea.setCourse_id(sc.next());
				System.out.println("�������ʦ�ĵ绰����");
				tea.setTea_tel(sc.next());
				if (teacher.addTeacher(tea)) {
					System.out.println("��ӳɹ���");
				} else {
					System.out.println("���ʧ��");
				}
				System.out.println("����n����Nֹͣ��ӣ����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * ���ܣ���ʾ���н�ʦ��Ϣ
	 */
	public void dispAllTeacher() throws Exception {
		List<Teacher> sList = teacher.dispAllTeacher();
		System.out.println("��ʦ���\t��ʦ����\t�Ա�\t����\t���ڿογ̱��\t�绰����\t�ȼ�");
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
	}

	

	/*
	 * ���ܣ�ɾ����ʦ��Ϣ
	 */
	public void deleteTeacher() throws Exception {

		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {

				System.out.println("�������ʦ���");
				String code = sc.next();
				Teacher tea = teacher.findTeacher(code);
				if (tea != null) {
					System.out.println("�Ƿ�Ҫɾ�����ǵĻ�����1�ٴ�ȷ��ɾ����������˳�ɾ��");
					System.out.println("��ʦ���\t��ʦ����\t�Ա�\t����\t���ڿογ̱��\t�绰����");
					System.out.println(tea);
					int key = sc.nextInt();
					if (key == 1) {
						if (teacher.deleteTeacher(code)) {
							System.out.println("ɾ���ɹ�");
						} else {
							System.out.println("ɾ��ʧ�ܣ�");
						}
					}
				} else {
					System.out.println("��ʦ��Ų����ڣ�");
				}

				System.out.println("����n����Nֹͣɾ�������������");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * ���ܣ���ѯ��ʦ��Ϣ
	 * 
	 */

	public void findTeacher() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("�������ʦ�ı��");
				String code = sc.next();
				Teacher tea = teacher.findTeacher(code);
				if (tea != null) {
					System.out.println("��ʦ���\t��ʦ����\t�Ա�\t����\t���ڿογ̱��\t�绰����\t����\t�ȼ�");
					System.out.println(tea);
				} else {
					System.out.println("��ʦ��Ų����ڣ�");
				}
				System.out.println("����n����Nֹͣ���ң����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	/*
	 * ���ܣ��޸Ľ�ʦ��Ϣ
	 */
	public void modifyTeacher() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������Ҫ�޸ĵĽ�ʦ���");
				String code = sc.next();
				Teacher tea = teacher.findTeacher(code);
				if (tea != null) {
					System.out.println("��ʦ���\t��ʦ����\t�Ա�\t����\t���ڿογ̱��\t�绰����");
					System.out.println(tea);
					System.out.println("1���������ʦ����");
					System.out.println("2���������ʦ�Ա�");
					System.out.println("3���������ʦ����");
					System.out.println("4�����������ڿογ̱��");
					System.out.println("5��������绰���� ");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("1���������ʦ����");
						tea.setName(sc.next());
						break;
					case 2:
						System.out.println("2���������ʦ�Ա�");
						tea.setSex(sc.next());
						break;
					case 3:
						System.out.println("3���������ʦ����");
						tea.setAge(sc.nextInt());
						break;
					case 4:
						System.out.println("4�����������ڿογ̱��");
						tea.setCourse_id(sc.next());
						break;
					case 5:
						System.out.println("5��������绰����");
						tea.setTea_tel(sc.next());
						break;
				

					default:
						break;
					}
					if (teacher.modifyTeacher(tea)) {
						System.out.println("�޸ĳɹ���");
					} else {
						System.out.println("�޸�ʧ�ܣ�");
					}
				} else {
					System.out.println("��ʦ��Ų����ڣ�");
				}
				System.out.println("����n����Nֹͣ�޸ģ����������");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * ���ܣ���ʦ����
	 */
	public void sortTeacher() throws Exception {

		String yes = "y";
		try {
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("���ս�ʦ�ȼ�����");
				List<Teacher> sList = teacher.sortTeacher();
				System.out.println("��ʦ���\t��ʦ����\t�Ա�\t����\t���ڿογ̱��\t�绰����\t�ȼ�");
				for (int i = 0; i < sList.size(); i++) {
					System.out.println(sList.get(i));
				}
				System.out.println("����n����Nֹͣ���������������");
				yes=sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}



	
}
