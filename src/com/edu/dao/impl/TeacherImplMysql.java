/**
 * 
 */
package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.ITeacher;
import com.edu.db.DataBase;
import com.edu.dto.Teacher;

/**
 * @author 汪潭
 *  功能：增加，删除，修改，查询，显示，排序，教师登录
 *
 */
public class TeacherImplMysql extends DataBase implements ITeacher {

	/*
	 * (non-Javadoc) 功能：增加教师
	 * 
	 * @see com.edu.dao.ITeacher#addTeacher(com.edu.dto.Teacher)
	 */
	@Override
	public boolean addTeacher(Teacher tea) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement(
					"insert into teacher(tea_id,tea_name,sex,age,course_id,tea_tel,memo) values(?,?,?,?,?,?,?) ");
			ps.setString(1, tea.getNum());
			ps.setString(2, tea.getName());
			ps.setString(3, tea.getSex());
			ps.setInt(4, tea.getAge());
			ps.setString(5, tea.getCourse_id());
			ps.setString(6, tea.getTea_tel());
			ps.setString(7, tea.getMemo());
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
	 * (non-Javadoc) 功能：删除教师
	 * 
	 * @see com.edu.dao.ITeacher#deleteTeacher(java.lang.String)
	 */
	@Override
	public boolean deleteTeacher(String code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = getConn();
			ps = con.prepareStatement("delete from teacher where tea_id=?");
			ps.setString(1, code);
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
	 * (non-Javadoc) 功能：修改教师
	 * 
	 * @see com.edu.dao.ITeacher#modifyTeacher(com.edu.dto.Teacher)
	 */
	@Override
	public boolean modifyTeacher(Teacher tea) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement(
					"update teacher set tea_name=?,sex=?,age=?,course_id=?,tea_tel=?,tea_password=? where tea_id=?");

			ps.setString(1, tea.getName());
			ps.setString(2, tea.getSex());
			ps.setInt(3, tea.getAge());
			ps.setString(4, tea.getCourse_id());
			ps.setString(5, tea.getTea_tel());
			ps.setString(6, tea.getTea_password());
			ps.setString(7, tea.getNum());
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
	 * (non-Javadoc) 功能：查询教师 参数：code 教师编号
	 * 
	 * @see com.edu.dao.ITeacher#findTeacher(java.lang.String)
	 */
	@Override
	public Teacher findTeacher(String code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher tea = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from teacher where tea_id=?");
			ps.setString(1, code);
			rs = ps.executeQuery();
			while (rs.next()) {
				tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				tea.setSex(rs.getString("sex"));
				tea.setAge(rs.getInt("age"));
				tea.setCourse_id(rs.getString("course_id"));
				tea.setTea_tel(rs.getString("tea_tel"));
				tea.setMemo(rs.getString("memo"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		AdminMysqlImpl.free(rs, ps, con);
		return tea;
	}

	/*
	 * (non-Javadoc) 功能：显示全部教师信息
	 * 
	 * @see com.edu.dao.ITeacher#dispAllTeacher()
	 */
	@Override
	public List<Teacher> dispAllTeacher() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		Teacher tea = null;
		ResultSet rs = null;
		List<Teacher> sList = null;
		try {
			sList = new ArrayList<Teacher>();
			con = getConn();
			ps = con.prepareStatement("select * from teacher ");
			rs = ps.executeQuery();
			while (rs.next()) {
				tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				tea.setSex(rs.getString("sex"));
				tea.setAge(rs.getInt("age"));
				tea.setCourse_id(rs.getString("course_id"));
				tea.setTea_tel(rs.getString("tea_tel"));
				tea.setMemo(rs.getString("memo"));
				sList.add(tea);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(rs, ps, con);

		return sList;
	}

	/*
	 * 功能：排序教师 按照工资排序 (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#sortTeacher()
	 */
	public List<Teacher> sortTeacher() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> sList = null;
		Teacher tea = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from teacher ORDER BY memo ");
			rs = ps.executeQuery();
			sList = new ArrayList<Teacher>();
			while (rs.next()) {
				tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				tea.setSex(rs.getString("sex"));
				tea.setAge(rs.getInt("age"));
				tea.setCourse_id(rs.getString("course_id"));
				tea.setTea_tel(rs.getString("tea_tel"));
				tea.setMemo(rs.getString("memo"));
				sList.add(tea);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(rs, ps, con);

		return sList;
	}

	/*
	 * 功能：教师登录 (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#loginTeacher(java.lang.String,
	 * java.lang.String)
	 */

	public Teacher loginTeacher(String code, String teaPassword) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher tea = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from teacher where tea_id=? and tea_password=?");
			ps.setString(1, code);
			ps.setString(2, teaPassword);
			rs = ps.executeQuery();
			if (rs.next()) {
				tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				tea.setSex(rs.getString("sex"));
				tea.setAge(rs.getInt("age"));
				tea.setCourse_id(rs.getString("course_id"));
				tea.setTea_tel(rs.getString("tea_tel"));
				// tea.setTea_password(rs.getString("tea_password"));
				// tea.setMemo(rs.getString("memo"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(rs, ps, con);
		return tea;

	}

	
	
}
