/**
 * 
 */
package com.edu.dao;

import java.util.List;

import com.edu.dto.Student;

/**
 * @author Administrator
 *
 */
public interface IStudent {

	/*
	 * ����Ա���ѧ����Ϣ��boolean���ж��Ƿ����
	 */
	public boolean addStudent(Student s) throws Exception;

	/*
	 * ����Աɾ��ѧ����Ϣ��boolean���ж��Ƿ�ɾ��
	 */
	public boolean deleteStudent(String num) throws Exception;

	/*
	 * ����Ա �޸�ѧ����Ϣ��boolean���ж��Ƿ��޸�ѧ����Ϣ
	 */
	public boolean modifyStudent(Student s) throws Exception;

	/*
	 * ��ʾѧ���б� <list����>
	 * 
	 */

	public List<Student> lispStudent() throws Exception;

	/*
	 * ����ѧ�� Student
	 */

	public Student findStudent(String num) throws Exception;

	/*
	 * ��¼���ܣ���Ҫ����ѧ�ź�����
	 */
	public Student loginStudent(String stuNum, String stuPassword) throws Exception;

	



	/*
	 * ���ݹؼ��ֲ�ѯ
	 * ģ����ѯ
	 */
	public List<Student> findStudent(int key,String keyname) throws Exception;


}
