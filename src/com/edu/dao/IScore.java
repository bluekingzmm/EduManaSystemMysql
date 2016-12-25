package com.edu.dao;

import java.util.List;

import com.edu.dto.Course;
import com.edu.dto.StuScore;
import com.edu.dto.Student;

public interface IScore {

	/*
	 * ��ӳɼ�
	 */

	public boolean addScore(StuScore s) throws Exception;

	/*
	 * ɾ���ɼ�
	 */

	public boolean delectScore(StuScore s) throws Exception;

	/*
	 * ɾ��ѧ�����гɼ�
	 */

	public boolean delectByStudent(Student s) throws Exception;

	/*
	 * ɾ��ĳ�γ����гɼ�
	 */

	public boolean delectByCourse(Course c) throws Exception;

	/*
	 * ͨ��ѧ�����ҳɼ�
	 * ��ͼ
	 */

	public List<StuScore> findByStudent(Student s) throws Exception;

	/*
	 * ͨ���γ̲��ҳɼ�
	 * ��ͼ
	 */

	public List<StuScore> findByCourse(Course c) throws Exception;

	/*
	 * �޸ĳɼ�
	 */

	public boolean modifyScore(StuScore s) throws Exception;
	
	/*
	 * �õ�ѧ��ѧ�źͿγ̱��
	 */

	public StuScore get(Student s, Course c) throws Exception;
	
	/*
	 * ��ʾ����ѧ���ɼ�
	 * ��ͼ
	 */

	public List<StuScore> LispStudentScore() throws Exception;

	/*
	 * ���ݽ�ʦ��Ų鿴�ɼ���ѧ���γ���Ϣ
	 */
	
	public List<StuScore> lisp(String code) throws Exception;

	/*
	 * ���ݿγ̱�Ž��в鿴�ɼ�
	 */
	public StuScore findByCourseLookExam(Course c) throws Exception;

}
