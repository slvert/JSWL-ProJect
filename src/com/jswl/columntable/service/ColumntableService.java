package com.jswl.columntable.service;

import java.util.List;

import com.jswl.columntable.bean.ColumntebleBean;
import com.jswl.columntable.bean.UpchannelBean;
import com.jswl.columntable.dao.ColumntableDao;
import com.jswl.columntable.dao.impl.ColumntableDaoImpl;
import com.jswl.zscms.exception.AppException;

/**
 * 栏目的service层
 * @author Abeni
 *
 */
public class ColumntableService {
	//上溯造型 创建栏目实现类对象
	ColumntableDao cDao=new ColumntableDaoImpl();
	/**
	 * 栏目新增的方法
	 * @throws AppException 
	 */
	public int addColumntable(ColumntebleBean cb) throws AppException {
		int addColumntable = cDao.addColumntable(cb);
		if (addColumntable==0) {
			//判断结果为0 说明没有新增成功 添加异常信息
			throw new AppException(710, "新增栏目失败，请联系管理员");
		}
		return addColumntable;
		
	}
	/**
	 * 查询所有栏目的方法
	 */
	public List<ColumntebleBean> queryAllColumn(){
		List<ColumntebleBean> queryAllColumn = cDao.queryAllColumn();
		return queryAllColumn;
	}
	/**
	 * 根据id查询上级栏目的方法
	 */
	public String  queryAllUpchannel(int id) {
		  String queryAllUpchannel = cDao.queryAllUpchannel(id);
		return queryAllUpchannel;
	}
	/**
	 * 根据id删除栏目的方法
	 * @throws AppException 
	 */
	public int deleteColumnById(int id) throws AppException {
		int deleteColumnById = cDao.deleteColumnById(id);
		if (deleteColumnById==0) {
			throw new AppException(712, "栏目删除失败，请联系管理员");
		}
		return deleteColumnById;
	}
	/**
	 * 根据id查询栏目的方法
	 */
	public ColumntebleBean queryColumnById(int id) {
		return cDao.queryColumnById(id);
	}
	/**
	 * 实现根据id修改栏目的方法
	 * @throws AppException 
	 */
	public void updateColumnById(ColumntebleBean cb) throws AppException {
		int updateColumnById = cDao.updateColumnById(cb);
		if (updateColumnById==0) {
			//判断结果为0 说明修改失败 添加异常信息
			throw new AppException(713, "栏目修改失败，请联系管理员");
		}
	}
}
