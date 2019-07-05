package com.jswl.user.dao;

import java.util.List;
import java.util.Map;

import com.jswl.user.bean.DeptBean;
import com.jswl.user.bean.UserBean;

/**
 * 用户Dao层接口
 * @author Abeni
 *
 */
public interface UserDao {
	/**
	 * 查询部门的方法
	 */
	public List<DeptBean> queryDept();
	/**
	 * 用户新增的方法
	 * @param ub
	 * @return
	 */
	public int insertUser(UserBean ub);
	/**
	 * 使用分页查询用户所有信息的方法
	 * 
	 */
	public List<UserBean> queryAllUser(int m,int n);
	/**
	 * 根据管理员id查询创建者真是名称
	 * @param id
	 * @return
	 */
	public String queryAdminRealnameById(int id);
	/**
	 * 根据id删除用户的方法
	 */
	public int deleteUserById(int id);
	/**
	 * 根据id查询用户的方法
	 * @param id
	 * @return
	 */
	public UserBean queryUserById(int id);
	/**
	 * 根据用户id修改用户信息的方法
	 * @param ub
	 * @return
	 */
	public int updateUserById(UserBean ub);
	/**
	 * 检测用户名重复的方法
	 */
	public List<Map<String, String>> queryUserLoginname(String loginname);
	/**
	 * 检测邮箱重复的方法
	 */
	public List<Map<String, String>> queryUserEmail(String email);
	/**
	 * 统计用户信息总条数
	 * @return
	 */
	public int queryUserConut();
	
	//public List<UserBean> dimQueryUser(String s);
}
