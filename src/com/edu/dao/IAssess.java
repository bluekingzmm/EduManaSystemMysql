package com.edu.dao;

import java.util.List;

import com.edu.dto.Teacher;

public interface IAssess {

	

	
	public boolean deleteAssess(String code) throws Exception;
	
	public boolean modify(Teacher t) throws Exception;
	
	public Teacher findAssess(String code) throws Exception;
	
	public List<Teacher> lispAllAssess() throws Exception;
	
	public Teacher findTeacherMeno(String tea_id) throws Exception;

}
