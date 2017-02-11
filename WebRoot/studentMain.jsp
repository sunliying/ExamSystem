<%@ page language="java" import="java.util.*,system.vo.*,system.biz.StudentBiz"  pageEncoding="utf-8" contentType= "text/html; charset = utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>
    <base href="<%=basePath%>">
    <title>studentMain</title>
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
  		Student student = new Student();
  		student = (Student)session.getAttribute("student");
  		int sid = student.getSid();
  		StudentBiz studentBiz = new StudentBiz();

  	 %>
    <span class="_name">
	 	欢迎你，<%=student.getName() %>！
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
            <p>姓名：<%=student.getName() %></p>
            <p>学号：<%=student.getSid() %></p>
            <p>年龄：<%=student.getAge() %></p>
            <p>性别：<%=student.getGender() %></p>
            <p>专业：<%=student.getMajor() %></p>
            <p>班级：<%=student.getGrade() %></p>
        </div>
        <div class="class-info">
            <h2>座右铭</h2>
            <hr>
            <p>真正的勇士，敢于直面惨淡的人生，敢于正视淋漓的鲜血！</p>
        </div>
        <div class="indiv-class-info" >
            <div class="tabbable">
                <!-- Only required for left/right tabs -->
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab1" data-toggle="tab">课程信息</a></li>
                    <li><a href="#tab2" data-toggle="tab">选课</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="tab1">
                        <div class="table-responsive scroll">
                            <table class="table table-hover">
                                <tr>
                                    <th>课程名</th>
                                    <th>课程编号</th>
                                    <th>教师</th>
                                    <th>教师编号</th>
                                    <th>分数</th>
                                    <th>课程类别</th>
                                </tr>
                                <%
                                List<StudentTable> studentTableList  = new ArrayList<StudentTable>();
								studentTableList = studentBiz.searchStudentClassinfo(sid);
								Iterator<StudentTable> studentTableIter = studentTableList.iterator();
								StudentTable studentTable; 
								while(studentTableIter.hasNext()){
									studentTable = (StudentTable)studentTableIter.next();
                                 %>
                                <tr>
                                    <td><%=studentTable.getCourseName() %></td>
                                    <td><%=studentTable.getCourseId() %></td>
                                    <td><%=studentTable.getTeacherName() %></td>
                                    <td><%=studentTable.getTid() %></td>
                                    <td><%=studentTable.getScore() %></td>
                                    <td><%=studentTable.getCourseType() %></td>
                                </tr>
                                <%} %>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab2">
                    	<div class="table-responsive scroll">
                            <table class="table table-hover">
                                <tr>
                                    <th>课程名</th>
                                    <th>课程编号</th>
                                    <th>教师名</th>
                                    <th>课程专业</th>
                                    <th>课程类别</th>
                                    <th>选课</th>
                                </tr>
                                <%
                                List<ClassChoose> classChooseList = new ArrayList<ClassChoose>();
								classChooseList = studentBiz.searchCourseinfo(sid);
								Iterator<ClassChoose> classChooseIter = classChooseList.iterator();
								ClassChoose classChoose;
								while(classChooseIter.hasNext()){
									classChoose = (ClassChoose)classChooseIter.next();
                                 %>
                                <tr>
                                    <td><%=classChoose.getCname() %></td>
                                    <td><%=classChoose.getCid() %></td>
                                    <td><%=classChoose.getTname() %></td>
                                    <td><%=classChoose.getMajor() %></td>
                                    <td><%=classChoose.getType() %></td>
                                    <td class="choose_course">
                                        <form class="choose_form" action="ChooseCourse" method="post">
                                            <div style="display: none">
                                                <input type="text" name="cid"  value=<%=classChoose.getCid() %>  />
                                            </div>
                                            <div>
                                                <input type="submit" class="btn" value="选课" />
                                            </div>
                                        </form>
                                    </td>
                                </tr>
                                <%} %>
                            </table>
                            <script type="text/javascript">
                                $(function(){
                                    $(".btn").onclick = function(){
                                    //点击的时候改变button的样式，并且将其设置为不可点击；
                                    //每次都有刷新页面，这样每次请求之后都没有效果了
                                        this.addClass(" btn-info");
                                        this.attr("disabled","disabled");
                                    };
                                });
                            </script>
                    	</div>
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

