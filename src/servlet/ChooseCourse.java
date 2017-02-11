package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.biz.CoursesBiz;
import system.biz.StudentCoursesBiz;
import system.vo.Courses;
import system.vo.Student;
import system.vo.StudentCourses;

public class ChooseCourse extends HttpServlet {

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
		HttpSession session = request.getSession();
		String cidStr = request.getParameter("cid");
		if(cidStr!=null){
			int cid = Integer.parseInt(cidStr);
			Student student = new Student();
	  		student = (Student)session.getAttribute("student");
	  		int sid = student.getSid();
	  		StudentCourses vo = new StudentCourses();
	  		vo.setCid(cid);
	  		vo.setSid(sid);
	  		
	  		StudentCoursesBiz studentCourseBiz = new StudentCoursesBiz(); 
	  		studentCourseBiz.addStudentCourses(vo);
		}
		
  		request.getRequestDispatcher("/studentMain.jsp").forward(request, response);
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
