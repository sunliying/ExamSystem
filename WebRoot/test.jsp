<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="./test2.jsp" method="post">
    	<div>
    		<label for="name">Text Input:</label>
    		<input type="text" name="score" id="name" value="100" tabindex="1" />
    	</div>
    	<div>
    		<label for="name">Text Input:</label>
    		<input type="text" name="score" id="name" value="90" tabindex="1" />
    	</div>
    	<div>
    		<label for="name">Text Input:</label>
    		<input type="text" name="score" id="name" value="80" tabindex="1" />
    	</div>
    	<div>
    		<label for="name">Text Input:</label>
    		<input type="text" name="score" id="name" value="70" tabindex="1" />
    	</div>
    	<div>
    		<label for="name">Text Input:</label>
    		<input type="text" name="score" id="name" value="60" tabindex="1" />
    	</div>
    	<div>
    		<label for="name">Text Input:</label>
    		<input type="text" name="name" id="name" value="sunly" tabindex="1" />
    	</div>
    	<div>
    		<label for="name">Text Input:</label>
    		<input type="text" name="name" id="name" value="danting" tabindex="1" />
    	</div>
    	<div>
    		<label for="name">Text Input:</label>
    		<input type="text" name="name" id="name" value="yandan" tabindex="1" />
    	</div>
    	<div>
    		<label for="name">Text Input:</label>
    		<input type="text" name="name" id="name" value="liubiao" tabindex="1" />
    	</div>
    	<div>
    		<label for="name">Text Input:</label>
    		<input type="text" name="name" id="name" value="ailing" tabindex="1" />
    	</div>
    
    	
    	<div>
    		<input type="submit" value="Submit" />
    	</div>
    </form>
  </body>
</html>
