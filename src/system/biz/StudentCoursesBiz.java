package system.biz;

import java.sql.Connection;

import system.commen.DBConnection;
import system.dao.StudentCoursesDao;
import system.vo.StudentCourses;

public class  StudentCoursesBiz
{
	public void addStudentCourses(StudentCourses vo){
			DBConnection dbc=new DBConnection();
			if(dbc.getConnect()){
				Connection con =dbc.getConn();
				StudentCoursesDao dao = new StudentCoursesDao();
				dao.insert(con,vo);
				try{
					con.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}		
			}else{
				System.out.println("sucssess!!");
			}
		
		}
	public void modifyScore(StudentCourses vo){
		DBConnection dbc=new DBConnection();
		if(dbc.getConnect()){
			Connection con =dbc.getConn();
			StudentCoursesDao dao = new StudentCoursesDao();
			dao.modifyScore(con,vo);
			try{
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}		
		}else{
			System.out.println("sucssess!!");
		}
	
	}
	
	public static void main(String[] args) {
		StudentCoursesBiz biz = new StudentCoursesBiz();
		StudentCourses vo = new StudentCourses();

		biz.addStudentCourses(vo);
		System.out.println("OK!");
	}
}
