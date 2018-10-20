package com.qdlg.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdlg.pojo.User;
import com.qdlg.service.UserService;
import com.qdlg.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	
	UserService userService = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		// 获取 页面输入的验证码 
		String code1 = request.getParameter("checkCode");
		System.out.println("页面验证码："+code1);
		// 获取session中  图片的验证码
		String code2 = (String) request.getSession().getAttribute("piccode");
		System.out.println("图片中的验证码："+code2);
		
		
		// 如果验证码 输入正确
		if(code1.equalsIgnoreCase(code2)){
			User user = userService.login(name, pwd);
			
			if(user.getName()==null){
				request.setAttribute("error", "用户名或者密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				request.getSession().setAttribute("username", user.getName());
				response.sendRedirect("index.html");
			}
		}else{
			request.setAttribute("error", "验证码输入错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
		
		
		
	}
	
	
	
	

}
