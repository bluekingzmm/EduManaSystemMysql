/**
 * 
 */
package com.edu.dao;

import java.util.List;

import com.edu.dto.Course;

/**
 * @author Administrator
 *
 */
public interface ICourse {


	/*
	 * ���ӿγ�
	 */
	public boolean AddCourse(Course c) throws Exception;
	
	/*
	 * ɾ���γ�
	 */
	
	public boolean DelectCourse(String code) throws Exception;
	
	/*
	 * �޸Ŀγ�
	 */
	
	
	public boolean ModifyCourse(Course c) throws Exception;
	

	
	/*
	 *���տγ̱�����鿴�γ� 
	 */

	public Course findByCode(String code) throws Exception;
	

	
	
	
//	public List<Course> dispListCourse(Course s) throws Exception ;
	
	/*
	 * ��ʾ���пγ���Ϣ
	 */
	public List<Course> dispListCourse() throws Exception;
	


}
