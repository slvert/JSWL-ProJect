package com.jswl.fastreport.service;

import java.util.List;

import com.jswl.fastreport.bean.FastreportBean;
import com.jswl.fastreport.dao.FastreportDao;
import com.jswl.fastreport.dao.impl.FastreportDaoImpl;
import com.jswl.zscms.exception.AppException;

/**
 * 快报service层
 * @author Abeni
 *
 */
public class FastreportService {
	//上溯造型 创建FastreportDaoImpl对象
	FastreportDao fDao=new FastreportDaoImpl();
	/**
	 * 快报新增的方法
	 * @throws AppException 
	 */
	public int addFastreport(FastreportBean fb) throws AppException {
		//调用新增的方法
		int addFastreport = fDao.addFastreport(fb);
		if (addFastreport==0) {
			//新增失败 添加异常信息
			throw new AppException(610, "新增失败，请联系管理员");
		}
		return addFastreport;
		
	}
	/**
	 * 查询所有快报的方法
	 * @throws AppException 
	 */
	public List<FastreportBean> queryAllFastreport() throws AppException{
		List<FastreportBean> queryAllFastreport = fDao.queryAllFastreport();
		if (queryAllFastreport.size()==0) {
			//等于零说明没有查到数据
			throw new AppException(611, "没有查询到数据，请联系管理员");
		}
		return queryAllFastreport;
		
	}
	/**
	 * 根据id删除快报的方法
	 * @param id
	 * @return
	 * @throws AppException 
	 */
	public int deleteFastreportById(int id) throws AppException {
		int deleteFastreportById = fDao.deleteFastreportById(id);
		if (deleteFastreportById==0) {
			//等于零说明删除失败 添加异常信息
			throw new AppException(612, "删除快报失败,请联系管理员");
		}
		return deleteFastreportById;
	}
	/**
	 * 根据快报id查询快报信息的方法
	 */
	public FastreportBean queryFastreportById(int id) {
		FastreportBean queryFastreportById = fDao.queryFastreportById(id);
		return queryFastreportById;
	}
	/**
	 * 根据快报id修改快报的方法
	 * @throws AppException 
	 */
	public int updateFastreportById(FastreportBean fb) throws AppException {
		int updateFastreportById = fDao.updateFastreportById(fb);
		if (updateFastreportById==0) {
			//获取0说明修改失败 添加异常信息
			throw new AppException(613, "快报修改失败，请联系管理员");
		}
		return updateFastreportById;
	}
}
