package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.biz.StudentBiz;
import system.biz.TeacherBiz;
import system.vo.ClassChoose;
import system.vo.Student;
import system.vo.StudentTable;
import system.vo.TeacherTable;

public class StudentRegister extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
	   		String registerSid = request.getParameter("sid");
	   		String registerAge = request.getParameter("age");
	   		String major = request.getParameter("major");
	   		String registerGrage = request.getParameter("grage");
	   		String password = request.getParameter("password");
	   		String gender = request.getParameter("gender");
	   		int sid;
	   		int age;
	   		int grade;
	   		try{
	   			sid = Integer.parseInt(registerSid);
		   		age = Integer.parseInt(registerAge);
		   		grade = Integer.parseInt(registerGrage);
		   		StudentBiz biz = new StudentBiz();
				Student vo = new Student();
				vo.setName(name);
				vo.setSid(sid);
				vo.setAge(age);
				vo.setGrade(grade);
				vo.setGender(gender);
				vo.setMajor(major);
				vo.setPassword(password);
				
				biz.addStudent(vo);
				ServletContext context = getServletContext();
				HttpSession session = request.getSession(); 
		  		session.setAttribute("student", vo); 
				session.setAttribute("identity", "student");
				RequestDispatcher dispatcher = context.getRequestDispatcher("/studentMain.jsp");
				dispatcher.forward(request, response);
	   		}catch(Exception e){
	   			request.setAttribute("error", e);
	   		    response.sendRedirect("/error.jsp");
	   		}
	   		
			System.out.println("OK!");
			
			
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
