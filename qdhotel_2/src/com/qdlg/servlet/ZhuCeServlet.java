package com.qdlg.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdlg.pojo.User;
import com.qdlg.service.UserService;
import com.qdlg.service.impl.UserServiceImpl;

public class ZhuCeServlet extends HttpServlet {
	UserService userService = new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		System.out.println("coming....");
		
		String name = request.getParameter("uname");
		String tel = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String vipGrade = request.getParameter("vip");
		String intime = request.getParameter("intime");
		String outtime = request.getParameter("outtime");
		String room = request.getParameter("room");
		String pwd = request.getParameter("pwd1");
		
//		System.out.println(name+","+tel+","+sex+","+vipGrade+","+intime+","+outtime+","+room+","+pwd);
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setSex(sex);
		user.setTel(tel);
		user.setVipgrade(vipGrade);
		user.setInDate(intime);
		user.setOutDate(outtime);
		user.setRoom(room);
		userService.addUser(user);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	
	
	

}
