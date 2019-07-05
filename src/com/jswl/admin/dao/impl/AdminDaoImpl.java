package com.jswl.admin.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jswl.admin.bean.AdminBean;
import com.jswl.admin.dao.AdminDao;
import com.jswl.zscms.exception.SysException;
import com.jswl.zscms.util.DBUtil;
/**
 * AdminDao层的接口实现
 * @author Abeni
 *
 */
public class AdminDaoImpl implements AdminDao {
	//创建DBUtil对象
	DBUtil db=new DBUtil();
	/**
	 * 实现查询管理员登录名和密码的方法
	 * 从数据库获取用户名和密码
	 */
	@Override
	public List<AdminBean> chkLogin(AdminBean ab) {
		
		/**
		 * 1.用SQL语句查询，给占位符赋值
		 * 2.调用DBUtil的查询方法
		 * 3.用集合接收查询的结果
		 */
		String sql="select * from admin where loginname=? and password=?";
		//给占位符赋值
		Object [] obj= {ab.getLoginname(),ab.getPassword()};
		//创建Lise集合
		List<AdminBean> adminBeans=new ArrayList<AdminBean>();
		//调用数据库查询的方法,集合接收查询结果
		try {
			List<Map<String, String>> admins = db.query(sql, obj);
			for (Map<String, String> map : admins) {
				//创建AdminBean对象
				AdminBean aBean=new AdminBean();
				aBean.setId(Integer.parseInt(map.get("id")) );
				aBean.setLoginname(map.get("loginname"));
				aBean.setPassword(map.get("password"));
				aBean.setRealname(map.get("realname"));
				adminBeans.add(aBean);
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminBeans;
	}

}
