/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.ICourse;
import com.edu.dao.impl.CourseImplMysql;
import com.edu.db.DataBase;
import com.edu.dto.Course;

/**
 * @author ����
 * ���ܣ�¼�룬ɾ�����޸ģ���ѯ����ʾ�γ���Ϣ
 *
 */
public class CourseAiist extends DataBase {

	Scanner sc = new Scanner(System.in);
	ICourse course = new CourseImplMysql();

	/*
	 * ���ӿγ���Ϣ ������¼�����
	 */
	public void AddCourse() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Course c = new Course();
				System.out.println("������γ̱��");
				c.setCourse_id(sc.next());
				System.out.println("������γ�����");
				c.setCourse_name(sc.next());
				System.out.println("�������Ͽεص�");
				c.setPlace(sc.next());
				System.out.println("������ʱ�䣨��ʱ��");
				c.setTime(sc.next() + "��ʱ");
				System.out.println("������ѧ������");
				c.setStucount(sc.nextInt());
				if (course.AddCourse(c)) {
					System.out.println("¼��ɹ�����");
//					course.dispListCourse(c);
				} else {
					System.out.println("¼��ʧ�ܣ�����");
				}
				System.out.println("����n����N���˳�¼�룬���������!");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}

	}

	/*
	 * ���ܣ����ݿγ̱��ɾ���γ� ������ɾ�����
	 */

	public void DelectCourse() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱��");
				String code = sc.next();
				Course c = course.findByCode(code);
				// course.dispListCourse(c);
				System.out.println("�γ̱��\t�γ���\t�Ͽεص�\t��ʱ\tѧ������");
				System.out.println(c);
				if (course.DelectCourse(code)) {
					System.out.println("ɾ���ɹ�");
				} else {
					System.out.println("ɾ��ʧ�ܣ�");
				}
				System.out.println("����n����N���˳�¼�룬���������!");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}

	}

	/*
	 * ���ܣ���ʾ���еĿγ���Ϣ������dispListCourse ��for�������������ѯ������
	 */
	public List<Course> dispAllCourse() throws Exception {
		System.out.println("�γ̱��\t�γ���\t�Ͽεص�\t��ʱ\tѧ������");
		List<Course> sList = course.dispListCourse();
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
		return sList;
	}
	/*
	 * ���ܣ��޸Ŀγ̣��γ̱�ţ� ��ʾ�޸ĵ����
	 */

	public void ModifyCourse() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱��");
				String code = sc.next();
				Course c = course.findByCode(code);
				// course.dispListCourse(c);
				System.out.println("�γ̱��\t�γ���\t�Ͽεص�\t��ʱ\tѧ������");
				System.out.println(c);
				if (c != null) {
					System.out.println("1�����޸Ŀγ�����");
					System.out.println("2�����޸��Ͽεص�");
					System.out.println("3���������ʱ");
					System.out.println("4��������ѧ������");
					System.out.println("��ѡ��");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("1�����޸Ŀγ�����");
						c.setCourse_name(sc.next());
						break;
					case 2:
						System.out.println("2�����޸��Ͽεص�");
						c.setPlace(sc.next());
						break;
					case 3:
						System.out.println("3���������ʱ");
						c.setTime(sc.next()+ "��ʱ");
						break;
					case 4:
						System.out.println("4��������ѧ������");
						c.setStucount(sc.nextInt());
						break;

					default:
						break;
					}

				} else {
					System.out.println("û�пγ̱��Ϊ" + code + "�Ŀγ�");
				}
				if (course.ModifyCourse(c)) {
					System.out.println("�޸ĳɹ���");
					// course.dispListCourse(c);
				} else {
					System.out.println("�޸�ʧ�ܣ�");
				}
				System.out.println("����n����N�˳��޸ģ������������");
				yes = sc.next();

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}

	}

	/*
	 * ���ܣ����ݿγ̱�Ž��в�ѯ
	 */

	public void findByCode() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱��");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (c != null) {
					System.out.println("�γ̱��\t�γ���\t�Ͽεص�\t��ʱ\tѧ������");
					System.out.println(c);
				} else {
					System.out.println("û�б��Ϊ" + code + "�Ŀγ̣���");
				}
				System.out.println("����n����N���˳����ң����������!");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵��;");
			e.printStackTrace();
		}

	}

}
