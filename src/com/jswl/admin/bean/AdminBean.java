package com.jswl.admin.bean;
/**
 * 管理员封装类
 * @author Abeni
 *
 */
public class AdminBean {
	private int id;//ID
	private String loginname;//管理员登录账号
	private String password;//管理员登录密码
	private String realname;//管理员昵称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
}
