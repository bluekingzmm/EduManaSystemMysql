/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.IAdmin;
import com.edu.dao.IStudent;
import com.edu.dao.ITeacher;
import com.edu.dao.impl.AdminMysqlImpl;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dao.impl.TeacherImplMysql;
import com.edu.dto.AdminUser;
import com.edu.dto.StuScore;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

/**
 * @author ������
 * ���ܣ�����Ա��½���޸�ѧ��������Ϣ���õ�ѧ�����룬
 * ��ѯѧ�����˳ɼ���ͨ����ʦ��Ų�ѯ��ʦ��ţ�
 * ��ʾ����ѧ���ɼ�����ʾ����ѧ����Ϣ
 * �õ���ʦ��ţ��޸Ľ�ʦ������Ϣ
 * 
 */
public class AdminAssit {

	static Scanner sc = new Scanner(System.in);
	static IAdmin a = new AdminMysqlImpl();
	static IStudent student = new StudentImplMysql();
	static ITeacher teacher =new TeacherImplMysql();

	
	/*
	 * ���ܣ�����Ա��¼��Ϣ
	 */

	public boolean loginAdmin() throws Exception {
		try {

			System.out.println("���������Ա�û���");
			String username = sc.next();
			System.out.println("����������");
			String userpassword = sc.next();
			AdminUser adm = a.loginAdmin(username, userpassword);
			if (adm != null) {
				System.out.println("��¼�ɹ���");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}
	
	/*
	 * ���ܣ��޸�ѧ��������Ϣ ������num ѧ��
	 */

	public void modifyStudent(String num) throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {

				Student stu = student.findStudent(num);
				if (stu != null) {
					System.out.println("ѧ��\t����\t�Ա�\t����\tרҵ\t\t�༶\t���֤����\t\t\t��ҵ����\tѡ�ογ�");
					System.out.println(stu);
					System.out.println("\n\n");
					System.out.println("1:  �޸�����");
					System.out.println("2�����޸�����");
					System.out.println("3:  �޸����֤����");
					System.out.println("�����ѡ��");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("����������");
						stu.setName(sc.next());
						break;

					case 2:
						System.out.println("����������");
						stu.setAge(sc.nextInt());
						break;

					case 3:
						System.out.println("���������֤����");
						stu.setStuId(sc.next());
						break;

					default:
						break;
					}

				} else {
					System.out.println("ѧ��ѧ�Ų����ڣ���");
				}
				if (a.modifyOwnStudent(stu)) {
					System.out.println("�޸ĳɹ���");
					System.out.println("ѧ��\t����\t�Ա�\t����\tרҵ\t\t�༶\t���֤����\t\t\t��ҵ����");
					System.out.println(stu);
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
	 * ���ܣ��޸ĸ������� ��ʼ����000
	 */
	public void changePassword() throws Exception {
		try {
			System.out.println("���������ԭ������");
			String password = sc.next();
			Student stu = a.getPassword(password);
			if (stu != null) {
				System.out.println("ԭ���룺" + password);
				System.out.println("������������");
				String newpassword = sc.next();
				if (password.equals(newpassword)) {
					System.out.println("���ܺ�ԭ����������ͬ");
					return;
				}
				System.out.println("����һ���������룬����ȷ��");

				String arginpassword = sc.next();
				if (newpassword.equals(arginpassword)) {
					stu.setStuPassword(arginpassword);
					if (student.modifyStudent(stu)) {
						System.out.println("�����޸ĳɹ���");
					} else {
						System.out.println("�޸�ʧ�ܣ���");
					}
				} else {
					System.out.println("��������Ĳ�ͬ����");
				}
			} else {
				System.out.println("���벻����");
				System.out.println(stu);
			}
		} catch (Exception sql) {
			// TODO: handle exception
		}

	}

	/*
	 * ���ܣ��鿴���˳ɼ� ������num ѧ�� ��ͼ��VScore1
	 */
	public void findOneScore(String num) throws Exception {
		try {
			List<StuScore> v = a.findByStudent(num);
			if (v != null) {
				System.out.println("�γ̱��\tѧ��ѧ��\tѧ������\t��ʦ���\t�ɼ�\t�γ���\t��ʦ��");
				for (int i = 0; i < v.size(); i++) {
					System.out.println(v.get(i) + "\t" + v.get(i).getCourse().getCourse_name() + "\t"
							+ v.get(i).getTea().getName());
				}
			} else {
				System.out.println("������ѧ�����");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	/*
	 * ���ܣ��޸Ľ�ʦ���� ��ҪѰ�ҽ�ʦ���룬���Ƿ���ڲ����޸ģ�Ĭ������000
	 */
	public void changeTeaPassword() throws Exception {
		try {
			System.out.println("���������ԭ������");
			String password = sc.next();
			Teacher tea = a.getTeaPassword(password);
			if (tea != null) {
				System.out.println("ԭ���룺" + password);
				System.out.println("������������");
				String newpassword = sc.next();
				if (password.equals(newpassword)) {
					System.out.println("���ܺ�ԭ����������ͬ");
					return;
				}
				System.out.println("����һ���������룬����ȷ��");

				String arginpassword = sc.next();
				if (newpassword.equals(arginpassword)) {
					tea.setTea_password(arginpassword);
					if (teacher.modifyTeacher(tea)) {
						System.out.println("�����޸ĳɹ���");
					} else {
						System.out.println("�޸�ʧ�ܣ���");
					}
				} else {
					System.out.println("��������Ĳ�ͬ����");
				}
			} else {
				System.out.println("���벻����");

			}
		} catch (Exception sql) {
			// TODO: handle exception
		}

	}
	/*
	 * ���ܣ��޸Ľ�ʦ������Ϣ ������code ��ʦ���
	 */
	public void modifyTeacher(String code) throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {

				Teacher tea = teacher.findTeacher(code);
				if (tea != null) {
					System.out.println("��ʦ���\t��ʦ����\t�Ա�\t����\t���ڿογ̱��\t�绰����\t����\t�ȼ�");
					System.out.println(tea);
					System.out.println("1���������ʦ����");
					System.out.println("2���������ʦ�Ա�");
					System.out.println("3���������ʦ����");
					System.out.println("4��������绰���� ");
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
						System.out.println("5��������绰����");
						tea.setTea_tel(sc.next());
						break;

					default:
						break;
					}
					if (a.modifyOneTeacher(tea)) {
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
	 * ���ܣ���ʾ����ѧ����Ϣ ���� code ��ʦ��� ��ͼ��VScore
	 */

	public void dispStudentInfo(String code) throws Exception {
		try {
			a.LispStudentInfo(code);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * ���ܣ��鿴����ѧ���ɼ� ������code ��ͼ��VScore1
	 */
	public void dispStudentScore(String code) throws Exception {
		try {
			a.LispStudentScore(code);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	/*
	 * ���ܣ���ʾ��ʦ������Ϣ ������code ��ʦ���
	 */
	public void findOneTeacher(String code) throws Exception {
		try {

			Teacher tea = teacher.findTeacher(code);
			if (tea != null) {
				System.out.println("��ʦ���\t��ʦ����\t�Ա�\t����\t���ڿογ̱��\t�绰����\t����\t�ȼ�");
				System.out.println(tea);
			} else {
				System.out.println("��ʦ��Ų����ڣ�");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}



}
