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
 * @author ����
 * ���ܣ�¼�룬ɾ�����޸ģ���ѯ����ʾ�γ���Ϣ
 *
 */
public class CourseImplMysql extends DataBase implements ICourse {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ICourse#teaAddCourse(com.edu.dto.Course) ���ܣ���ӿγ� ������
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
	 * @see com.edu.dao.ICourse#DelectCourse(java.lang.String) ���ܣ�ɾ���γ� ����:�γ̱��
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
	 * @see com.edu.dao.ICourse#ModifyCourse(com.edu.dto.Course) ����:�޸Ŀγ���Ϣ ����
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
	 * @see com.edu.dao.ICourse#findByCode(java.lang.String) ���ܣ���ѯ�γ���Ϣ �������γ̱��
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
	 * @see com.edu.dao.ICourse#dispListCourse(com.edu.dto.Course) ���ܣ���ʾ���пγ���Ϣ
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
	// System.out.println("�γ̱��\t�γ���\t�Ͽεص�\t��ʱ\tѧ������");
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
	 * @see com.edu.dao.ICourse#dispListCourse() ���ܣ���ʾ���пγ���Ϣ
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
