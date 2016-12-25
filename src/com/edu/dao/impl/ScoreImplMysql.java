/**
 * 
 */
package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.IScore;
import com.edu.db.DataBase;
import com.edu.dto.Course;
import com.edu.dto.StuScore;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

/**
 * @author 张明明
 * 功能： 添加，删除，修改，显示成绩，按照学生编号删除成绩，按照课程编号删除成绩，
 * 按照学生编号查询成绩，按照课程编号查询成绩，get得到学生和课程，
 * 按照课程编号查看本课程成绩的总分和平均分，按照分数排序的课程编号
 *
 */
public class ScoreImplMysql extends DataBase implements IScore {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IScore#addScore(com.edu.dto.StuScore)
	 * 功能：添加成绩
	 */
	@Override
	public boolean addScore(StuScore s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("insert into stu_score(course_id,stuNum,tea_id,score) values(?,?,?,?)");
			ps.setString(1, s.getCourse().getCourse_id());
			ps.setString(2, s.getStu().getNum());
			ps.setString(3, s.getTea_id());
			ps.setDouble(4, s.getScore());

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
	 * @see com.edu.dao.IScore#delectScore(com.edu.dto.StuScore)
	 * 功能：删除成绩
	 */
	@Override
	public boolean delectScore(StuScore s) throws Exception {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("delete from stu_score where stuNum=? and course_id=?");
			ps.setString(1, s.getStu().getNum());
			ps.setString(2, s.getCourse().getCourse_id());
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
	 * @see com.edu.dao.IScore#delectByStudent(com.edu.dto.Student)
	 * 功能：按照学生编号删除成绩
	 */
	@Override
	public boolean delectByStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("delete from stu_score where stuNum=?");
			ps.setString(1, s.getNum());
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
	 * @see com.edu.dao.IScore#delectByCourse(com.edu.dto.Course)
	 * 功能：按照课程编号删除成绩
	 */
	@Override
	public boolean delectByCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("delete from stu_score where course_id=?");
			ps.setString(1, c.getCourse_id());
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
	 * @see com.edu.dao.IScore#findByStudent(com.edu.dto.Student)
	 * 功能：按照学生学号查询课程成绩以及教师信息
	 * 视图VScore1
	 */
	@Override
	public List<StuScore> findByStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		List<StuScore> sList = null;
		ResultSet rs = null;
		StuScore ss = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vscore1 where stuNum=?");
			ps.setString(1, s.getNum());
			rs = ps.executeQuery();
			sList = new ArrayList<StuScore>();
			while (rs.next()) {
				ss = new StuScore();
				Course c=new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				s.setName(rs.getString("stuName"));
				s.setNum(rs.getString("stuNum"));
				Teacher tea=new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				ss.setCourse(c);
				ss.setStu(s);
				ss.setScore(rs.getDouble("score"));
				sList.add(ss);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		AdminMysqlImpl.free(rs, ps, con);
		return sList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IScore#findByCourse(com.edu.dto.Course)
	 * 按照课程编号查询成绩课程信息
	 */
	@Override
	public List<StuScore> findByCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		List<StuScore> sList = null;
		ResultSet rs = null;
		StuScore ss = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vscore1 where course_id=?");
			ps.setString(1, c.getCourse_id());
			rs = ps.executeQuery();
			sList = new ArrayList<StuScore>();
			while (rs.next()) {
				ss = new StuScore();
				
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				Student stu=new Student();
				stu.setName(rs.getString("stuName"));
				stu.setNum(rs.getString("stuNum"));
				Teacher tea=new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				ss.setCourse(c);
				ss.setStu(stu);
				ss.setTea(tea);
				ss.setScore(rs.getDouble("score"));

				sList.add(ss);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		AdminMysqlImpl.free(rs, ps, con);
		return sList;
	}

	/*
	 * (non-Javadoc)
	 * -------
	 * @see com.edu.dao.IScore#modifyScore(com.edu.dto.StuScore)
	 * 功能：修改成绩
	 */
	@Override
	public boolean modifyScore(StuScore s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("update stu_score set score=?,tea_id=? where stuNum=? and course_id=?");
			ps.setDouble(1, s.getScore());
			ps.setString(2, s.getTea().getNum());
			ps.setString(3, s.getStu().getNum());
			ps.setString(4, s.getCourse().getCourse_id());
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
	 * @see com.edu.dao.IScore#get(com.edu.dto.Student, com.edu.dto.Course)
	 * 功能：得到学生编号和教师编号
	 */
	@Override
	public StuScore get(Student s, Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StuScore ss = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from stu_score where stuNum=? and course_id=?");
			ps.setString(1, s.getNum());
			ps.setString(2, c.getCourse_id());
			rs = ps.executeQuery();
			while (rs.next()) {
				ss = new StuScore();
				ss.setCourse(c);
				ss.setStu(s);
				Teacher tea=new Teacher();
				tea.setNum(rs.getString("tea_id"));
				ss.setTea(tea);
				ss.setScore(rs.getDouble("score"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		AdminMysqlImpl.free(rs, ps, con);
		return ss;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.edu.dao.IScore#findByCourseLookExam(com.edu.dto.Course)
	 * 功能:通过视图显示课程信息和成绩（课程编号）
	 */
	public StuScore findByCourseLookExam(Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StuScore> sList = null;
		StuScore exam = null;
		try {
			// ps=con.prepareStatement("select * from score where code=?");
			ps = con.prepareStatement(
					"SELECT course_id,course_name,score from vscore1  WHERE  course_id=?");
			ps.setString(1, c.getCourse_id());
			rs = ps.executeQuery();
			sList = new ArrayList<StuScore>();
			while (rs.next()) {
				exam = new StuScore();
				
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				exam.setCourse(c);
				exam.setScore(rs.getDouble("score"));
				sList.add(exam);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(rs, ps, con);
		return exam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IScore#lisp(int)
	 */
	@Override
	
	/*
	 * (non-Javadoc)
	 * @see com.edu.dao.IScore#LispStudentScore()
	 *功能：显示所有学生成绩
	 */
	public List<StuScore> LispStudentScore() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		StuScore v = null;
		ResultSet rs = null;
		List<StuScore> sList = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vscore1 ");
			rs = ps.executeQuery();
			sList = new ArrayList<StuScore>();
			while (rs.next()) {
				v = new StuScore();
				Student s=new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				Course c=new Course();		
				c.setCourse_name(rs.getString("course_name"));
				c.setCourse_id(rs.getString("course_id"));
				Teacher tea=new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				v.setScore(rs.getDouble("score"));
				
				
				sList.add(v);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		AdminMysqlImpl.free(rs, ps, con);

		return sList;
	}

	

	/*
	 * (non-Javadoc)
	 * @see com.edu.dao.IScore#lisp(java.lang.String)
	 * 功能：通过视图显示课程信息教师信息学生信息，按照分数排序的课程编号
	 * 参数：code 教师编号
	 */
	public List<StuScore> lisp(String code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StuScore> sList = null;
		StuScore exam = null;
		try {
			ps = con.prepareStatement("select * from vscore1 WHERE   course_id=?");
			ps.setString(1, code);
			rs = ps.executeQuery();
			System.out.println("课程编号\t学生学号\t学生姓名\t教师编号\t成绩\t课程名\t教师名");
			sList = new ArrayList<StuScore>();
			while (rs.next()) {
				exam = new StuScore();
				Course c=new Course(); 
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				Student s=new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				
				Teacher tea=new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				exam.setCourse(c);
				exam.setStu(s);
				exam.setTea(tea);
				exam.setScore(rs.getDouble("score"));
				System.out.println(exam+"\t"+c.getCourse_name()+"\t"+tea.getName());
				sList.add(exam);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		AdminMysqlImpl.free(ps, con);
		return sList;
	}

}
