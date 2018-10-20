package com.qdlg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qdlg.dao.UserDao;
import com.qdlg.pojo.PageService;
import com.qdlg.pojo.User;
import com.qdlg.utils.DBConn;

public class UserDaoImpl implements UserDao{
	DBConn db = new DBConn();
	Connection conn = db.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 根据ID  修改 User 信息    
	public void updateUser(User user){
		String sql = "update user set name=?,pwd=?,sex=?,tel=?,vipgrade=?,inDate=?,outDate=?,room=? where id=? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getVipgrade());
			ps.setString(6, user.getInDate());
			ps.setString(7, user.getOutDate());
			ps.setString(8, user.getRoom());
			ps.setInt(9, user.getId());
			ps.executeUpdate();
			System.out.println("修改成功！！！");
		} catch (SQLException e) {
			System.err.println("修改失败");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	//   根据id  查询  User
	public User findUserById(int id){
		
		String sql = "select id,name,pwd,sex,tel,vipgrade,inDate,outDate,room from user where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			User user = new User();
			while(rs.next()){
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setTel(rs.getString(5));
				user.setVipgrade(rs.getString(6));
				user.setInDate(rs.getString(7));
				user.setOutDate(rs.getString(8));
				user.setRoom(rs.getString(9));
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
		
		
	}
	
	
	
	
	// 单条删除 
	public void delUser(int id){
		String sql = "delete from user where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("删除成功！");
		} catch (SQLException e) {
			System.err.println("删除失败！！");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	// 批量删除   多条删除 
	public int delUsers(String[] ids){
		String sql = "delete from user where id=?";
			try {
			//  关闭 自动提交事务的功能
				conn.setAutoCommit(false);
				ps = conn.prepareStatement(sql);
				
				for(int i=0;i<ids.length;i++){
					ps.setInt(1, Integer.parseInt(ids[i]));
					ps.addBatch();// 添加批处理
				}
				int[] a = ps.executeBatch(); // 执行批处理操作
				conn.commit(); // 提交事务 
				conn.setAutoCommit(true);
				return a.length;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
	
	
	// 查询user表中有多少条记录
	public int getCount(String name,String tel){
		 int x = 0;
		String sql = "select count(*) from user where name like ? and tel like ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, tel);
			rs = ps.executeQuery();
			
			while(rs.next()){
				x = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	
	// 根据  name   和 tel  分页查询 User
	public List<User> getAllUserByPage(String name,String tel,PageService pageService){
		List<User> list = new ArrayList<User>();
		String sql = "select id,name,pwd,sex,tel,vipgrade,inDate,outDate,room from user where name like ? and tel like ? order by id desc limit ?,?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, tel);
			ps.setInt(3, pageService.getOffset());
			ps.setInt(4, pageService.getPagesize());
			rs = ps.executeQuery();
			while(rs.next()){
				
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setTel(rs.getString(5));
				user.setVipgrade(rs.getString(6));
				user.setInDate(rs.getString(7));
				user.setOutDate(rs.getString(8));
				user.setRoom(rs.getString(9));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	// 注册VIP  
	public void addUser(User user){
		String sql = "insert into user(name,pwd,sex,tel,vipgrade,inDate,outDate,room) values(?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getVipgrade());
			ps.setString(6, user.getInDate());
			ps.setString(7, user.getOutDate());
			ps.setString(8, user.getRoom());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("添加失败！！！");
			e.printStackTrace();
		}
		
		
		
	}
	
	
/**
 *   登陆页面
 *   @author Anonymous
 */
	public User login(String name, String pwd) {
		String sql = "select id,name from user where name=? and pwd=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			User user = new User();
			while(rs.next()){
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
