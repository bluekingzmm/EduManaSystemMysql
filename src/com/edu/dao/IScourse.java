package com.edu.dao;

import java.util.List;

import com.edu.dto.Scoursse;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

public interface IScourse {

	public List<Scoursse> dispAllScourse() throws Exception;

	public boolean modifyScourse(Student s) throws Exception;

	public Teacher findScourseBytea(String course) throws Exception;

	public Scoursse dispAllScourse(String num) throws Exception;
}
