package com.jswl.fastreport.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.activation.MailcapCommandMap;

import com.jswl.fastreport.bean.FastreportBean;
import com.jswl.fastreport.dao.FastreportDao;
import com.jswl.zscms.exception.SysException;
/**
 * 快报接口的实现类
 * @author Abeni
 *
 */
import com.jswl.zscms.util.DBUtil;
public class FastreportDaoImpl implements FastreportDao {
	//创建DBUtil对象
	DBUtil db=new DBUtil();
	/**
	 * 实现快报新增的方法
	 */
	public int addFastreport(FastreportBean fb) {
		String sql="insert into tfastreport values(null,?,?,?,?)";
		Object[] obj= {fb.getTitle(),fb.getContent(),fb.getCtime(),fb.getCman()};
		//创建List<FastreportBean>
		//List<FastreportBean> lists=new ArrayList<FastreportBean>();
		//定义一个返回结果
		int result=0;
		try {
			//调用数据库更新的方法
			result=db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 实现查询所有快报的方法
	 */
	public List<FastreportBean> queryAllFastreport() {
		String sql="select * from tfastreport";
		//创建List<FastreportBean> 用于存入快报数据
		List<FastreportBean> fastreports=new ArrayList<FastreportBean>();
		try {
			//调用数据库查询的方法
			List<Map<String, String>> query = db.query(sql, null);
			for (Map<String, String> map : query) {
				//创建FastreportBean封装类对象
				FastreportBean fb=new FastreportBean();
				fb.setId(Integer.parseInt(map.get("id")));
				fb.setTitle(map.get("title"));
				fb.setContent(map.get("content"));
				fb.setCtime(map.get("ctime"));
				fb.setCman(map.get("cman"));
				//把fb添加入list集合
				fastreports.add(fb);
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fastreports;
	}
	/**
	 * 实现根据id删除快报的方法
	 */
	public int deleteFastreportById(int id) {
		String sql="DELETE FROM tfastreport WHERE id=?";
		Object[] obj= {id};
		//判断返回类型结果
		int resule=0;
		try {
			resule=db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resule;
	}
	/**
	 * 实现根据快报id查询快报信息的方法
	 */
	public FastreportBean queryFastreportById(int id) {
		String sql="select * from tfastreport where id=?";
		Object[] obj= {id};
		//创建FastreportBean封装类对象
		FastreportBean fb=new FastreportBean();
		try {
			//调用查询数据库的方法
			List<Map<String, String>> query = db.query(sql, obj);
			for (Map<String, String> map : query) {
				fb.setId(id);
				fb.setTitle(map.get("title"));
				fb.setContent(map.get("content"));
				fb.setCtime(map.get("ctime"));
				fb.setCman(map.get("cman"));
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fb;
	}
	/**
	 * 实现根据快报id修改快报的方法
	 */
	public int updateFastreportById(FastreportBean fb) {
		String sql="update tfastreport set title=?,content=?,ctime=?,cman=? where id=?";
		Object[] obj= {fb.getTitle(),fb.getContent(),fb.getCtime(),fb.getCman(),fb.getId()};
		//定义返回结果
		int result=0;
		try {
			//调用更新数据库的方法
			result=db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
