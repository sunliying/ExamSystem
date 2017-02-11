<%@ page pageEncoding="utf-8" contentType= "text/html; charset = utf-8"%>

<div class="body">
		<div class="indiv-info">
			<h2>个人信息</h2>
			<hr>
			<p>姓名：张三</p>
			<p>学号：2014214000</p>
			<p>专业：信息管理与信息系统专业</p>
			<p>班级：1401</p>
		</div>
		<div class="class-info">
			<h2>综合信息</h2>
			<hr>
			<p>所选课程共有……门</p>
			<p>平均学分绩：65.2</p>
		</div>
		<div class="indiv-class-info">
			<h2>所选课程信息</h2>
			<hr>
			<table>
				<tr><th>课程名</th><th>课程编号</th><th>教师</th><th>分数</th><th>学分</th><th>课程类别</th></tr>
				<% for(int x=0;x<10;x++){ %>
				<tr><td></td><td></td><td></td><td></td><td></td><th></th></tr>
				<% } %>
			</table>
		</div>
	</div>