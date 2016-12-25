/**
 * 
 */
package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.IAssess;
import com.edu.db.DataBase;
import com.edu.dto.Teacher;

/**
 * @author 张明明 
 * 功能：删除评价信息，录入修改教师评价，查询教师评价，显示所有评价,显示个人评价
 *
 */
public class AssessImplMysql extends DataBase implements IAssess {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IAssess#deleteAssess(java.lang.String) 功能： 删除教师评价 参数
	 * code 教师编号
	 */
	public boolean deleteAssess(String code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("update teacher set memo=null,assess=null where tea_id=?");
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
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IAssess#modify(com.edu.dto.Teacher) 功能：添加教师的评价和寄语 参数
	 * Teacher t
	 */
	@Override
	public boolean modify(Teacher t) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("update teacher set memo=?,assess=? where tea_id=?");
			ps.setString(1, t.getMemo());
			ps.setString(2, t.getWrite());
			ps.setString(3, t.getNum());
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
	 * 
	 * @see com.edu.dao.IAssess#findAssess(java.lang.String) 功能：查询教师评价 参数：code
	 * 教师编号
	 */
	@Override

	public Teacher findAssess(String code) throws Exception {
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
				tea.setWrite(rs.getString("write"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		AdminMysqlImpl.free(rs, ps, con);
		return tea;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IAssess#lispAllAssess() 功能：显示所有评价过的教师信息
	 */
	@Override
	public List<Teacher> lispAllAssess() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> sList = null;
		Teacher tea = null;
		try {
			sList = new ArrayList<Teacher>();
			con = getConn();
			ps = con.prepareStatement("select tea_name,tea_id,memo,assess from teacher ");
			rs = ps.executeQuery();
			while (rs.next()) {
				tea = new Teacher();
				tea.setName(rs.getString("tea_name"));
				tea.setNum(rs.getString("tea_id"));
				tea.setMemo(rs.getString("memo"));
				tea.setWrite(rs.getString("assess"));
				sList.add(tea);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		AdminMysqlImpl.free(rs, ps, con);
		return sList;
	}

	public Teacher findTeacherMeno(String tea_id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher tea = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select memo,assess from teacher where tea_id=? ");
			ps.setString(1, tea_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				tea = new Teacher();
				tea.setMemo(rs.getString("memo"));
				tea.setWrite(rs.getString("assess"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return tea;
	}

}
