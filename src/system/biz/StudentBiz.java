package system.biz;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import system.commen.DBConnection;
import system.dao.StudentDao;
import system.dao.TeacherDao;
import system.vo.ClassChoose;
import system.vo.Student;
import system.vo.StudentTable;
import system.vo.TeacherTable;

public class  StudentBiz
{
	public void addStudent(Student vo){
			DBConnection dbc=new DBConnection();
			if(dbc.getConnect()){
				Connection con =dbc.getConn();
					StudentDao dao = new StudentDao();
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
	public Student searchStudentBySid(int sid){
		DBConnection dbc=new DBConnection();
		Student student = new Student();
		if(dbc.getConnect()){
			Connection con =dbc.getConn();
			StudentDao dao = new StudentDao();
			student = dao.searchStudentBySid(con,sid);
			try{
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}		
		}else{
			System.out.println("sucssess!!");
		}
		return student;
	}
	public List<StudentTable> searchStudentClassinfo(int sid){
		DBConnection dbc=new DBConnection();
		List<StudentTable> studentTableList  = new ArrayList<StudentTable>();
		if(dbc.getConnect()){
			Connection con =dbc.getConn();
			StudentDao dao = new StudentDao();
			studentTableList = dao.searchStudentClassinfo(con,sid);
			try{
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}		
		}else{
			System.out.println("sucssess!!");
		}
		return studentTableList;
	}
	public List<ClassChoose> searchCourseinfo(int sid){
		DBConnection dbc=new DBConnection();
		List<ClassChoose> classChooseList  = new ArrayList<ClassChoose>();
		if(dbc.getConnect()){
			Connection con =dbc.getConn();
			StudentDao dao = new StudentDao();
			classChooseList = dao.searchCourseinfo(con,sid);
			try{
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}		
		}else{
			System.out.println("sucssess!!");
		}
		return classChooseList;
	}
	
	public static void main(String[] args) {
		StudentBiz biz = new StudentBiz();
		Student vo = new Student();

		biz.addStudent(vo);
		System.out.println("OK!");
	}
}
