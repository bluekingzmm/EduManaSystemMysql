package com.edu.dao;

import java.util.List;

import com.edu.dto.AdminUser;
import com.edu.dto.Course;
import com.edu.dto.StuScore;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

public interface IAdmin {


	/*
	 * ����Ա��¼
	 */
	public AdminUser loginAdmin(String username,String userpassword ) throws Exception;

	/*
	 * ��ȡ����
	 */
	public Student getPassword(String stu_password) throws Exception;

	/*
	 * �޸ĸ�����Ϣ
	 */

	public boolean modifyOwnStudent(Student s) throws Exception;

	/*
	 * ����ѧ����Ų�ѯ
	 */
	public List<StuScore> findByStudent(String num) throws Exception;
	
	
	
	public Course findTeacherByCode(String tea_id) throws Exception ;

	/*
	 * �鿴����ѧ����Ϣ
	 * ��ͼ
	 */
	public List<StuScore> LispStudentInfo(String code) throws Exception;
	
	/*
	 *�鿴����ѧ���ɼ�
	 *��ͼ 
	 */

	public List<StuScore> LispStudentScore(String code) throws Exception;
	
	/*
	 * �õ���ʦ����
	 */

	public Teacher getTeaPassword(String password) throws Exception;
	
	/*
	 * �޸ĸ�����Ϣ
	 */

	public boolean modifyOneTeacher(Teacher tea) throws Exception;
	

}
