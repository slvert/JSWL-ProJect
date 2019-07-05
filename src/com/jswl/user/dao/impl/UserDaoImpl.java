package com.jswl.user.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jswl.user.bean.DeptBean;
import com.jswl.user.bean.UserBean;
import com.jswl.user.dao.UserDao;
import com.jswl.zscms.exception.SysException;
import com.jswl.zscms.util.DBUtil;

import sun.text.normalizer.UBiDiProps;
/**
 * UserDao层的接口实现类
 * @author Abeni
 *
 */
public class UserDaoImpl implements UserDao {
	//创建DBUtil对象
	DBUtil db=new DBUtil();
	/**
	 * 实现查询部门的方法
	 * 查询部门的sql语句
	 */
	@Override
	public List<DeptBean> queryDept() {
		//查询部门的sql语句
		String sql="select * from tdept";
		//创建List<DeptBean> 集合 存储部门数据
		List<DeptBean> deptBeans=new ArrayList<DeptBean>();
		//调用数据库查询的方法 然后map to bean
		try {
			List<Map<String, String>> query = db.query(sql, null);
			for (Map<String, String> map : query) {
				//创建DeptBean对象
				DeptBean deptBean=new DeptBean();
				deptBean.setId(Integer.parseInt(map.get("id")));
				deptBean.setDname(map.get("dname"));
				//deptBean 添加到List<DeptBean>集合
				deptBeans.add(deptBean);
			}
			
			
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptBeans;
	}
	/**
	 * 实现新增用户的方法
	 */
	@Override
	public int insertUser(UserBean ub) {
		//新增玩家的sql语句 ?表示占位符 null属于主键自增
		String sql="INSERT INTO user VALUES(NULL,?,?,?,?,?,?,?,?,?)";
		//object 数组 存入封装类的数据 要与列名一一对应 null不写
		Object [] obj= {ub.getLoginname(),ub.getPassword(),ub.getRealname(),ub.getSex(),ub.getBirthday(),ub.getDep(),ub.getEmail(),ub.getEnabled(),ub.getCretman()};
	
		//判断返回类型结果
		int result=0;
		
		try {
			//调用DBUtil的更新方法 result接收
			result = db.update(sql, obj);
		} catch (SysException e) {
			System.out.println(e.getMsg());
		}
		//如果result=1表示成功
		return result;
	}
	/**
	 * 查询用户所有信息的方法
	 */
	public List<UserBean> queryAllUser(int m,int n){
		String sql="select u.*,d.dname from user u left join tdept d on u.dep=d.id limit ?,?";
		Object[] obj= {m,n};
		//创建list集合 存储查询的数据
		List<UserBean> users=new ArrayList<UserBean>();
		try {
			//调用数据库查询的方法
			List<Map<String, String>> lists = db.query(sql, obj);
			//map--to--bean
			for (Map<String, String> map : lists) {
			//创建userBean对象
			UserBean uBean=new UserBean();
			uBean.setId(Integer.parseInt(map.get("id")));
			uBean.setLoginname(map.get("loginname"));
			uBean.setPassword(map.get("password"));
			uBean.setSex(map.get("sex"));
			uBean.setRealname(map.get("realname"));
			uBean.setBirthday(map.get("birthday"));
			uBean.setEmail(map.get("email"));
			//添加部门名称 UserBean里没有需要添加 dname
			uBean.setDname(map.get("dname"));
			
			//判断是否可用
			int endabled=Integer.parseInt(map.get("enabled"));
			
			if (endabled==1) {
				uBean.setEnabledtext("是");
			} else {
				uBean.setEnabledtext("否");
			}
			//创建者的id
			int id=Integer.parseInt(map.get("cretman"));
			//调用查询管理员真是名称的方法
			String realname = queryAdminRealnameById(id);
			uBean.setCretmanrealname(realname);
			//将对象添加进集合
			users.add(uBean);
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * 根据管理员id查询创建者真是名称
	 * @param id
	 * @return
	 */
	public String queryAdminRealnameById(int id) {
		 String sql="select realname from admin where id=?";
		 Object[] obj= {id};
		 String realname=null;
		 try {
			 //调用数据库查询的方法
			List<Map<String, String>> lists = db.query(sql, obj);
			realname= lists.get(0).get("realname");
			
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return realname;
		 
	 }
	/**
	 * 根据id删除用户的方法
	 */
	public int deleteUserById(int id) {
		//删除用户的sql语句  条件id
		String sql="DELETE FROM user WHERE id=?";
		//数组里获取 传的参 也就是传的id
		Object [] obj= {id};
		//判断返回类型结果
		int resule=0;
		try {
			resule = db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resule;
	}
	/**
	 * 实现根据id查询用户的方法
	 */
	public UserBean queryUserById(int id) {
		String sql="select * from user where id=?";
		Object[] obj= {id};
		//创建userBean对象
		UserBean ub=new UserBean();
		try {
			//调用数据库查询的方法
			List<Map<String, String>> query = db.query(sql, obj);
			Map<String, String> map = query.get(0);
			ub.setId(id);
			ub.setLoginname(map.get("loginname"));
			ub.setPassword(map.get("password"));
			ub.setRealname(map.get("realname"));
			ub.setSex(map.get("sex"));
			ub.setBirthday(map.get("birthday"));
			ub.setEmail(map.get("email"));
			ub.setDep(Integer.parseInt(map.get("dep")));
			ub.setEnabled(Integer.parseInt(map.get("enabled")));
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ub;
	}
	/**
	 * 实现根据用户id修改用户信息的方法
	 */
	public int updateUserById(UserBean ub) {
		String sql="update user set loginname=?,password=?,realname=?,sex=?,birthday=?,enabled=?,dep=?,email=? where id=?";
		Object[] obj= {ub.getLoginname(),ub.getPassword(),ub.getRealname(),ub.getSex(),ub.getBirthday(),ub.getEnabled(),ub.getDep(),ub.getEmail(),ub.getId()};
		//定义返回结果
		int result=0;
		try {
			//调用数据库修改的方法
			result=db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 实现检测用户名重复的方法
	 */
	public List<Map<String, String>> queryUserLoginname(String loginname) {
		String sql="select * from user where loginname=?";
		Object[] obj= {loginname};
		List<Map<String, String>> query=null;
		try {
			 query = db.query(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}
	/**
	 * 实现检测邮箱重复的方法
	 */
	public List<Map<String, String>> queryUserEmail(String email) {
		String sql="select * from user where email=?";
		Object[] obj= {email};
		List<Map<String, String>> query=null;
		try {
			query=db.query(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}
	/**
	 * 实现统计用户信息总条数
	 */
	public int queryUserConut() {
		String sql="select count(id) from user";
		List<Map<String, String>> query=null;
		try {
			query = db.query(sql, null);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.parseInt(query.get(0).get("count(id)"));
	}
}
