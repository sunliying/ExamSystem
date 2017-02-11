package system.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import system.vo.StudentCourses;

public class StudentCoursesDao {
	public void insert(Connection con, StudentCourses vo) {
		StringBuffer sb = new StringBuffer(); 
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		try {
			_conn = con;
			sb.append(" insert into StudentCourses (sid,cid,score) ");
			sb.append(" values(?,?,?) ");
			ps = _conn.prepareStatement(sb.toString());
			int nIndex = 1;
			ps.setInt   (nIndex++, vo.getSid());
			ps.setInt   (nIndex++, vo.getCid());
			ps.setFloat (nIndex++, vo.getScore());
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
	public void modifyScore(Connection con, StudentCourses vo) {
		StringBuffer sb = new StringBuffer(); 
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		try {
			_conn = con;
			sb.append(" update StudentCourses set score = ? ");
			sb.append(" where sid = ? and cid = ? ");
			ps = _conn.prepareStatement(sb.toString());
			int nIndex = 1;
			ps.setFloat (nIndex++, vo.getScore());
			ps.setInt   (nIndex++, vo.getSid());
			ps.setInt   (nIndex++, vo.getCid());
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

}
