package com.qdlg.pojo;

public class User {
	private int id;
	private String name;
	private String pwd;
	private String sex;
	private String tel;
	private String vipgrade;
	private String inDate;
	private String outDate;
	private String room;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getVipgrade() {
		return vipgrade;
	}
	public void setVipgrade(String vipgrade) {
		this.vipgrade = vipgrade;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", sex="
				+ sex + ", tel=" + tel + ", vipgrade=" + vipgrade + ", inDate="
				+ inDate + ", outDate=" + outDate + ", room=" + room + "]";
	}
	
}
