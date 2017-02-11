package system.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.vo.Courses;
import system.vo.Student;

public class CoursesDao {
	public void insert(Connection con, Courses vo) {
		StringBuffer sb = new StringBuffer(); 
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		try {
			_conn = con;
			sb.append(" insert into Courses (cid,tid,name,type,major) ");
			sb.append(" values(?,?,?,?,?) ");
			ps = _conn.prepareStatement(sb.toString());
			int nIndex = 1;
			ps.setInt   (nIndex++, vo.getCid());
			ps.setInt   (nIndex++, vo.getTid());
			ps.setString(nIndex++, vo.getName());
			ps.setString(nIndex++, vo.getType());
			ps.setString(nIndex++, vo.getMajor());
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
	public boolean searchCourseIn(Connection con,int sid,int cid){
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		boolean courseIn = false;
		try {
			_conn = con;
			ps = _conn.prepareStatement("Select * from courses " +
					" where sid = ? and cid = ?");
			ps.setInt(1, sid);
			ps.setInt(2, cid);
			ResultSet result = ps.executeQuery();			
			courseIn =  result.wasNull();
			_conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return courseIn;		
	}

}
