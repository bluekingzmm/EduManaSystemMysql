/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.ICourse;
import com.edu.dao.IScourse;
import com.edu.dao.IStudent;
import com.edu.dao.impl.CourseImplMysql;
import com.edu.dao.impl.ScourseImplMysql;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dto.Course;
import com.edu.dto.Scoursse;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

/**
 * @author ������
 * ���ܣ���ʾ����ѡ�ε�ѧ��������ѧ��ѧ�Ų�ѯ����ѡ�����
 * ¼�룬�޸�ѡ����Ϣ��ͨ����ʦ��Ų�ѯ�γ���Ϣ
 *
 */
public class ScourseAiist {

	static Scanner sc = new Scanner(System.in);
	static IScourse is = new ScourseImplMysql();
	static IStudent ss = new StudentImplMysql();
	static ICourse ic = new CourseImplMysql();
	
	/*
	 * ���ܣ�ѧ��ѡ��
	 * ������num ѧ��ѧ��
	 */

	public void addScourse(String num) throws Exception {
		try {

			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Student stu = ss.findStudent(num);
				if (stu != null) {
					System.out.println("����������Ҫѡ�εĿγ̱��");
					String code=sc.next();
					Course course=ic.findByCode(code);
					if(course==null){
						System.out.println("�γ̺Ų�����");
					}
					stu.setCourse_id(code);	
					stu.setTea_id(stu.getTea_id());
				} else {
					System.out.println("ѧ�Ų����ڣ�");
				}
				if (is.modifyScourse(stu)) {
					System.out.println("ѡ�γɹ�");
				} else {
					System.out.println("ѡ��ʧ��");
			

				

			
				}
				System.out.println("����n����N��ֹͣ�޸Ļ������");
				yes = sc.next();
				}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * ���ܣ���ʾ����ѧ��ѡ����Ϣ
	 * 
	 */

	public void dispScourse() throws Exception {
		List<Scoursse> sList = is.dispAllScourse();
		System.out.println("ѧ��ѧ��\tѧ������\t�γ̱��\t�γ���\t�ص�\tʱ��\t����");
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}

		
	}
	/*
	 * ���ܣ���ѯѧ������ѡ�����
	 * ������num ѧ��ѧ��
	 */

	public void dispOneScourse(String num)throws Exception{
		Scoursse sc=is.dispAllScourse(num);
		if(sc!=null){
			System.out.println("ѧ��ѧ��\tѧ������\t�γ̱��\t�γ���\t�ص�\tʱ��\t����");
		System.out.println(sc);
		}else{
			System.out.println("�ޣ�");
		}
		
		
		
	}
	/*
	 * ���ܣ���ѯ���ſγ̽�ʦ
	 * 
	 */

	public void selectBytea() throws Exception {
		try {
			String yes = "y";
			while (!yes.startsWith("n")) {
				System.out.println("������γ̱��");
				String course_id = sc.next();
				System.out.println("��ʦ����\t��ʦ���");
				Course course = ic.findByCode(course_id);
				if (course != null) {
					Teacher tea = is.findScourseBytea(course_id);
					System.out.println(tea.getName() + "\t" + tea.getNum());

				}
				System.out.println("����n����N��ֹͣ��ѯ�����������");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
