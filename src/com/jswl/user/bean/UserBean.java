package com.jswl.user.bean;
/**
 * 用户信息封装类
 * @author Abeni
 *
 */
public class UserBean {
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getDep() {
		return dep;
	}
	public void setDep(int dep) {
		this.dep = dep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getCretman() {
		return cretman;
	}
	public void setCretman(int cretman) {
		this.cretman = cretman;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getCretmanrealname() {
		return cretmanrealname;
	}
	public void setCretmanrealname(String cretmanrealname) {
		this.cretmanrealname = cretmanrealname;
	}
	public String getEnabledtext() {
		return enabledtext;
	}
	public void setEnabledtext(String enabledtext) {
		this.enabledtext = enabledtext;
	}
	private int id;//用户编号
	private String loginname;//用户名
	private String password;//用户密码
	private String realname;//真实姓名
	private String sex;//性别
	private String birthday;//生日
	private int dep;//部门编号
	private String email;//邮箱
	private int enabled;//是否可用
	private int cretman;//管理员编号
	private String dname;//部门名称
	private String cretmanrealname;//创建者真实名称
	private String enabledtext;//是否可用文本格式
	
}
