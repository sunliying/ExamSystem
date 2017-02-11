<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType= "text/html; charset = utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
	<title>考试系统登录界面</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="信管，考试系统，登录">
	<meta http-equiv="description" content="this is login page">
	<link rel="stylesheet" type="text/css" href="style/login.css">
	<link rel="stylesheet" type="text/css" href="style/dist/css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.js"></script>

  </head>
  <body>
  
    <div class="navigation">
		<h2>考试系统登录界面</h2>
		<span class="register">还没有注册，点击<a href="./studentRegister.jsp">学生注册</a>、<a href="./teacherRegister.jsp">教师注册</a></span>
	</div>
	<div class="content">
		<div class="comment-box">
			<p>书山有路勤为径，学海无涯苦作舟</p>
			<p>本系统为华中师范大学信息管理学院信管学院学生专用考试系统</p>
			<p>如在本系统遇到什么故障，请及时联系信管学院工作处，谢谢合作！！！</p>
		</div>
		<div class="login-box">
		<h2 class="title">用户登录</h2>
		<hr>
		<form class="form1" action = "LoginProcess.do" method = "post" >
			<p><label>学号：</label><input type="text" required="required" pattern="[0-9]+" placeholder="请输入你的学号"  name="id"></p>
			<p><label>密码：</label><input type="password" required="required" placeholder="请输入你的密码" name="password"></p>
			<div class="gender">
			  <label>身份：</span>
			  <input required="required" type="radio" value="student" name="identity"  ><label>学生</label>
			  <input required="required" type="radio" value ="teacher" name="identity" ><label>教师</label>
			</div>
			<p class="auto-login"><input type="checkbox" name="">下次自动登录</p>
			<p><button id="submit" type = "submit">登录</button> <button type="reset">取消</button></p>
			<%
			  	String message = (String)request.getAttribute("message");
			  	if(message!=null){
			   %>
			<p class="info"><%=message %></p>
			<% } %>
		</form>
		</div>
	</div>

  </body>
</html>
