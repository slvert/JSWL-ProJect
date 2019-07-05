package com.jswl.user.service;

import java.util.List;
import java.util.Map;

import com.jswl.user.bean.DeptBean;
import com.jswl.user.bean.UserBean;
import com.jswl.user.dao.UserDao;
import com.jswl.user.dao.impl.UserDaoImpl;
import com.jswl.zscms.exception.AppException;
import com.jswl.zscms.util.DBUtil;

/**
 * 用户service层
 * @author Abeni
 *
 */
public class UserService {
	//上溯造型 创建UserDaoImpl对象
	UserDao uDao=new UserDaoImpl();
	/**
	 * 查询部门的方法
	 * @throws AppException 
	 */
	public List<DeptBean> queryDept() throws AppException{
		//调用查询部门的方法
		List<DeptBean> queryDept = uDao.queryDept();
		if (queryDept.size()==0||queryDept==null) {
			//添加异常信息
			throw new AppException(421, "查询不到部门信息，请联系管理员");
		}
		return queryDept;
	}
	/**
	 * 新增用户的方法
	 * @param ub
	 * @throws AppException 
	 */
	public void insertUser(UserBean ub) throws AppException {
		//调用新增用户的方法
		int result = uDao.insertUser(ub);
		//判断是否新增成功
		if (result==0) {
			//不成功添加异常信息
			throw new AppException(422, "用户新增失败，请联系管理员");
		}
	}
	/**
	 * 查询用户所有信息的方法
	 */
	public List<UserBean> queryAllUser(int m,int n){
		//调取查询全部用户的方法 返回这个方法
		return uDao.queryAllUser(m,n);
	}
	/**
	 * 根据id删除用户的方法
	 * @throws AppException 
	 */
	public int deleteUserById(int id) throws AppException{
		int deleteUserById = uDao.deleteUserById(id);
		if (deleteUserById==0) {
			throw new AppException(424, "用户删除失败，请联系管理员");
		}
		return deleteUserById;
	}
	/**
	 * 根据id查询用户的方法
	 */
	public UserBean queryUserById(int id) {
		//调用根据id查询的方法
		UserBean queryUserById = uDao.queryUserById(id);
		return queryUserById;
	}
	/**
	 * 根据用户id修改用户信息的方法
	 * @throws AppException 
	 */
	public void updateUserById(UserBean ub) throws AppException {
		int updateUserById = uDao.updateUserById(ub);
		if (updateUserById==0) {
			//判断用户修改失败，添加异常信息
			throw new AppException(425, "用户修改失败，请联系管理员");
		}
	}
	/**
	 * 检测用户名重复的方法
	 */
	public int queryUserLoginname(String loginname) {
		List<Map<String, String>> users = uDao.queryUserLoginname(loginname);
		return users.size();
	}
	/**
	 * 检测邮箱重复的方法
	 */
	public int queryUserEmail(String email){
		List<Map<String, String>> queryUserEmail = uDao.queryUserEmail(email);
		return queryUserEmail.size();
	}
	/**
	 * 计算用户总页数的方法
	 * @param n
	 * @return
	 */
	public int queryUserPageCount(int n) {
		//获取用户的总数
		int queryUserConut = uDao.queryUserConut();
		if (queryUserConut%n==0) {
			//如果整除，商就是总页数
			return queryUserConut/n;
		} else {
			//如果不整除 ，商加1
			return queryUserConut/n+1;
		}
	}
}

