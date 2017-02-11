package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.biz.CoursesBiz;
import system.biz.TeacherBiz;
import system.vo.Courses;
import system.vo.Teachers;

public class EntryCourse extends HttpServlet {

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

		this.doPost(request, response);
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
		HttpSession session = request.getSession(); 
		Teachers teacher = new Teachers();
  		teacher = (Teachers)session.getAttribute("teacher");
  		request.setCharacterEncoding("UTF-8");
		String courseName = request.getParameter("cname");
	    String courseId = request.getParameter("cid");
	    String courseMajor = request.getParameter("major");
	    String courseType = request.getParameter("type");
	    if(courseId != null){
	    	int cid = Integer.parseInt(courseId);

			CoursesBiz biz = new CoursesBiz();
			Courses vo = new Courses();
			vo.setName(courseName);
			vo.setCid(cid);
			vo.setMajor(courseMajor);
			vo.setType(courseType);
			vo.setTid(teacher.getTid());
			biz.addCourses(vo);
	    }
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/teacherMain.jsp");
		dispatcher.forward(request, response);
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
