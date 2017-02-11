package system.biz;

import java.sql.Connection;

import system.commen.DBConnection;
import system.dao.CoursesDao;
import system.vo.Courses;

public class  CoursesBiz
{
	public void addCourses(Courses vo){
			DBConnection dbc=new DBConnection();
			if(dbc.getConnect()){
				Connection con =dbc.getConn();
				CoursesDao dao = new CoursesDao();
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
	
	public static void main(String[] args) {
		CoursesBiz biz = new CoursesBiz();
		Courses vo = new Courses();

		biz.addCourses(vo);
		System.out.println("OK!");
	}
}
