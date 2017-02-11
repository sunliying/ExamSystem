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

import system.biz.StudentBiz;
import system.biz.TeacherBiz;
import system.vo.Student;
import system.vo.Teachers;

public class LoginProcess extends HttpServlet {

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
		String loginId = request.getParameter("id");
	    String loginPw = request.getParameter("password");
	    String loginIdentity = request.getParameter("identity");
	    HttpSession session = request.getSession(); 
	    
	    if(loginId!=null){
	    	int intid = Integer.parseInt(loginId);
	    	
		    if(loginIdentity.equals("student")){
		    	StudentBiz studentBiz = new StudentBiz();
				Student studentVo = new Student();
				studentVo = studentBiz.searchStudentBySid(intid);
				ServletContext context = getServletContext();
				if(studentVo==null){
					request.setAttribute("message", "该账户尚未注册，请先注册！");
					RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}else if(!studentVo.getPassword().equals(loginPw)){
					request.setAttribute("message", "密码输入错误，请重新输入！");
					RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}else{
					session.setAttribute("student", studentVo); 
					session.setAttribute("identity", "student");
					request.getRequestDispatcher("/studentMain.jsp").forward(request, response);
				}
		    }else if(loginIdentity.equals("teacher")){
		    	TeacherBiz teacherBiz = new TeacherBiz();
				Teachers teacherVo = new Teachers();
				teacherVo = teacherBiz.searchTeacherByTid(intid);
				ServletContext context = getServletContext();
				if(teacherVo==null){
					request.setAttribute("message", "该账户尚未注册，请先注册！");
					RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}else if(!teacherVo.getPassword().equals(loginPw)){
					request.setAttribute("message", "密码输入错误，请重新输入！");
					RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}else{
			  		session.setAttribute("teacher", teacherVo); 
					session.setAttribute("identity", "teacher");
					request.getRequestDispatcher("/teacherMain.jsp").forward(request, response);
				}
		    }else{
		    	System.out.println("there is something wrong");
		    }
	    }else{
	    	if(session.getAttribute("identity").equals("student")){
	    		request.getRequestDispatcher("/studentMain.jsp").forward(request, response);
	    	}else if(session.getAttribute("identity").equals("teacher")){
	    		request.getRequestDispatcher("/teacherMain.jsp").forward(request, response);
	    	}else{
	    		response.sendRedirect("/error.jsp");
	    	}
	    }
	    
		
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
