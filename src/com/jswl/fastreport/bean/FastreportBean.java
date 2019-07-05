package com.jswl.fastreport.bean;
/**
 * 快报封装类
 * @author Abeni
 *
 */
public class FastreportBean {
	private int id;//快报编号
	private String title;//快报标题
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getCman() {
		return cman;
	}
	public void setCman(String cman) {
		this.cman = cman;
	}
	private String content;//快报内容
	private String ctime;//快报公告时间
	private String cman;//公告人
}
