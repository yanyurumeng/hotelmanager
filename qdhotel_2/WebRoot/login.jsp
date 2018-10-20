<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body{
				background-image: url("img/hotelphoto2.jpg");
				
			}
			#d1{
				color:floralwhite ;
				font-size: 40px;
			}
			#d2{
			
				width: 500px;
				height: 100px;
				
				/*上外边距*/
				margin-top: 100px;
				margin-left: 550px;
				/*内边距*/
			/*	padding-top: 20px;
				padding-left: 30px;*/
				
				color: whitesmoke;
				font-size: 25px;
				line-height: 40px;
			}
		</style>
	<script type="text/javascript">
     	function reloadCode(){
	      var time=new Date().getTime();
	       document.getElementById("imagecode").src="ImageServlet?d="+time;
	     }
	</script>
	</head>
	<body >
		<dir id="d1"><h1 align="center">酒店会员管理系统</h1></dir>
	<div id="d2">
			
			<form action="UserServlet" method="post">
			
			用户名:<input type="text" name="uname" />
			<br/>
			密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="pwd" />
			<br/>
			  验证码:<input  type="text" name="checkCode" size="5"/>
	   			 <img alt="验证码" id="imagecode" src="ImageServlet"/>
	    			<a href="javascript:reloadCode();">看不清楚</a><br>
			<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;
			
			<a href="zhuce.jsp">
				&nbsp;<input type="button" value="注册" />
			</a>
			</form>
			<span style="color: red">${error }</span> 
		</div>
		
	</body>
</html>

