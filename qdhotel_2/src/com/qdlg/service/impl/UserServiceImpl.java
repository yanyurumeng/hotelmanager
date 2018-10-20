package com.qdlg.service.impl;

import java.util.List;

import com.qdlg.dao.UserDao;
import com.qdlg.dao.impl.UserDaoImpl;
import com.qdlg.pojo.PageService;
import com.qdlg.pojo.User;
import com.qdlg.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao userDao = new UserDaoImpl();

	public User login(String name, String pwd) {
		
		return userDao.login(name, pwd);
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	public List<User> getAllUserByPage(String name, String tel,
			PageService pageService) {
		// TODO Auto-generated method stub
		return userDao.getAllUserByPage(name, tel, pageService);
	}

	public int getCount(String name, String tel) {
		// TODO Auto-generated method stub
		return userDao.getCount(name, tel);
	}

	public int delUsers(String[] ids) {
		return userDao.delUsers(ids);
	}

	public void delUser(int id) {
		userDao.delUser(id);
	}

	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

}
