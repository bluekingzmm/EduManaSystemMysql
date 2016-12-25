/**
 * 
 */
package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.IAdmin;
import com.edu.db.DataBase;
import com.edu.dto.AdminUser;
import com.edu.dto.Course;
import com.edu.dto.StuScore;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

/**
 * @author 张明明
 * 功能：管理员登陆，修改学生个人信息，得到学生密码，
 * 查询学生个人成绩，通过教师编号查询教师编号，
 * 显示本班学生成绩，显示本班学生信息
 * 得到教师编号，修改教师个人信息
 * 
 */
public class AdminMysqlImpl extends DataBase implements IAdmin {
	
	/*
	 * 管理员登录
	 */

	public AdminUser loginAdmin(String username,String userpassword ) throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		AdminUser ad=null;
		ResultSet rs=null;
		try {
			con=getConn();
			ps=con.prepareStatement("select * from adminuser where username=? and userpassword=?");
			ps.setString(1, username);
			ps.setString(2, userpassword);
			rs=ps.executeQuery();
			while(rs.next()){
				ad=new AdminUser();
				ad.setUserName(rs.getString("username"));
				ad.setUserPasswprd(rs.getString("userpassword"));	
			}		
		} catch (Exception e) {
			// TODO: handle exception
		}	
		free(rs, ps, con);
		return ad;
	}
	/*
	 * (non-Javadoc)
	 * @see com.edu.dao.IStudent#modifyOwnStudent(com.edu.dto.Student)
	 * 功能：修改个人信息
	 */

	public boolean modifyOwnStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("update student set stuName=?,stuAge=?,stuId=? where stuNum=? ");
			ps.setString(1, s.getName());

			ps.setInt(2, s.getAge());

			ps.setString(3, s.getStuId());

			ps.setString(4, s.getNum());
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		free(ps, con);
		return false;
	}
	/*功能:得到学生密码
	 * 参数：password
	 * (non-Javadoc)
	 * @see com.edu.dao.IStudent#getPassword(java.lang.String)
	 */
	public Student getPassword(String stu_password) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from  student where stuPassword=?");
			ps.setString(1, stu_password);
			rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				s.setSex(rs.getString("stuSex"));
				s.setAge(rs.getInt("stuAge"));
				s.setStuId(rs.getString("stuId"));
				s.setEnterDate(rs.getDate("enterDate"));
				s.setStuPassword(rs.getString("stuPassword"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		free(rs, ps, con);

		return s;

	}
	

	/*功能：根据学生学号进行显示信息
	 * (non-Javadoc)
	 * @see com.edu.dao.IStudent#findByStudent(java.lang.String)
	 */
	
	public List<StuScore> findByStudent(String num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		List<StuScore> sList = null;
		ResultSet rs = null;
		StuScore ss = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vscore1 where stuNum=?");
			ps.setString(1, num);
			rs = ps.executeQuery();
			sList = new ArrayList<StuScore>();
			while (rs.next()) {
				ss = new StuScore();
				Course c=new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				Student s=new Student();
				s.setName(rs.getString("stuName"));
				s.setNum(rs.getString("stuNum"));
				Teacher tea=new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				ss.setCourse(c);
				ss.setStu(s);
				ss.setTea(tea);
				ss.setScore(rs.getDouble("score"));
				sList.add(ss);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		free(rs, ps, con);
		return sList;
	}
	/*
	 * 功能：释放资源
	 */
	public static void free(PreparedStatement ps, Connection con) {

		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
		}
	}

	/*
	 * 功能：释放资源
	 */
	public static void free(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (con != null)
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}

	public Course findTeacherByCode(String tea_id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c=null;
		try {
			ps = con.prepareStatement("select course_id from teacher  where tea_id=?");
			ps.setString(1,tea_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				c=new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				c.setPlace(rs.getString("place"));
				c.setStucount(rs.getInt("stucount"));
				c.setTime(rs.getString("time"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		free(ps, con);
		return c;
	}
	/*
	 * 功能：显示本班学生信息 参数 code 教师编号 (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#LispStudentInfo(java.lang.String)
	 */
	public List<StuScore> LispStudentInfo(String code) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		StuScore v = null;
		ResultSet rs = null;
		List<StuScore> sList = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vscore where tea_id=?");
			ps.setString(1, code);
			rs = ps.executeQuery();
			sList = new ArrayList<StuScore>();
			System.out.println("课程编号\t学生学号\t学生姓名\t性别\t身份证号码\t\t\t毕业日期\t\t课时\t地点");
			while (rs.next()) {
				v = new StuScore();
				Student stu = new Student();
				stu.setNum(rs.getString("stuNum"));
				stu.setStuId(rs.getString("stuId"));
				stu.setSex(rs.getString("stuSex"));
				stu.setName(rs.getString("stuName"));
				stu.setEnterDate(rs.getDate("enterDate"));
				Course c = new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				c.setPlace(rs.getString("place"));
				c.setTime(rs.getString("time"));

				Teacher tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				v.setTea(tea);
				v.setCourse(c);
				v.setStu(stu);
				System.out.println(c.getCourse_id() + "\t" + stu.getNum() + "\t" + stu.getName() + "\t" + stu.getSex()
						+ "\t" + stu.getStuId() + "\t" + stu.getEnterDate() + "\t" + c.getTime() + "\t" + c.getPlace());
				sList.add(v);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		free(rs, ps, con);

		return sList;
	}

	/*
	 * 功能：显示本班学生成绩 参数：code 教师编号 (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#LispStudentScore(java.lang.String)
	 */
	public List<StuScore> LispStudentScore(String code) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		StuScore v = null;
		ResultSet rs = null;
		List<StuScore> sList = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vscore1 where tea_id=?");
			ps.setString(1, code);
			rs = ps.executeQuery();
			sList = new ArrayList<StuScore>();
			System.out.println("课程编号\t学生学号\t学生姓名\t教师编号\t分数\t课程名\t教师名");
			while (rs.next()) {
				v = new StuScore();
				Student s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				Course c = new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				Teacher tea = new Teacher();
				tea.setName(rs.getString("tea_name"));
				tea.setNum(rs.getString("tea_id"));
				v.setCourse(c);
				v.setTea(tea);
				v.setStu(s);
				v.setScore(rs.getDouble("score"));
				System.out.println(v + "\t" + c.getCourse_name() + "\t" + tea.getName());
				sList.add(v);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		free(rs, ps, con);

		return sList;
	}

	/*
	 * 功能：得到教师密码 参数：password (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#getPassword(java.lang.String)
	 */
	public Teacher getTeaPassword(String password) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher tea = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from  teacher where tea_password=?");
			ps.setString(1, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				tea.setSex(rs.getString("sex"));
				tea.setAge(rs.getInt("age"));
				tea.setCourse_id(rs.getString("course_id"));
				tea.setTea_tel(rs.getString("tea_tel"));
				tea.setTea_password(rs.getString("tea_password"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		free(rs, ps, con);

		return tea;

	}
	/*
	 * 功能：修改个人信息 (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#modifyOneTeacher(com.edu.dto.Teacher)
	 */
	public boolean modifyOneTeacher(Teacher tea) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("update teacher set tea_name=?,sex=?,age=?,tea_tel=? where tea_id=?");

			ps.setString(1, tea.getName());
			ps.setString(2, tea.getSex());
			ps.setInt(3, tea.getAge());

			ps.setString(4, tea.getTea_tel());

			ps.setString(5, tea.getNum());
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		free(ps, con);

		return false;
	}

	
}
