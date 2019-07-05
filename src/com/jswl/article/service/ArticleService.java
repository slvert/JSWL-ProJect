package com.jswl.article.service;

import java.util.List;

import com.jswl.article.bean.ArticleBean;
import com.jswl.article.dao.ArticleDao;
import com.jswl.article.dao.impl.ArticleDaoImpl;
import com.jswl.zscms.exception.AppException;

/**
 * 文章的service层
 * @author Abeni
 *
 */
public class ArticleService {
	//上溯造型 创建ArticleDaoImpl对象
	ArticleDao aDao=new ArticleDaoImpl();
	/**
	 * 文章新增方法
	 * @param arb
	 * @return
	 * @throws AppException 
	 */
	public int  addArticle(ArticleBean arb) throws AppException {
		//调用实现文章新增的方法
		int addArticle = aDao.addArticle(arb);
		//判断是否新增成功
		if (addArticle==0) {
			//未新增成功 添加异常信息
			throw new AppException(510, "文章新增失败，请联系管理员");
		}
		return addArticle;
	}
	/**
	 * 查询所有文章的方法
	 */
	public List<ArticleBean> queryAllArticle(int m,int n){
		//调取查询所有文章的方法 返回这个方法
		return aDao.queryAllArticle(m,n);
	}
	/**
	 * 根据文章id删除文章的方法
	 * @throws AppException 
	 */
	public int deleteArticleById(int id) throws AppException {
		int deleteArticleById = aDao.deleteArticleById(id);
		if (deleteArticleById==0) {
			throw new AppException(512, "文章删除失败，请联系管理员");
		}
		return deleteArticleById;
	}
	/**
	 * 根据id查询文章的方法
	 */
	public ArticleBean queryArticleById(int id) {
		ArticleBean queryArticleById = aDao.queryArticleById(id);
		return queryArticleById;
	}
	/**
	 * 实现根据id修改文章的方法
	 * @throws AppException 
	 */
	public void updateArticleById(ArticleBean ab) throws AppException {
		int updateArticleById = aDao.updateArticleById(ab);
		if (updateArticleById==0) {
			//判断如果结果为0 表示修改失败 添加异常信息
			throw new AppException(513, "文章修改失败，请联系管理员");
		}
	}
	/**
	 * 计算文章总页数的方法
	 * @param n
	 * @return
	 */
	public int queryArticlePageCount(int n) {
		//获取文章的总数
		int queryArticleConut = aDao.queryArticleConut();
		if (queryArticleConut%n==0) {
			//如果整除，商就是总页数
			return queryArticleConut/n;
		} else {
			//如果不整除 ，商加1
			return queryArticleConut/n+1;
		}
	}
}
