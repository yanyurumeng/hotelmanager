package com.qdlg.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdlg.pojo.PageService;
import com.qdlg.pojo.User;
import com.qdlg.service.UserService;
import com.qdlg.service.impl.UserServiceImpl;

public class UserPageServlet extends HttpServlet {

	UserService userService = new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action =  request.getParameter("action");
		// 对前端传过来的 uname 进行处理
		String name = request.getParameter("uname");
		if(name==null||name==""){
			name = "%%";
		}else{
			name = "%"+name+"%";
		}
		//对前端传过来的 tel 进行处理
		String tel = request.getParameter("phone");
		if(tel==null||tel==""){
			tel = "%%";
		}else{
			tel = "%"+tel+"%";
		}
		// 前台向后台传递数据的时候，不管是什么类型，都是String
		// 获取前台传过来的  当前页码
		int nowPage = request.getParameter("nowPage")==null||request.getParameter("nowPage")==""?1:Integer.parseInt(request.getParameter("nowPage"));
		
		PageService pageService = new PageService();
		// 设置当前页码
		pageService.setNowPage(nowPage);
		// 设置 总记录数  （求出共几页）
		pageService.setTotal(userService.getCount(name, tel));
		
	//----------分页条件查询---------------------------------	
		if(action.equals("getALL")){
		List<User> list = userService.getAllUserByPage(name, tel, pageService);
			request.setAttribute("list", list);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("total", pageService.getTotal());
			request.setAttribute("pageCount", pageService.getPageCount());
			request.getRequestDispatcher("usertable.jsp").forward(request, response);
		// -----单条删除-----------------------------	
		}else if(action.equals("delUser")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			userService.delUser(id);
	//------ 删除完 也要重新查一遍--------------
			List<User> list = userService.getAllUserByPage(name, tel, pageService);
			request.setAttribute("list", list);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("total", pageService.getTotal());
			request.setAttribute("pageCount", pageService.getPageCount());
			request.getRequestDispatcher("usertable.jsp").forward(request, response);
			
			
//   ---------------根据 id 查询  user信息 
		}else if(action.equals("getUserById")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			User user = userService.findUserById(id);
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("update.jsp").forward(request, response);
//----------- 修改 用户 --------------------
		}else if(action.equals("updateUser")){
			// 接收前台传过来的用户更新信息
			String uname = request.getParameter("uname");
			String phone = request.getParameter("phone");
			String sex = request.getParameter("sex");
			String vipGrade = request.getParameter("vip");
			String intime = request.getParameter("intime");
			String outtime = request.getParameter("outtime");
			String room = request.getParameter("room");
			String pwd = request.getParameter("pwd1");
			int id = Integer.parseInt(request.getParameter("id"));
			//  设置 user 对象 
			User user = new User();
			user.setId(id);
			user.setName(uname);
			user.setPwd(pwd);
			user.setSex(sex);
			user.setTel(phone);
			user.setVipgrade(vipGrade);
			user.setInDate(intime);
			user.setOutDate(outtime);
			user.setRoom(room);
			userService.updateUser(user);
//-------- 修成完成后，也要重新 查询一次用户信息---------------
			List<User> list = userService.getAllUserByPage(name, tel, pageService);
			request.setAttribute("list", list);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("total", pageService.getTotal());
			request.setAttribute("pageCount", pageService.getPageCount());
			request.getRequestDispatcher("usertable.jsp").forward(request, response);
			
// ------------ 多条删除-------------------------
		}else if(action.equals("deleteUsers")){
			String items = request.getParameter("items");
			System.out.println("items:"+items);
			/*12:11:10:  split("reg") 根据reg规则进行 字符串的切割   */
			String[] ids = items.split(":");
			userService.delUsers(ids);
		//  删除完之后   重新查询一遍  
			List<User> list = userService.getAllUserByPage(name, tel, pageService);
			request.setAttribute("list", list);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("total", pageService.getTotal());
			request.setAttribute("pageCount", pageService.getPageCount());
			request.getRequestDispatcher("usertable.jsp").forward(request, response);
		}
	}
}
