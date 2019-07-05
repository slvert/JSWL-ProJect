package com.jswl.columntable.bean;
/**
 * 栏目封装类
 * @author Abeni
 *
 */
public class ColumntebleBean {
	private int id;//栏目编号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String columnname;//栏目名
	private int upchannel;//上级栏目
	private int rank;//级别
	private int isleaf;//是否叶子
	private int corder;//顺序
	private String upchannelstring;//上级栏目字符串型
	private String isleafstring;//是否叶子字符串型
	public String getColumnname() {
		return columnname;
	}
	public void setColumnname(String columntable) {
		this.columnname = columntable;
	}
	public int getUpchannel() {
		return upchannel;
	}
	public void setUpchannel(int upchannel) {
		this.upchannel = upchannel;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getIsleaf() {
		return isleaf;
	}
	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}
	public int getCorder() {
		return corder;
	}
	public void setCorder(int corder) {
		this.corder = corder;
	}
	public String getUpchannelstring() {
		return upchannelstring;
	}
	public void setUpchannelstring(String upchannelstring) {
		this.upchannelstring = upchannelstring;
	}
	public String getIsleafstring() {
		return isleafstring;
	}
	public void setIsleafstring(String isleafstring) {
		this.isleafstring = isleafstring;
	}
}
