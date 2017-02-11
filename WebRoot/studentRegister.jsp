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
	<title>考试系统学生注册界面</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="信息管理学院，注册">
	<meta http-equiv="description" content="注册信息管理学院考试系统">
	<link rel="stylesheet" type="text/css" href="style/dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="style/register.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			var password = $(".password")[0];
			var identify_password = $(".identify_password")[0];
			var form = $(".form1")[0];

			form.onsubmit = function(){
				console.log(password.value,identify_password.value);
				if (password.value!=identify_password.value) {
					$(".pwdiff").text("两次密码不一样,请重新输入!!!");
					return false;
				}else{
					document.getElementById("form1").action="StudentRegister.do";
				}
			};
		});
	</script>

  </head>
  <body>
  	<div class="page-header">
  	  <h2>考试系统学生注册界面</h2>
  	</div>
	<div class="content">
		<div class="login-box">
		<form id="form1" class="form1" autocomplete="on" method = "post" >
			<div class="input-group">
			  <span class="input-group-addon">姓名：</span>
			  <input required="required" autofocus="on" type="text" name="name" class="form-control"  placeholder="请输入姓名">
			</div>
			<div class="input-group">
			  <span class="input-group-addon">学号：</span>
			  <input required="required" type="number" max="2017000000" name="sid" class="form-control" placeholder="小于等于10位数，开头小于2017">
			</div>
			<div class="input-group">
			  <span class="input-group-addon">年龄：</span>
			  <input required="required" min="1" max="120" type="number" name="age" class="form-control" placeholder="请输入你的年龄">
			</div>
			<div class="input-group">
				<span class="input-group-addon">专业：</span>
				<select name="major" id="major_select" class="form-control">
					<option value="IMIS">信息管理与信息系统</option>
					<option value="IRM">信息资源管理</option>
					<option value="EB">电子商务</option>
				
				</select>
			</div>
			<div class="input-group">
				<span class="input-group-addon">年级：</span>
				<select name="grage" id="major_select" class="form-control">
					<option value="1">大一</option>
					<option value="2">大二</option>
					<option value="3">大三</option>
					<option value="4">大四</option>
				</select>
			</div>
			<div class="input-group">
			  <span class="input-group-addon">设置密码：</span>
			  <input required="required" pattern="[a-zA-Z0-9_]{3,20}" type="password" name="password" class="form-control password" placeholder="字母、下划线、数字，最少3字符，最多20字符">
			</div>
			<div class="input-group">
			  <span class="input-group-addon">确认密码：</span>
			  <input required="required" type="password" class="form-control identify_password" placeholder="请确认密码">
			</div>
			<div><p class="pwdiff" ></p></div>
			<div class="input-group">
			  <span class="input-group-addon">性别：</span>
			  <input required="required" type="radio" value="m" name="gender"  ><label>男</label>
			  <input required="required" type="radio" value ="f" name="gender" ><label>女</label>
			</div>

			<p class="submit">
			<button type="submit" class="btn btn-primary">注册</button>
			<button type="reset" class="btn btn-primary">取消</button></p>
		</form>
		</div>
	</div>
  </body>
</html>
