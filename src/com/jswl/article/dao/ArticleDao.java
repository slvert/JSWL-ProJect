package com.jswl.article.dao;
/**
 * 文章Dao层接口
 * @author Abeni
 *
 */

import java.util.List;

import com.jswl.article.bean.ArticleBean;

public interface ArticleDao {
	/**
	 * 新增文章的方法
	 * @param ab
	 * @return
	 */
	public int addArticle(ArticleBean arb);
	/**
	 * 使用分页查询所有文章的方法
	 * @return
	 */
	public List<ArticleBean> queryAllArticle(int m,int n);
	/**
	 * 根据id删除文章的方法
	 * @param id
	 * @return
	 */
	public int deleteArticleById(int id);
	/**
	 * 根据id查询文章的方法
	 * @param id
	 * @return
	 */
	public ArticleBean queryArticleById(int id);
	/**
	 * 根据id修改文章的方法
	 * @param ab
	 * @return
	 */
	public int updateArticleById(ArticleBean ab);
	/**
	 * 统计文章信息总条数
	 * @return
	 */
	public int queryArticleConut();
}