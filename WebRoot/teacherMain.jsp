<%@ page language="java" import="java.util.*,system.vo.*,system.biz.TeacherBiz" pageEncoding="utf-8" contentType= "text/html; charset = utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>
    <base href="<%=basePath%>">
    <title>teacherMain</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="style/main.css">
    <link rel="stylesheet" type="text/css" href="style/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="style/dist/js/bootstrap.min.js"></script>
</head>

<body>
	<%
  		Teachers teacher = new Teachers();
  		teacher = (Teachers)session.getAttribute("teacher");
  		int tid = teacher.getTid();
  		TeacherBiz teacherBiz = new TeacherBiz();
		
  	 %>
    <span class="_name">
	 	欢迎你，<%=teacher.getName() %>！
	</span>
    <img class="background_img" src="img/shuimo.jpg" alt="background">
    <div class="header">
        <div class="img-box"><img src="http://www.ccnu.edu.cn/resources/images/hd_logo.png" alt="placeholder+image"></div>
        <h1>欢迎来到信管考试系统！</h1>
    </div>
    <div class="body">
        <div class="indiv-info">
            <h2>个人信息</h2>
            <hr>
            <p>姓名：<%=teacher.getName() %></p>
            <p>教工号： <%=teacher.getTid() %></p>
            <p>性别：<%=teacher.getGender() %></p>
            <p>年龄：<%=teacher.getAge() %></p>
            <p>主攻方向：<%=teacher.getTitle() %></p>
            <p>专业：<%=teacher.getMajor() %></p>
        </div>
        <div class="class-info">
            <h2>座右铭</h2>
            <hr>
            <p>好多年了，你一直在我的伤口中幽居，我放下过天地，却从未放下过你，我生命中的千山万水，任你一一告别。世间事，除了生死，哪一桩不是闲事</p>
        </div>
        <div class="indiv-class-info">
            <div class="tabbable">
                <!-- Only required for left/right tabs -->
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab1" data-toggle="tab">学生信息</a></li>
                    <li><a href="#tab2" data-toggle="tab">录入课程</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="tab1">
                        <div class="table-responsive scroll">
                            <table class="table table-hover">
                                <tr>
                                    <th>课程名</th>
                                    <th>课程编号</th>
                                    <th>学生姓名</th>
                                    <th>学生学号</th>
                                    <th>课程类别</th>
                                    <th>分数</th>
                                    <th>修改分数</th>
                                </tr>
                                <%
                                List<TeacherTable> teacherTableList  = new ArrayList<TeacherTable>();
								teacherTableList = teacherBiz.searchCourseinfo(tid);
								Iterator<TeacherTable> iter = teacherTableList.iterator();
								TeacherTable teacherTable; 
								while(iter.hasNext()){
									teacherTable = (TeacherTable)iter.next();
                                 %>
                                <tr>
                                    <td><%=teacherTable.getCourseName() %></td>
                                    <td><%=teacherTable.getCourseId() %></td>
                                    <td><%=teacherTable.getStudentName() %></td>
                                    <td><%=teacherTable.getSid() %></td>
                                    <td><%=teacherTable.getCourseType() %></td>
                                    <td><%=teacherTable.getScore() %></td>
                                    <td>
                                    <form style="width: 120px;margin: 0px;" class="modify_score" action="ModifyScore" method="post">
                                    	<div style="display:none">
                                    		<input name="sid" value=<%=teacherTable.getSid() %> type="text">
                                    		<input name="cid" value=<%=teacherTable.getCourseId() %> type="text" >
                                    	</div>
		                        	    <input style="width:60px" name="score" type="text" placeholder="modify">
		                        	    <button type="submit" class="btn btn-mini btn-info "  >确认</button>
			                        </form>
                                    </td>
                                </tr>
                                <% } %>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab2">
                        <form class="form-horizontal course_entry" action="EntryCourse.do" method="post">
                          <div class="input-group">
                            <span class="input-group-addon">课程名</span>
                            <input required="required" type="text" name="cname" class="form-control" placeholder="课程名">
                          </div>
                          <div class="input-group">
                            <span class="input-group-addon">课程号</span>
                            <input required="required" type="number" name="cid" class="form-control" placeholder="课程号">
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
                          	<span class="input-group-addon">类型：</span>
                          	<select name="type" id="major_select" class="form-control">
                          		<option value="Professional_required">专业必修</option>
                          		<option value="Professional_elective">专业选修</option>
                          		<option value="General_compulsory">通识必修</option>
                          		<option value="General_elective">通识选修</option>
                          	</select>
                          </div>
                          <p class="submit">
                          	<button type="submit" class="btn btn-primary">提交</button>
                          </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="foot">
        <span>信息管理学院考试系统by信管小队</span>
    </div>
</body>

</html>
