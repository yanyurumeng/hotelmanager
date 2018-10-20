package com.qdlg.service;

import java.util.List;

import com.qdlg.pojo.PageService;
import com.qdlg.pojo.User;

public interface UserService {
	
	public User login(String name,String pwd);
	public void addUser(User user);
	// 根据  name   和 tel  分页查询 User
	public List<User> getAllUserByPage(String name,String tel,PageService pageService);
	// 查询user表中有多少条记录
	public int getCount(String name,String tel);
	// 批量删除   多条删除 
	public int delUsers(String[] ids);
	// 单条删除 
	public void delUser(int id);
	//   根据id  查询  User
	public User findUserById(int id);
	// 根据ID  修改 User 信息    
	public void updateUser(User user);
	
	
	
}
