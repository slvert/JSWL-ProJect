package com.jswl.fastreport.dao;

import java.util.List;

import com.jswl.fastreport.bean.FastreportBean;
import com.jswl.user.bean.UserBean;

/**
 * 快报的接口类
 * @author Abeni
 *
 */
public interface FastreportDao {
	/**
	 * 快报新增的方法
	 * @return
	 */
	public int addFastreport(FastreportBean fb);
	/**
	 * 查询所有快报的方法
	 * @return
	 */
	public List<FastreportBean> queryAllFastreport();
	/**
	 * 根据id删除快报的方法
	 * @param id
	 * @return
	 */
	public int deleteFastreportById(int id);
	/**
	 * 根据id查询快报的方法
	 * @param id
	 * @return
	 */
	public FastreportBean queryFastreportById(int id);
	/**
	 * 根据快报id修改快报信息的方法
	 * @param fb
	 * @return
	 */
	public int updateFastreportById(FastreportBean fb);
}
