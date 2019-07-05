package com.jswl.admin.dao;

import java.util.List;

import com.jswl.admin.bean.AdminBean;

/**
 * 管理员Dao层接口
 * @author Abeni
 *
 */
public interface AdminDao {
	//查询管理员登录名和密码的方法
	public List<AdminBean> chkLogin(AdminBean ab);
}
