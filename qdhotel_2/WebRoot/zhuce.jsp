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
				margin-top: 50px;
				margin-left: 550px;
				/*内边距*/
			/*	padding-top: 20px;
				padding-left: 30px;*/
				
				color: white;
				font-size: 25px;
				line-height: 40px;
			}
		</style>
		<script type="text/javascript">
			function check(){
				/* alert("注册成功"); */
				var pwd1 = document.getElementById("pwd1").value;
				var pwd2 = document.getElementById("pwd2").value;
				
				if(pwd1==pwd2){
				  document.getElementById("from1").submit();
				}else{
					alert("两次输入的密码不同！！！");
					
				}
			}
			
		</script>
	</head>
	<body>
		<dir id="d1"><h1 align="center">酒店注册系统</h1></dir>
		
	<div id="d2">
			
			<form action="ZhuCeServlet" id="from1" method="post">
			
			用&nbsp;户&nbsp;名:<input type="text" name="uname" />
			<br/>
			手&nbsp;机&nbsp;号:<input type="text" name="phone"/>
			<br />
			性别：
			<input type="radio" name="sex" value="男" />男&nbsp;&nbsp;&nbsp;
			 <input type="radio" name="sex" value="女" />女<br/>
			 会员等级<input type="text" name="vip"/><br/>
			 入住时间<input type="date" name="intime"/><br />
			退房日期<input type="date" name="outtime"/>
			<br />
			房&nbsp;间&nbsp;号:<input type="text" name="room" /><br />
			密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" id="pwd1" name="pwd1" />
			<br/>
			确认密码<input type="password" id="pwd2" name="pwd2" />
			<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick="check()" value="注册" align="center"width="50px"/>
			</form>
		</div>
		
	</body>
</html>
