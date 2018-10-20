package com.qdlg.test;

import java.util.List;

import org.junit.Test;

import com.qdlg.pojo.PageService;
import com.qdlg.pojo.User;
import com.qdlg.service.UserService;
import com.qdlg.service.impl.UserServiceImpl;

public class UserTest {
	
	UserService userService = new UserServiceImpl();
	
	@Test
	public void testUpdateUser(){
		User user = new User();
		user.setId(11);
		user.setName("update");
		user.setPwd("99999");
		user.setSex("男");
		user.setTel("13912345678");
		user.setVipgrade("3");
		user.setInDate("2018-07-17");
		user.setOutDate("2018-07-18");
		user.setRoom("888");
		userService.updateUser(user);
	}
	
	
	@Test
	public void testFindUserById(){
		User user = userService.findUserById(10);
		System.out.println(user);
	}
	
	@Test
	public void testGetAllUser(){
		String name = "%%";
		String tel = "%131%";
		PageService pageService = new PageService();
		pageService.setNowPage(1);
		List<User> list = userService.getAllUserByPage(name, tel, pageService);
		System.out.println(list);
	}
	
	
	
	@Test
	public void testLogin(){
		User user = userService.login("admin111", "6667");
//		System.out.println(user.getId()+":"+user.getName());
		System.out.println(user.getName()==null);
	}
	
	
	

}
