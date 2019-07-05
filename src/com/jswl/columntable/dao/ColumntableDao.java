package com.jswl.columntable.dao;

import java.util.List;

import com.jswl.article.bean.ArticleBean;
import com.jswl.columntable.bean.ColumntebleBean;
import com.jswl.columntable.bean.UpchannelBean;

/**
 * 栏目Dao层
 * @author Abeni
 *
 */
public interface ColumntableDao {
	/**
	 * 新增栏目的方法
	 * @param cb
	 * @return
	 */
	public int addColumntable(ColumntebleBean cb);
	/**
	 * 查询所有栏目的方法
	 * @return
	 */
	public List<ColumntebleBean> queryAllColumn();
	/**
	 * 根据id获取上级栏目的方法
	 * @return
	 */
	public String  queryAllUpchannel(int id);
	/**
	 * 根据id删除栏目的方法
	 * @param id
	 * @return
	 */
	public int deleteColumnById(int id);
	/**
	 * 根据id查询栏目的方法
	 * @param id
	 * @return
	 */
	public ColumntebleBean queryColumnById(int id);
	/**
	 * 根据id修改栏目的方法
	 * @param cb
	 * @return
	 */
	public int updateColumnById(ColumntebleBean cb);
}
