/**
 * 
 */
package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.ICourse;
import com.edu.db.DataBase;
import com.edu.dto.Course;

/**
 * @author 王浩
 * 功能：录入，删除，修改，查询，显示课程信息
 *
 */
public class CourseImplMysql extends DataBase implements ICourse {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ICourse#teaAddCourse(com.edu.dto.Course) 功能：添加课程 参数：
	 * Course c
	 */
	@Override
	public boolean AddCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(
					"insert into course(course_id,course_name,place,time,stucount) values (?,?,?,?,?)");
			ps.setString(1, c.getCourse_id());
			ps.setString(2, c.getCourse_name());
			ps.setString(3, c.getPlace());
			ps.setString(4, c.getTime());
			ps.setInt(5, c.getStucount());
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

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ICourse#DelectCourse(java.lang.String) 功能：删除课程 参数:课程编号
	 * code
	 */
	public boolean DelectCourse(String code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("delete from course where course_id=?");
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

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ICourse#ModifyCourse(com.edu.dto.Course) 功能:修改课程信息 参数
	 * Course c
	 */
	public boolean ModifyCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("update  course set course_name=?,place=?,time=?,stucount=? where course_id=?");
			ps.setString(1, c.getCourse_name());

			ps.setString(2, c.getPlace());
			ps.setString(3, c.getTime());
			ps.setInt(4, c.getStucount());
			ps.setString(5, c.getCourse_id());
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

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ICourse#findByCode(java.lang.String) 功能：查询课程信息 参数：课程编号
	 * code
	 */
	public Course findByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		try {
			ps = con.prepareStatement("select * from  course  where course_id=?");
			ps.setString(1, code);
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				c.setPlace(rs.getString("place"));
				c.setStucount(rs.getInt("stucount"));
				c.setTime(rs.getString("time"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(ps, con);
		return c;
	}

	@Override

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ICourse#dispListCourse(com.edu.dto.Course) 功能：显示所有课程信息
	 * 
	 */
	// public List<Course> dispListCourse(Course s) throws Exception {
	// // TODO Auto-generated method stub
	// Connection con = getConn();
	// PreparedStatement ps = null;
	// ResultSet rs = null;
	// Course c = null;
	// List<Course> cList = null;
	// try {
	// ps = con.prepareStatement("select * from course where course_id=?");
	// ps.setString(1, s.getCourse_id());
	// rs = ps.executeQuery();
	// cList = new ArrayList<Course>();
	// System.out.println("课程编号\t课程名\t上课地点\t课时\t学生人数");
	// while (rs.next()) {
	// c = new Course();
	// c.setCourse_id(rs.getString("course_id"));
	// c.setCourse_name(rs.getString("course_name"));
	// c.setPlace(rs.getString("place"));
	// c.setStucount(rs.getInt("stucount"));
	// c.setTime(rs.getString("time"));
	// cList.add(c);
	// System.out.println(c);
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// StudentImplMysql.free(ps, con);
	// return cList;
	//
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ICourse#dispListCourse() 功能：显示所有课程信息
	 */
	public List<Course> dispListCourse() throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		List<Course> cList = null;
		try {
			ps = con.prepareStatement("select * from  course ");

			rs = ps.executeQuery();
			cList = new ArrayList<Course>();

			while (rs.next()) {
				c = new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				c.setPlace(rs.getString("place"));
				c.setStucount(rs.getInt("stucount"));
				c.setTime(rs.getString("time"));
				cList.add(c);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(ps, con);

		return cList;
	}
	

}
