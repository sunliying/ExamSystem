<%@ page pageEncoding="utf-8" contentType= "text/html; charset = utf-8"%>

<div class="body">
		<div class="indiv-info">
			<h2>个人信息</h2>
			<hr>
			<p>姓名：王老师</p>
			<p>教工号： 2010214000</p>
			<p>职位：教授</p>
			<p>主攻方向：数据挖掘、机器学习……</p>
		</div>
		<div class="class-info">
			<h2>综合信息</h2>
			<hr>
			<p>教授课程：</p>
			<p>1. 数据挖掘算法原理与实践</p>
			<p>2. java编程</p>
		</div>
		<div class="indiv-class-info">
			<h2>教授学生信息</h2>
			<button class="modify">修改</button><button class="save">保存</button>
			<hr>
			<table>
				<tr><th>课程名</th><th>课程编号</th><th>学生姓名</th><th>学生学号</th><th>分数</th><th>学分</th><th>课程类别</th></tr>
				<% for(int x=0;x<10;x++){ %>
				<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
				<% } %>
			</table>
		</div>
	</div>