package system.biz;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import system.commen.DBConnection;
import system.dao.TeacherDao;
import system.vo.TeacherTable;
import system.vo.Teachers;

public class  TeacherBiz
{
	public void addTeacher(Teachers vo){
			DBConnection dbc=new DBConnection();
			if(dbc.getConnect()){
				Connection con =dbc.getConn();
				TeacherDao dao = new TeacherDao();
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
	public Teachers searchTeacherByTid(int tid){
		DBConnection dbc=new DBConnection();
		Teachers teacher = new Teachers();
		if(dbc.getConnect()){
			Connection con =dbc.getConn();
			TeacherDao dao = new TeacherDao();
			teacher = dao.searchTeacherByTid(con,tid);
			try{
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}		
		}else{
			System.out.println("sucssess!!");
		}
		return teacher;
	}
	public List<TeacherTable> searchCourseinfo(int tid){
		DBConnection dbc=new DBConnection();
		List<TeacherTable> teacherTableList  = new ArrayList<TeacherTable>();
		if(dbc.getConnect()){
			Connection con =dbc.getConn();
			TeacherDao dao = new TeacherDao();
			teacherTableList = dao.searchCourseinfo(con,tid);
			try{
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}		
		}else{
			System.out.println("sucssess!!");
		}
		return teacherTableList;
	}
	
	public static void main(String[] args) {
		TeacherBiz biz = new TeacherBiz();
		Teachers vo = new Teachers();

		biz.addTeacher(vo);
		System.out.println("OK!");
	}
}
