package com.jswl.article.bean;
/**
 * 文章封装类
 * @author Abeni
 *
 */
public class ArticleBean {
	private int id;//文章编号
	private String title;//文章标题
	private String content;//文章内容
	private String author;//文章作者
	private String crtime;//创建日期
	private int channel;//所属栏目
	private int isremod;//是否推荐
	private int ishot;//是否热点
	private String isremodString;//是否推荐字符串型
	private String ishotString;//是否热点字符串型
	private String channelstring;//上级栏目名称
	
	
	public String getChannelstring() {
		return channelstring;
	}
	public void setChannelstring(String channelstring) {
		this.channelstring = channelstring;
	}
	public String getIsremodString() {
		return isremodString;
	}
	public void setIsremodString(String isremodString) {
		this.isremodString = isremodString;
	}
	public String getIshotString() {
		return ishotString;
	}
	public void setIshotString(String ishotString) {
		this.ishotString = ishotString;
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCrtime() {
		return crtime;
	}
	public void setCrtime(String crtime) {
		this.crtime = crtime;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getIsremod() {
		return isremod;
	}
	public void setIsremod(int isremod) {
		this.isremod = isremod;
	}
	public int getIshot() {
		return ishot;
	}
	public void setIshot(int ishot) {
		this.ishot = ishot;
	}
}
