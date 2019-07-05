package com.jswl.columntable.bean;
/**
 * 上级栏目的封装类
 * @author Abeni
 *
 */
public class UpchannelBean {
	private int id;//上级栏目编号
	private String channelString;//上级栏目名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChannelString() {
		return channelString;
	}
	public void setChannelString(String channelString) {
		this.channelString = channelString;
	}
}
