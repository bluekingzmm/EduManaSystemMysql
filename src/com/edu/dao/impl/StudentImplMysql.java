/**
 * 
 */
package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.IStudent;
import com.edu.db.DataBase;
import com.edu.dto.Student;

/**
 * @author 卢福强 功能：增加，删除，修改，查询，显示学生信息， 学生登录
 *
 */
public class StudentImplMysql extends DataBase implements IStudent {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IStudent#addStudent(com.edu.dto.Student) 功能：添加学生信息
	 */
	@Override
	public boolean addStudent(Student s) throws Exception {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement(
					"insert into student(stuNum,stuName,stuSex,stuAge,stuId,department) values(?,?,?,?,?,?) ");
			ps.setString(1, s.getNum());
			ps.setString(2, s.getName());
			ps.setString(3, s.getSex());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getStuId());
			ps.setString(6, s.getDepartment());

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
	 * @see com.edu.dao.IStudent#deleteStudent(java.lang.String) 功能：删除学生信息
	 * 参数：num 学生编号
	 */
	@Override
	public boolean deleteStudent(String num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("delete from student where stuNum=?");
			ps.setString(1, num);

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
	 * @see com.edu.dao.IStudent#modifyStudent(com.edu.dto.Student) 功能：修改学生信息
	 * 参数：Student s
	 */
	@Override

	public boolean modifyStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement(
					"update student set stuName=?,stuSex=?,stuAge=?,stuId=?,stuPassword=? where stuNum=? ");
			ps.setString(1, s.getName());
			ps.setString(2, s.getSex());
			ps.setInt(3, s.getAge());
			ps.setString(4, s.getStuId());
			ps.setString(5, s.getStuPassword());
			ps.setString(6, s.getNum());
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
	 * @see com.edu.dao.IStudent#modifyOwnStudentCourse(com.edu.dto.Student)
	 * 功能：学生进行选课或者修改
	 */

	// public boolean modifyOwnStudentCourse(Student s) throws Exception {
	// // TODO Auto-generated method stub
	// Connection con = null;
	// PreparedStatement ps = null;
	//
	// try {
	// con = getConn();
	// ps = con.prepareStatement("update student set course_name=? where
	// stuNum=? ");
	// ps.setString(1, s.getCourse_name());
	// ps.setString(2, s.getNum());
	// if (ps.executeUpdate() > 0) {
	// DataBase.commit();
	// return true;
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// free(ps, con);
	// return false;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IStudent#lispStudnt 功能： 显示学生信息
	 */
	@Override
	public List<Student> lispStudent() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> sList = null;
		Student s = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from student");
			rs = ps.executeQuery();
			sList = new ArrayList<Student>();
			while (rs.next()) {
				s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				s.setSex(rs.getString("stuSex"));
				s.setAge(rs.getInt("stuAge"));
				s.setDepartment(rs.getString("department"));
				s.setStuId(rs.getString("stuId"));
				s.setEnterDate(rs.getDate("enterDate"));
				s.setDepartment(rs.getString("department"));
				sList.add(s);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(rs, ps, con);
		return sList;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IStudent#findStudent(java.lang.String) 功能：查询学生信息 参数:num
	 * 学生编号
	 */
	public Student findStudent(String num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from student where stuNum=?");
			ps.setString(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				s.setSex(rs.getString("stuSex"));
				s.setAge(rs.getInt("stuAge"));
				s.setStuId(rs.getString("stuId"));
				s.setEnterDate(rs.getDate("enterDate"));
				s.setDepartment(rs.getString("department"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(rs, ps, con);

		return s;
	}

	/*
	 * 功能：按照关键字查询学生信息 int key 进行选择查询方式 keyname：输入关键字 (non-Javadoc)
	 * 
	 * @see com.edu.dao.IStudent#findStudent(int, java.lang.String)
	 */

	public List<Student> findStudent(int key, String keyname) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		List<Student> sList = null;
		try {
			con = getConn();
			switch (key) {
			case 1:
				ps = con.prepareStatement("select * from student where stuNum like ?");
				break;
			case 2:
				ps = con.prepareStatement("select * from student where stuName like ?");
				break;

			default:
				break;
			}

			ps.setString(1, '%' + keyname + '%');
			rs = ps.executeQuery();
			sList = new ArrayList<Student>();
			while (rs.next()) {
				s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				s.setSex(rs.getString("stuSex"));
				s.setAge(rs.getInt("stuAge"));
				s.setStuId(rs.getString("stuId"));
				s.setEnterDate(rs.getDate("enterDate"));
				s.setDepartment(rs.getString("department"));
				sList.add(s);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(rs, ps, con);

		return sList;
	}

	// public Student findStudentCourse(String num) throws Exception {
	// // TODO Auto-generated method stub
	// Connection con = null;
	// PreparedStatement ps = null;
	// ResultSet rs = null;
	// Student s = null;
	// try {
	// con = getConn();
	// ps = con.prepareStatement("select course_name from student where
	// stuNum=?");
	//
	// ps.setString(1, num);
	// rs = ps.executeQuery();
	// while (rs.next()) {
	// s = new Student();
	// s.setCourse_name(rs.getString("course_name"));
	// // s.setNum(rs.getString("stuNum"));
	// // s.setName(rs.getString("stuName"));
	// // s.setSex(rs.getString("stuSex"));
	// // s.setAge(rs.getInt("stuAge"));
	// // s.setProfessional(rs.getString("professional"));
	// // s.setStuClass(rs.getString("stuClass"));
	// // s.setStuId(rs.getString("stuId"));
	// // s.setEnterDate(rs.getDate("enterDate"));
	//
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// free(rs, ps, con);
	//
	// return s;
	// }

	/*
	 * 功能：学生登录 参数：stunum stupassword (non-Javadoc)
	 * 
	 * @see com.edu.dao.IStudent#loginStudent(java.lang.String,
	 * java.lang.String)
	 */
	public Student loginStudent(String stuNum, String stuPassword) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from student where stuNum=? and stuPassword=?");
			ps.setString(1, stuNum);
			ps.setString(2, stuPassword);
			rs = ps.executeQuery();
			if (rs.next()) {
				s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				s.setSex(rs.getString("stuSex"));
				s.setAge(rs.getInt("stuAge"));
				s.setStuId(rs.getString("stuId"));
				s.setEnterDate(rs.getDate("enterDate"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(rs, ps, con);
		return s;

	}

}
