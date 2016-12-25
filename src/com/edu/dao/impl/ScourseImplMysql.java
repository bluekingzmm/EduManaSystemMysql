/**
 * 
 */
package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.IScourse;
import com.edu.db.DataBase;
import com.edu.dto.Scoursse;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

/**
 * @author 张明明
 * 功能：显示所有选课的学生，根据学生学号查询个人选课情况
 * 录入，修改选课信息，通过教师编号查询课程信息
 *
 */
public class ScourseImplMysql extends DataBase implements IScourse {

	/*
	 * (non-Javadoc)
	 * 功能:显示所有的选过课的学生信息
	 * @see com.edu.dao.IScourse#dispAllScourse()
	 */
	@Override
	public List<Scoursse> dispAllScourse() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Scoursse> sList = null;
		Scoursse sc = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vcourse");
			rs = ps.executeQuery();
			sList = new ArrayList<Scoursse>();
			while (rs.next()) {
				sc = new Scoursse();
				sc.setCourse_id(rs.getString("course_id"));
				sc.setCourse_name(rs.getString("course_name"));
				sc.setStuName(rs.getString("stuName"));
				sc.setStuNum(rs.getString("stuNum"));
				sc.setPlace(rs.getString("place"));
				sc.setStucount(rs.getInt("stucount"));
				sc.setTime(rs.getString("time"));
				sList.add(sc);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(rs, ps, con);
		return sList;
	}
	
	/*
	 * 功能：根据学生学号查询个人选课情况
	 * 参数： num 学生学号
	 * (non-Javadoc)
	 * @see com.edu.dao.IScourse#dispAllScourse(java.lang.String)
	 */
	public Scoursse dispAllScourse(String num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scoursse sc = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vcourse where stuNum=?");
			ps.setString(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				sc = new Scoursse();
				sc.setCourse_id(rs.getString("course_id"));
				sc.setCourse_name(rs.getString("course_name"));
				sc.setStuName(rs.getString("stuName"));
				sc.setStuNum(rs.getString("stuNum"));
				sc.setPlace(rs.getString("place"));
				sc.setStucount(rs.getInt("stucount"));
				sc.setTime(rs.getString("time"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(rs, ps, con);
		return sc;
	}

	/*
	 * (non-Javadoc)
	 * 功能:进行选课或者修改自己的选课
	 * @see com.edu.dao.IScourse#modifyScourse(com.edu.dto.Student)
	 */
	@Override
	public boolean modifyScourse(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("update student set course_id=? where stuNum=?");
			ps.setString(1, s.getCourse_id());
//			ps.setString(2, s.getTea_id());
			ps.setString(2, s.getNum());
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(ps, con);
		return false;
	}

	

	/*
	 * (non-Javadoc)
	 * 功能：根据教师编号查询代课老师
	 * 参数： course 课程编号
	 * @see com.edu.dao.IScourse#findScourseBytea(java.lang.String)
	 */
	@Override
	public Teacher findScourseBytea(String course) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher tea = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select tea_name,tea_id from teacher where course_id=? ");
			ps.setString(1, course);
			rs = ps.executeQuery();
			while (rs.next()) {
				tea = new Teacher();
				tea.setName(rs.getString("tea_name"));
				tea.setNum(rs.getString("tea_id"));
				tea.setCourse_id(rs.getString("course_id"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		AdminMysqlImpl.free(ps, con);
		return tea;
	}

}
