package com.jswl.article.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jswl.article.bean.ArticleBean;
import com.jswl.article.dao.ArticleDao;
import com.jswl.zscms.exception.SysException;
import com.jswl.zscms.util.DBUtil;
/**
 * 文章的接口实现类
 * @author Abeni
 *
 */
public class ArticleDaoImpl implements ArticleDao {
	//创建文章封装类对象
	//创建DBUtil类对象
	DBUtil db=new DBUtil();
	/**
	 * 实现文章新增的方法
	 */
	public int  addArticle(ArticleBean arb) {
		String sql="INSERT INTO tarticle VALUES(NULL,?,?,?,?,?,?,?)";
		Object[] obj= {arb.getTitle(),arb.getContent(),arb.getAuthor(),arb.getCrtime(),arb.getChannel(),arb.getIsremod(),arb.getIshot()};
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
	 * 实现查询所有文章的方法
	 */
	public List<ArticleBean> queryAllArticle(int m,int n) {
		String sql="select t.*,co.columnname from tarticle t left join columntable co on t.channel=co.id limit ?,?";
		Object[] obj= {m,n};
		//创建List<ArticleBean> 用于存入文章数据
		List<ArticleBean> articles=new ArrayList<ArticleBean>();
		//调用查询数据库的方法
		try {
			List<Map<String, String>> query = db.query(sql, obj);
			for (Map<String, String> map : query) {
				//创建ArticleBean对象
				ArticleBean aBean=new ArticleBean();
				aBean.setId(Integer.parseInt(map.get("id")));
				aBean.setTitle(map.get("title"));
				aBean.setContent(map.get("content"));
				aBean.setAuthor(map.get("author"));
				aBean.setCrtime(map.get("crtime"));
				aBean.setChannel(Integer.parseInt(map.get("channel")));
				aBean.setIsremod(Integer.parseInt(map.get("isremod")));
				aBean.setIshot(Integer.parseInt(map.get("ishot")));
				aBean.setChannelstring(map.get("columnname"));
				//判断是否推荐
				int isremod=Integer.parseInt(map.get("isremod"));
				if (isremod==1) {
					//结果为1说明是推荐
					aBean.setIsremodString("是");
				} else {
					aBean.setIsremodString("否");
				}
				//判断是否热点
				int ishot=Integer.parseInt(map.get("ishot"));
				if (ishot==1) {
					//结果为1说明是热点
					aBean.setIshotString("是");
				} else {
					aBean.setIshotString("否");
				}
				//把abean添加入list集合
				articles.add(aBean);
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
	/**
	 * 实现根据文章id删除文章的方法
	 */
	public int deleteArticleById(int id) {
		//删除文章的sql语句  条件id
		String sql="DELETE FROM tarticle WHERE id=?";
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
	 * 实现根据id查询文章的方法
	 */
	public ArticleBean queryArticleById(int id) {
		String sql="select * from tarticle where id=?";
		Object[] obj= {id};
		//创建List<ArticleBean> 集合用于存储文章数据
		List<ArticleBean> articles=new ArrayList<ArticleBean>();
		//创建ArticleBean对象
		ArticleBean aBean=new ArticleBean();
		try {
			//调用查询数据库的方法
			List<Map<String, String>> query = db.query(sql, obj);
			for (Map<String, String> map : query) {
				aBean.setId(id);
				aBean.setTitle(map.get("title"));
				aBean.setContent(map.get("content"));
				aBean.setAuthor(map.get("author"));
				aBean.setCrtime(map.get("crtime"));
				aBean.setChannel(Integer.parseInt(map.get("channel")));
				aBean.setIsremod(Integer.parseInt(map.get("isremod")));
				aBean.setIshot(Integer.parseInt(map.get("ishot")));
				
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aBean;
	}
	/**
	 * 实现根据id修改文章的方法
	 */
	public int updateArticleById(ArticleBean ab) {
		String sql="update tarticle set title=?, content=?,author=?,crtime=?,channel=?,isremod=?,ishot=? where id=?";
		Object[] obj= {ab.getTitle(),ab.getContent(),ab.getAuthor(),ab.getCrtime(),ab.getChannel(),ab.getIsremod(),ab.getIshot(),ab.getId()};
		//定义返回结果
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
	 * 实现统计用户信息总条数
	 */
	public int queryArticleConut() {
		String sql="select count(id) from tarticle";
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
