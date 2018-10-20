<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			/* body{
				background-image: url("img/hotelphoto2.jpg");
			} */
			#d1{
				color:floralwhite ;
				font-size: 24px;
			}
			
			#d2{
				width: 500px;
				height: 100px;
				
				/*上外边距*/
				/* margin-top: 50px; */
				margin-left: 400px;
				/*内边距*/
			/*	padding-top: 20px;
				padding-left: 30px;*/
				
				color: white;
				font-size: 25px;
				line-height: 40px;
			}
		</style>
		
	</head>
	<body  background="img/ho1.jpg">
		<dir id="d1"><h1 align="center">更新酒店会员信息</h1></dir>
		
	<div id="d2">
			
			<form action="UserPageServlet?action=updateUser" id="from1" method="post">
			  <input type="hidden" name="id" value="${user.id }" />
			用&nbsp;户&nbsp;名:<input type="text" name="uname" value="${user.name }" />
			<br/>
			手&nbsp;机&nbsp;号:<input type="text" name="phone" value="${user.tel }"/>
			<br />
			性别：
			<c:if test="${user.sex=='男' }">
				<input type="radio" name="sex" checked="checked" value="男" />男&nbsp;&nbsp;&nbsp;
				 <input type="radio" name="sex" value="女" />女<br/>
			</c:if>
			
			<c:if test="${user.sex=='女' }">
				<input type="radio" name="sex" value="男" />男&nbsp;&nbsp;&nbsp;
				 <input type="radio" name="sex" checked="checked" value="女" />女<br/>
			</c:if>
			
			 会员等级<input type="text" name="vip" value="${user.vipgrade }" /><br/>
			 入住时间<input type="date" name="intime" value="${user.inDate }"/><br />
			退房日期<input type="date" name="outtime" value="${user.outDate }"/>
			<br />
			房&nbsp;间&nbsp;号:<input type="text" name="room" value="${user.room }" /><br />
			密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:
			<input type="password" id="pwd1" name="pwd1" value="${user.pwd }" />
			<br/>
		     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     <input type="submit" value="更新" align="center"width="50px"/>
		     <input type="reset" value="重置" align="center"width="50px"/>
			</form>
		</div>
		
	</body>
</html>
