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
		<title>用户信息</title>
		
		<script>
			
			function checkAllfun(){
				/*alert("coming....");*/
				// 获取全选   input 节点
				var ckAll = document.getElementById("checkAll");
				// 列表复选框
				var checkItems = document.getElementsByName("checkItem");
				
				// 判断 这个 全选 节点 是否选中
				if(ckAll.checked==true){
					/*alert("选中了");*/
					
					for(var i=0;i<checkItems.length;i++){
						checkItems[i].checked = true;
					}
				}else{
					/*alert("取消了");*/
					for(var i=0;i<checkItems.length;i++){
						checkItems[i].checked = false;
					}
					
				}
			}
			function getName(){
			
			var uname = document.getElementById("uname").value;
			var phone = document.getElementById("phone").value;
			/* alert(uname+":"+phone); */
			window.location.href = "UserPageServlet?action=getALL&uname="+uname+"&phone="+phone;
			}
			
			
			
			
		</script>
		
	</head>
	<body  background="img/ho1.jpg">
		
		<h1 align="center">用户信息</h1>
		<br />
		<h5 align="center">
		 姓名：<input type="text" id="uname" name="uname" value="${param.uname }"/>
		 手机号：<input type="text" id="phone" name="phone" value="${param.phone }"/>
		<input type="button" value="查询" onclick="getName()" /></h5>
	
		
		<table border="1" width="800px" cellspacing="0" align="center">
			<tr>
				<th>全选/全不选<input type="checkbox" id="checkAll" onclick="checkAllfun()" /></th>
				<th>序号</th>
				<th>id</th>
				<th>姓名</th>
				<th>性别</th>
				<th>手机号</th>
				<th>会员等级</th>
				<th>入住时间</th>
				<th>退房日期</th>
				<th>房间号</th>
				<th>操作</th>
			</tr>
			
			<c:forEach items="${list }" var="user" varStatus="in">
				<tr align="center">
					<td><input type="checkbox" name="checkItem" value="${user.id }" /></td>
					<td>${in.index+1 } </td>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.sex }</td>
					<td>${user.tel }</td>
					<td>${user.vipgrade }</td>
					<td>${user.inDate }</td>
					<td>${user.outDate }</td>
					<td>${user.room }</td>
					<td><a href="UserPageServlet?action=getUserById&id=${user.id }">修改</a>||<a href="UserPageServlet?action=delUser&id=${user.id }">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<p align="center">
			
			<button onclick="delsUsers()">全部删除</button>
			
			<a href="UserPageServlet?action=getALL&uname=${param.uname }&phone=${param.phone }&nowPage=1">首页</a>
			<!--  对上一页 进行  处理  -->
			<c:if test="${nowPage<=1 }">
				<a href="UserPageServlet?action=getALL&uname=${param.uname }&phone=${param.phone }&nowPage=1">上一页</a>
			</c:if>
			<c:if test="${nowPage>1 }">
				<a href="UserPageServlet?action=getALL&uname=${param.uname }&phone=${param.phone }&nowPage=${nowPage-1 }">上一页</a>
			</c:if>
			
			<!--  对下一页 进行  处理  -->
			
			<c:if test="${nowPage>=pageCount }">
			  <a href="UserPageServlet?action=getALL&uname=${param.uname }&phone=${param.phone }&nowPage=${pageCount }">下一页</a>
			</c:if>
			<c:if test="${nowPage<pageCount }">
			<a href="UserPageServlet?action=getALL&uname=${param.uname }&phone=${param.phone }&nowPage=${nowPage+1 }">下一页</a>
			</c:if>
			<a href="UserPageServlet?action=getALL&uname=${param.uname }&phone=${param.phone }&nowPage=${pageCount }">尾页</a>
			当前第${nowPage }页||共<span id="pc">${pageCount }</span>页||共${total }条数据 --
			
			跳转至 第<input type="text" id="num" size="3"/>页
			<input type="button" value="跳转" onclick="jumpPage()" />
		</p>
		
		<script type="text/javascript">
		//跳转至  第几页  
			function jumpPage(){
				var x = num.value;
				var y = pc.innerHTML;
				if(x>=y || x<1){
					alert("当前页码共"+y+"页");
					window.location.href = "UserPageServlet?action=getALL&uname=${param.uname }&phone=${param.phone }&nowPage="+y;
				}else{
					window.location.href = "UserPageServlet?action=getALL&uname=${param.uname }&phone=${param.phone }&nowPage="+x;
				}
			}
			// 删除多条
			function delsUsers(){
				/* alert("coming...dels"); */
				var checkItems = document.getElementsByName("checkItem");
				var items = "";
				var k = 0;
				// 循环遍历所有的 复选框 节点 
				for(var i=0;i<checkItems.length;i++){
					// 如果被选中了 
					if(checkItems[i].checked==true){
						items = items+checkItems[i].value+":";
						k++;  // 有一个被选中的 就 +1
					}
				}
				if(k>0){
					window.location.href = "UserPageServlet?action=deleteUsers&items="+items;
				}else{
					alert("请选中要删除的一项！！！");
				
				}
				
				
				
				
			
			
			}
			
		
		</script>
		
		
		
	</body>
</html>