<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>top</title>
	</head>
	<body  background="img/ho1.jpg" >
		<h1 align="center">李氏酒店管理系统</h1>
		
		<marquee>
			<font>欢迎 <span style="color: red;font-size: 24px;">${username }</span> 登陆成功！！</font>
		</marquee>
	</body>
</html>
