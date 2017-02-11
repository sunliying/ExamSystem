package system.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import system.vo.TeacherTable;
import system.vo.Teachers;

public class TeacherDao {
	public void insert(Connection con, Teachers vo) {
		StringBuffer sb = new StringBuffer(); 
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		try {
			_conn = con;
			sb.append(" insert into Teachers (tid,name,major,title,age,gender,password) ");
			sb.append(" values(?,?,?,?,?,?,?) ");
			ps = _conn.prepareStatement(sb.toString());
			int nIndex = 1;
			ps.setInt   (nIndex++, vo.getTid());
			ps.setString(nIndex++, vo.getName());
			ps.setString(nIndex++, vo.getMajor());
			ps.setString(nIndex++, vo.getTitle());
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
	public Teachers searchTeacherByTid(Connection con,int tid){
		Teachers teachers = null;
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		try {
			_conn = con;
			ps = _conn.prepareStatement("Select * from teachers " +
					" where tid = ?");
			ps.setInt(1, tid);
			ResultSet result = ps.executeQuery();			
			if (result.next()) {
				teachers = new Teachers();
				teachers.setTid(result.getInt("tid"));
				teachers.setName(result.getString("name"));
				teachers.setMajor(result.getString("major"));
				teachers.setAge(result.getInt("age"));
				teachers.setTitle(result.getString("title"));
				teachers.setGender(result.getString("gender"));
				teachers.setPassword(result.getString("password"));
			}
			_conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return teachers;		
	}
	/**
	 * 教师学生课程信息
	 * @param con
	 * @param sid
	 * @return
	 */
	public List<TeacherTable> searchCourseinfo(Connection con,int tid){
		List<TeacherTable> teacherTableList  = new ArrayList<TeacherTable>();
		Connection _conn  = null; 
		StringBuffer sb = new StringBuffer();
		try {
			_conn = con;
			sb.append("select courses.cid,courses.name cname,courses.major," +
					" student.name sname,courses.type courseType,student.sid," +
					" studentCourses.score " +
					" from student,teachers,courses,studentcourses" +
					" where teachers.tid = ? and " +
					" student.sid = studentcourses.sid " +
					" and studentcourses.cid = courses.cid " +
					" and courses.tid = teachers.tid");
			PreparedStatement pStat = _conn.prepareStatement(sb.toString());
			pStat.setInt(1, tid);
			ResultSet result = pStat.executeQuery();
			TeacherTable teacherTable;
			while (result.next()) {
				teacherTable = new TeacherTable();
				teacherTable.setCourseId(result.getInt("cid"));
				teacherTable.setSid(result.getInt("sid"));
				teacherTable.setStudentName(result.getString("sname"));
				teacherTable.setCourseName(result.getString("cname"));
				teacherTable.setMajor(result.getString("major"));
				teacherTable.setCourseType(result.getString("courseType"));
				teacherTable.setScore(result.getFloat("score"));
				teacherTableList.add(teacherTable);
			}
			_conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
       return teacherTableList;
	}

}
