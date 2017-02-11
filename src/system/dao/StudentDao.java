package system.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import system.vo.ClassChoose;
import system.vo.Student;
import system.vo.StudentTable;

public class StudentDao {
	public void insert(Connection con, Student vo) {
		StringBuffer sb = new StringBuffer(); 
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		try {
			_conn = con;
			sb.append(" insert into Student (sid,name,major,grade,age,gender,password) ");
			sb.append(" values(?,?,?,?,?,?,?) ");
			ps = _conn.prepareStatement(sb.toString());
			int nIndex = 1;
			ps.setInt   (nIndex++, vo.getSid());
			ps.setString(nIndex++, vo.getName());
			ps.setString(nIndex++, vo.getMajor());
			ps.setInt   (nIndex++, vo.getGrade());
			ps.setInt   (nIndex++, vo.getAge());
			ps.setString(nIndex++, vo.getGender());
			ps.setString(nIndex++, vo.getPassword());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null){
					ps.close();ps= null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Student searchStudentBySid(Connection con,int sid){
		Student student = null;
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		try {
			_conn = con;
			ps = _conn.prepareStatement("Select * from student " +
					" where sid = ?");
			ps.setInt(1, sid);
			ResultSet result = ps.executeQuery();			
			if (result.next()) {
				student = new Student();
				student.setSid(result.getInt("sid"));
				student.setName(result.getString("name"));
				student.setMajor(result.getString("major"));
				student.setAge(result.getInt("age"));
				student.setGrade(result.getInt("grade"));
				student.setGender(result.getString("gender"));
				student.setPassword(result.getString("password"));
			}
			_conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return student;		
	}
	/***
	 * 学生查询的信息
	 * @param con
	 * @param sid
	 * @return
	 */
	public List<StudentTable> searchStudentClassinfo(Connection con,int sid){
		List<StudentTable> studentTableList  = new ArrayList<StudentTable>();
		Connection _conn  = null; 
		StringBuffer sb = new StringBuffer();
		try {
			_conn = con;
			sb.append("select courses.cid,courses.name cname,courses.major,teachers.name tname," +
					" courses.type courseType,teachers.tid,studentCourses.score  "
					+" from student,teachers,courses,studentcourses"
					+" where student.sid = ? and student.sid = studentcourses.sid"
					+" and studentcourses.cid = courses.cid"
					+" and courses.tid = teachers.tid;");
			PreparedStatement pStat = _conn.prepareStatement(sb.toString());
			pStat.setInt(1, sid);
			ResultSet result = pStat.executeQuery();
			StudentTable studentTable;
			while (result.next()) {
				studentTable = new StudentTable();
				studentTable.setCourseId(result.getInt("cid"));
				studentTable.setCourseName(result.getString("cname"));
				studentTable.setMajor(result.getString("major"));
				studentTable.setTeacherName(result.getString("tname"));
				studentTable.setCourseType(result.getString("courseType"));
				studentTable.setTid(result.getInt("tid"));
				studentTable.setScore(result.getFloat("score"));
				studentTableList.add(studentTable);
				
			}
			_conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
       return studentTableList;
	}
	/**
	 * 学生选课
	 * @param con
	 * @param sid
	 * @return
	 */
	public List<ClassChoose> searchCourseinfo(Connection con,int sid){
		List<ClassChoose> classChooseList  = new ArrayList<ClassChoose>();
		Connection _conn  = null; 
		StringBuffer sb = new StringBuffer();
		try {
			_conn = con;
			sb.append("select courses.cid,courses.name cname,courses.major," +
					" teachers.name tname, courses.type courseType,teachers.tid " +
					" from teachers,courses" +
					" where courses.tid = teachers.tid and not exists" +
					" (select * from studentcourses " +
					" where studentcourses.cid=courses.cid and " +
					" studentcourses.sid=? )");
			PreparedStatement pStat = _conn.prepareStatement(sb.toString());
			pStat.setInt(1, sid);
			ResultSet result = pStat.executeQuery();
			ClassChoose classChoose;
			while (result.next()) {
				classChoose = new ClassChoose();
				classChoose.setCid(result.getInt("cid"));
				classChoose.setTid(result.getInt("tid"));
				classChoose.setCname(result.getString("cname"));
				classChoose.setTname(result.getString("tname"));
				classChoose.setMajor(result.getString("major"));
				classChoose.setType(result.getString("courseType"));
				classChooseList.add(classChoose);
			}
			_conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
       return classChooseList;
	}
}
