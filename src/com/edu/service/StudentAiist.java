/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.IStudent;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dto.Student;

/**
 * @author ¬��ǿ ���ܣ����ӣ�ɾ�����޸ģ���ѯ����ʾѧ����Ϣ�� ѧ����¼
 *
 */
public class StudentAiist {

	static Scanner sc = new Scanner(System.in);
	IStudent student = new StudentImplMysql();

	/*
	 * ���ܣ����ѧ�� ��ʾ��ӵ�ʱ��
	 */
	public void addStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Student s = new Student();
				System.out.println("������ѧ��ѧ��");
				s.setNum(sc.next());
				System.out.println("������ѧ������");
				s.setName(sc.next());
				System.out.println("������ѧ���Ա�");
				s.setSex(sc.next());
				System.out.println("������ѧ������");
				s.setAge(sc.nextInt());
				System.out.println("������ѧ�������֤����");
				s.setStuId(sc.next());
				System.out.println("������ϵ��");
				System.out.println("1:����ϵ   2����óϵ  3�� ����ϵ  4�� ����ϵ   5  �� ��Ϣϵ  6�� ��ľϵ");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					s.setDepartment("����ϵ");
					break;
				case 2:
					s.setDepartment("��óϵ ");
					break;
				case 3:
					s.setDepartment("����ϵ");
					break;
				case 4:
					s.setDepartment("����ϵ ");
					break;
				case 5:
					s.setDepartment("��Ϣϵ");
					break;
				case 6:
					s.setDepartment("��ľϵ");
					break;

				default:
					break;
				}

				if (student.addStudent(s)) {
					System.out.println("��ӳɹ���");
				} else {
					System.out.println("���ʧ��!!");
				}

				System.out.println("����n��Nֹͣ��ӣ����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * ���ܣ���ʾ����ѧ����Ϣ
	 */
	public void dispAllStudent() throws Exception {
		List<Student> sList = student.lispStudent();
		System.out.println("ѧ��\t����\t�Ա�\t����\t���֤����\t\t\t��ҵ����\t\tϵ��");
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
	}

	/*
	 * ����:ɾ��ѧ����Ϣ
	 */
	public void deleteStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������ѧ��ѧ��");
				String num = sc.next();
				Student stu = student.findStudent(num);
				if (stu != null) {
					System.out.println("�Ƿ�Ҫɾ�����ǵĻ�����1�ٴ�ȷ��ɾ����������˳�ɾ��");
					System.out.println("ѧ��\t����\t�Ա�\t����\tרҵ\t\t�༶\t���֤����\t\t\t��ҵ����\tѡ�ογ�");
					System.out.println(stu);
					int key = sc.nextInt();
					if (key == 1) {
						if (student.deleteStudent(num)) {
							System.out.println("ɾ���ɹ�");
						} else {
							System.out.println("ɾ��ʧ�ܣ�");
						}
					}

				} else {
					System.out.println("ѧ��ѧ�Ų����ڣ���");
				}
				System.out.println("�Ƿ��˳�ɾ�����ܣ������������n����N�˳�");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * ���ܣ��޸�ѧ����Ϣ
	 */
	public void modifyStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("��������Ҫ�޸ĵ�ѧ��ѧ��");
				String num = sc.next();
				Student stu = student.findStudent(num);
				if (stu != null) {
					System.out.println("ѧ��\t����\t�Ա�\t����\tרҵ\t\t�༶\t���֤����\t\t\t��ҵ����\tѡ�ογ�");
					System.out.println(stu);
					System.out.println("\n\n");
					System.out.println("1:  �޸�����");
					System.out.println("2:  �޸��ձ�");
					System.out.println("3�����޸�����");
					System.out.println("4:  �޸����֤����");

					System.out.println("�����ѡ��");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("����������");
						stu.setName(sc.next());
						break;
					case 2:
						System.out.println("�������ձ�");
						stu.setSex(sc.next());
						break;
					case 3:
						System.out.println("����������");
						stu.setAge(sc.nextInt());
						break;

					case 4:
						System.out.println("���������֤����");
						stu.setStuId(sc.next());
						break;

					default:
						break;
					}

				} else {
					System.out.println("ѧ��ѧ�Ų����ڣ���");
				}
				if (student.modifyStudent(stu)) {
					System.out.println("�޸ĳɹ���");
				} else {
					System.out.println("�޸�ʧ�ܣ�");
				}

				System.out.println("����n����Nֹͣ�޸ģ����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	
	/*
	 * ���ܣ���ѯѧ����Ϣ
	 */
	public void findStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("�������� 1������ѧ�Ų�ѯ  2�� ����������ѯ");
				int key = sc.nextInt();
				System.out.println("������ؼ���");
				String keyname = sc.next();
				List<Student> sList = student.findStudent(key, keyname);
				if (sList != null) {
					System.out.println("ѧ��\t����\t�Ա�\t����\t���֤����\t\t\t��ҵ����\t\tѡ�ογ�\tϵ��");
					for (int i = 0; i < sList.size(); i++) {
						System.out.println(sList.get(i));
					}

				} else {
					System.out.println("ѧ��ѧ�Ų����ڣ���");
				}

				System.out.println("����n����Nֹͣ�޸ģ����������");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * ���ܣ��鿴����ѧ����Ϣ ������num ѧ��
	 */

	public void findStudent(String num) throws Exception {
		try {

			Student stu = student.findStudent(num);
			if (stu != null) {
				System.out.println("ѧ��\t����\t�Ա�\t����\t���֤����\t\t��ҵ����\tϵ��");

				System.out.println(stu);
			} else {
				System.out.println("ѧ��ѧ�Ų����ڣ���");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	
}
