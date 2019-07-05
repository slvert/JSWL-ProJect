package com.jswl.columntable.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jswl.columntable.bean.ColumntebleBean;
import com.jswl.columntable.bean.UpchannelBean;
import com.jswl.columntable.dao.ColumntableDao;
import com.jswl.zscms.exception.SysException;
import com.jswl.zscms.util.DBUtil;
/**
 * 栏目的Dao层实现类
 * @author Abeni
 *
 */
public class ColumntableDaoImpl implements ColumntableDao {
	//创建DBUtil对象
	DBUtil db=new DBUtil();
	/**
	 * 实现栏目新增的方法
	 */
	public int addColumntable(ColumntebleBean cb) {
		String sql="insert into columntable values(null,?,?,?,?,?)";
		Object[] obj= {cb.getColumnname(),cb.getUpchannel(),cb.getRank(),cb.getIsleaf(),cb.getCorder()};
		//判断返回类型结果
		int result=0;
		try {
			result=db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 实现查询所有栏目的方法
	 */
	public List<ColumntebleBean> queryAllColumn() {
		String sql="select * from columntable";
		//创建List<ColumntebleBean>集合 用于存储 栏目数据
		List<ColumntebleBean> columns=new ArrayList<ColumntebleBean>();
		try {
			List<Map<String, String>> query = db.query(sql, null);
			for (Map<String, String> map : query) {
				//创建ColumntebleBean封装类对象
				ColumntebleBean cb=new ColumntebleBean();
				cb.setId(Integer.parseInt(map.get("id")));
				cb.setColumnname(map.get("columnname"));
				cb.setUpchannel(Integer.parseInt(map.get("upchannel")));
				int upchannel = Integer.parseInt(map.get("upchannel"));
				//通过上级栏目获取的值判断等级
				if (upchannel!=0) {
					cb.setRank(2);
				} else {
					cb.setRank(1);
				}
				//通过上级栏目的值判断是否叶子
				int isleaf=Integer.parseInt(map.get("isleaf"));
				if (upchannel!=0) {
					cb.setIsleafstring("是");
				} else {
					cb.setIsleafstring("否");
				}
				cb.setCorder(Integer.parseInt(map.get("corder")));
				//调用本类根据id查询上级栏目的方法
				//获取栏目id
				int id = Integer.parseInt(map.get("upchannel"));
				if (id!=0) {
					//判断不等于0的时候存入上级栏目的名称
					String upchannelstring = queryAllUpchannel(id);
					cb.setUpchannelstring(upchannelstring);
				} else {
					//否则存入无
					cb.setUpchannelstring("无");
				}
				columns.add(cb);
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columns;
	}
	/**
	 * 实现根据id查询上级栏目的方法
	 */
	public String  queryAllUpchannel(int id){
		String sql="select columnname from columntable where id=?";
		Object[] obj= {id};
		//定义返回结果
		String upchannel=null;
		try {
			//调用查询数据库的方法
			List<Map<String, String>> query = db.query(sql, obj);
			upchannel=query.get(0).get("columnname");
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return upchannel;
		
		}
	
		
	
	/**
	 * 实现根据id删除栏目的方法
	 */
	public int deleteColumnById(int id) {
		//删除栏目的sql语句  条件id
		String sql="DELETE FROM columntable WHERE id=?";
		//数组里获取 传的参 也就是传的id
		Object [] obj= {id};
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
	 * 实现根据id查询栏目的方法
	 */
	public ColumntebleBean queryColumnById(int id) {
		String sql="select * from columntable where id=?";
		Object[] obj= {id};
		//创建List<UpchannelBean>集合 存储栏目数据
		List<ColumntebleBean> upchannelBeans=new ArrayList<ColumntebleBean>();
		//创建ColumntebleBean封装类对象
		ColumntebleBean cb=new ColumntebleBean();
		try {
			List<Map<String, String>> query = db.query(sql, obj);
			for (Map<String, String> map : query) {
				cb.setId(id);
				cb.setColumnname(map.get("columnname"));
				cb.setUpchannel(Integer.parseInt(map.get("upchannel")));
				cb.setRank(Integer.parseInt(map.get("rank")));
				cb.setIsleaf(Integer.parseInt(map.get("isleaf")));
				cb.setCorder(Integer.parseInt(map.get("corder")));
				
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cb;
	}
	/**
	 * 实现根据id修改栏目的方法
	 */
	public int updateColumnById(ColumntebleBean cb) {
		String sql="update columntable set columnname=?, upchannel=?,rank=?,isleaf=?,corder=? where id=?";
		Object[] obj= {cb.getColumnname(),cb.getUpchannel(),cb.getRank(),cb.getIsleaf(),cb.getCorder(),cb.getId()};
		int result=0;
		try {
			result=db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
