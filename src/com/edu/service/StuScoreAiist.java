/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.IAdmin;
import com.edu.dao.ICourse;
import com.edu.dao.IScore;
import com.edu.dao.IStudent;
import com.edu.dao.ITeacher;
import com.edu.dao.impl.AdminMysqlImpl;
import com.edu.dao.impl.CourseImplMysql;
import com.edu.dao.impl.ScoreImplMysql;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dao.impl.TeacherImplMysql;
import com.edu.dto.Course;
import com.edu.dto.StuScore;
import com.edu.dto.Student;

/**
 * @author ������
 * ���ܣ� ��ӣ�ɾ�����޸ģ���ʾ�ɼ�������ѧ�����ɾ���ɼ������տγ̱��ɾ���ɼ���
 * ����ѧ����Ų�ѯ�ɼ������տγ̱�Ų�ѯ�ɼ���get�õ�ѧ���Ϳγ̣�
 * ���տγ̱�Ų鿴���γ̳ɼ����ֺܷ�ƽ���֣����շ�������Ŀγ̱��
 *
 */
public class StuScoreAiist {
	static Scanner sc = new Scanner(System.in);
	IStudent student = new StudentImplMysql();
	ITeacher teacher =new TeacherImplMysql();
	ICourse course = new CourseImplMysql();
	IScore score = new ScoreImplMysql();
	IAdmin admin=new AdminMysqlImpl();

	
	/*
	 * ���ܣ����տγ̱�Ų鿴���γ̳ɼ����ֺܷ�ƽ����
	 */
	public void findCourseScoreLookExam() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱�ţ�");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (c == null) {
					System.out.println("û��Ϊ��" + code + "�Ŀγ̣���");
					return;
				}

				List<StuScore> sList = score.findByCourse(c);
				StuScore ss = score.findByCourseLookExam(c);
				double total = 0;
				for (int j = 0; j < sList.size(); j++) {
					if (ss != null) {
						StuScore e = sList.get(j);
						total += e.getScore();
					} else {
						System.out.println("��");
					}
				}

				System.out.println("�γ̺ţ�\t" + ss.getCourse().getCourse_id() + "\t�γ���:\t" + ss.getCourse().getCourse_name() + "\t�ܷ�\t" + total
						+ "\tƽ����\t" + total / sList.size());

				System.out.println("����n����N���˳���ѯ�����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	/*
	 * ���ܣ����տγ̱�Ž�������
	 */
	public void disp() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("��������Ҫ���շ�������Ŀγ̱��");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (c != null) {
					score.lisp(code);
				} else {
					System.out.println("������Ŀγ̱�Ų����ڣ���");
				}
				System.out.println("��Ҫ���������𣬲���Ҫ������n����N�����������");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
/*
 * ���ܣ�����ѧ���ɼ�
 * ��Ҫ�ҵ���ͬѧѧ�źͿγ̱��
 * ��Ҫ��Ӵ�����ʦ���ɼ�
 */

	public void addStuScore(String tea_id) throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������ѧ��ѧ��");
				String num = sc.next();
				Student stu = student.findStudent(num);
				if (stu == null) {
					System.out.println("ѧ�Ų����ڣ�");
				}
				Course code = admin .findTeacherByCode(tea_id);		
//				Course c = course.findByCode(code);
				if (code == null) {
					System.out.println("�γ̱�Ų����ڣ�");
				}
				System.out.println("������ɼ�");
				double exam = sc.nextDouble();
//				System.out.println("�����������ʦ");
//				String tea_id = sc.next();
				StuScore ss = new StuScore(stu, code, exam, tea_id);
				if (score.addScore(ss)) {
					System.out.println("��ӳɹ���");
				} else {
					System.out.println("���ʧ��");
				}
				System.out.println("����n����N��ֹͣ��ӣ����������");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * ���ܣ�ɾ������
	 * ָ��ɾ����ѧ��ѧ�źͽ�ʦ��ţ�
	 */
	public void deleteScore() throws Exception {
		try {

			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱��");
				String code = sc.next();
				Course c = course.findByCode(code);
				System.out.println("������ѧ��ѧ��");
				String num = sc.next();
				Student s = student.findStudent(num);
				StuScore ss = score.get(s, c);
				if (ss == null) {
					System.out.println("û�пγ̱��Ϊ" + code + "��" + num + "����Ϣ");
					return;
				}
				if (score.delectScore(ss)) {
					System.out.println("ɾ���ɹ���");
				} else {
					System.out.println("ɾ��ʧ�ܣ���");
				}
				System.out.println("����n����N���˳�ɾ�������������");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("�쳣˵����");
			System.out.println(e.toString());
		}
	}

	/*
	 * ���ܣ�����ѧ��ѧ��ɾ���ɼ�
	 */
	public void deleteScoreByStu() throws Exception {
		try {
			String yes = "y";

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������ѧ��ѧ�ţ�");
				String num = sc.next();
				Student s = student.findStudent(num);
				if (s == null) {
					System.out.println("�����ѧ�Ų����ڣ���");
				}
				if (score.delectByStudent(s)) {
					System.out.println("ɾ���ɹ�����");
				} else {
					System.out.println("ɾ��ʧ�ܣ���");
				}

				System.out.println("��`��n����N����ɾ�����������������");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	/*
	 * ���տγ̱��ɾ���γ�
	 */
	public void deleteScoreByCourse() throws Exception {
		try {
			String yes = "y";

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱�ţ�");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (course == null) {
					System.out.println("�����ѧ�Ų����ڣ���");
				}
				if (score.delectByCourse(c)) {
					System.out.println("ɾ���ɹ�����");
				} else {
					System.out.println("ɾ��ʧ�ܣ���");
				}

				System.out.println("����n����N����ɾ�����������������");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	/*
	 * ���ܣ�����ѧ��ѧ�Ų��ҳɼ�
	 * �õ���ͼVScore1
	 */
	public void findScoreByStu() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������ѧ��ѧ�ţ�");
				String num = sc.next();
				Student stu = student.findStudent(num);
				if (stu == null) {
					System.out.println("û��ѧ��Ϊ��" + num + "��ѧ������");
					return;
				}
				List<StuScore> sList = score.findByStudent(stu);

				for (int i = 0; i < sList.size(); i++) {
					StuScore exam = sList.get(i);
					System.out.println("ѧ�ţ�\t" + exam.getStu().getNum() + "\t����:\t" + exam.getStu().getName() + "\t�γ���\t"
							+ exam.getCourse().getCourse_name() + "\t������\t" + exam.getScore());
				}
				System.out.println("����n����N���˳���ѯ�����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	
	/*
	 * ���ܣ���ʾȫ���ɼ�
	 * ����ֺܷ�ƽ����
	 */
	public void ListAllScore() throws Exception {
		try {
			List<Student> sList = student.lispStudent();
			List<Course> cList = course.dispListCourse();
			System.out.println("�γ̱��\tѧ��ѧ��\tѧ������\t��ʦ���\t�ɼ�");
			for (int i = 0; i < sList.size(); i++) {
				Student stu = sList.get(i);

				double total = 0;
				for (int j = 0; j < cList.size(); j++) {
					Course course = cList.get(j);
					StuScore ss = score.get(stu, course);
					if (ss != null) {
						total += ss.getScore();
						System.out.println(ss);
					} else {
						System.out.print("\n");
					}
				}
				System.out.println("�ܷ֣�" + total + "\t" + "ƽ����" + total / cList.size());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * ���ܣ����տγ̱�Ų�ѯ�ɼ�
	 * ��ͼVScore1
	 * 
	 */
	public void findScoreByCourse() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱�ţ�");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (c == null) {
					System.out.println("û��Ϊ��" + code + "�Ŀγ̣���");
					return;
				}
				List<StuScore> sList = score.findByCourse(c);

				for (int i = 0; i < sList.size(); i++) {
					StuScore exam = sList.get(i);
					System.out.println("����\t" + exam.getStu().getName() + "\t" + "�γ̺ţ�\t" + exam.getCourse().getCourse_id() + "\t�γ���:\t"
							+ exam.getCourse().getCourse_name() + "\t������\t" + exam.getScore());
				}
				System.out.println("����n����N���˳���ѯ�����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	/*
	 * ���ܣ��޸ĳɼ�
	 * ��Ҫ����γ̱�ź�ѧ����Ž���ƥ��ɼ��Ƿ���ڣ��ٽ����޸�
	 * �޸ĳɼ��ʹ�����ʦ
	 */
	public void modifyStuScore() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {

				System.out.println("����������ӳɼ��Ŀγ̱��");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (c == null) {
					System.out.println("������Ŀγ̱�Ų����ڣ���");
					return;
				}
				System.out.println("������Ҫ�޸ĵ�ѧ��ѧ��");
				String num = sc.next();
				Student stu = student.findStudent(num);
				if (stu == null) {
					System.out.println("û��ѧ��Ϊ" + num + "��ѧ��");
					return;
				}
				StuScore ss = score.get(stu, c);
				if (ss == null) {
					System.out.println("û��ѧ��Ϊ" + num + "��ѧ����" + code + "�Ŀγ̱�ţ������ԣ�");
					return;
				}
				System.out.println("�����ѡ�� 1���޸ĳɼ� 2�� �޸Ĵ�����ʦ");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("ԭ���ĳɼ�Ϊ" + ss.getScore() + "��");
					System.out.println("�������µĳɼ�");
					ss.setScore(sc.nextDouble());
					break;
				case 2:
					System.out.println("�����������ʦ���");
					ss.setTea_id(sc.next());
					break;
				default:
					break;
				}

				if (score.modifyScore(ss)) {
					System.out.println("�޸ĳɹ���");
				} else {
					System.out.println("�޸�ʧ�ܣ�");
				}
				System.out.println("����n����N���˳�ɾ�������������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
