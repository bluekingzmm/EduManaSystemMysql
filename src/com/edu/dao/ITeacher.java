package com.edu.dao;

import java.util.List;

import com.edu.dto.Teacher;

public interface ITeacher {

	/*
	 * ��ӽ�ʦ��Ϣ
	 */
	public boolean addTeacher(Teacher tea) throws Exception;

	/*
	 * ɾ����ʦ��Ϣ ���ݽ�ʦ��Ž���ɾ��
	 */

	public boolean deleteTeacher(String code) throws Exception;

	/*
	 * �޸Ľ�ʦ��Ϣ
	 */

	public boolean modifyTeacher(Teacher tea) throws Exception;

	/*
	 * ���ҽ�ʦ��Ϣ
	 */

	public Teacher findTeacher(String code) throws Exception;

	/*
	 * ��ʾ��ʦ������Ϣ
	 */

	public List<Teacher> dispAllTeacher() throws Exception;

	/*
	 * ͨ�����ʽ�������
	 */
	public List<Teacher> sortTeacher() throws Exception;

	/*
	 * ��ʦ��¼����Ҫ��ʦ��ź����룩
	 */
	public Teacher loginTeacher(String code, String teaPassword) throws Exception;

	
	
	
}
