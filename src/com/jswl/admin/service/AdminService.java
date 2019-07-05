package com.jswl.admin.service;

import java.util.List;

import com.jswl.admin.bean.AdminBean;
import com.jswl.admin.dao.AdminDao;
import com.jswl.admin.dao.impl.AdminDaoImpl;
import com.jswl.zscms.exception.AppException;

/**
 * 管理员service层
 * @author Abeni
 *
 */
public class AdminService {
	/**
	 * 检测用户名和密码的方法
	 * @throws AppException 
	 */
	public AdminBean chklogin(AdminBean ab) throws AppException {
		//上溯造型 创建对象
		AdminDao adminDao= new AdminDaoImpl();
		//调用查询登录名和密码的方法
		List<AdminBean> chkLogin = adminDao.chkLogin(ab);
		//判断集合是否为空
		if (chkLogin.size()==0||chkLogin==null) {
			//登录失败报异常
			throw new AppException(420, "用户名或密码错误");
		}
		//如果不为空返回List<AdminBean>里的第一位数据
		return chkLogin.get(0);
		
	}
}
