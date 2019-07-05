package com.jswl.article.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jswl.article.bean.ArticleBean;
import com.jswl.article.service.ArticleService;
/**
 * 查询所有文章的servlet层
 * @author Abeni
 *
 */
@WebServlet("/articlequery.do")
public class ArticleQueryServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建articleService对象
	ArticleService as=new ArticleService();
	//定义每页显示的行数
	int n=3;
	//获取当前的页数
		String page = req.getParameter("page");
		//定义当前的页面
		int k;
		//如果获得当前页面page为null,那说明位于首页 将k赋值为1
		if (page==null) {
			k=1;
		}else {
			//如果获取了当前页面，那么将当前页面赋值给k
			k=Integer.parseInt(page);
		}
		//定义m 为sql语句中的起始行数
		int m=(k-1)*n;
	//调取查询所有文章的方法
	List<ArticleBean> queryAllArticle = as.queryAllArticle(m,n);
	//调用统计文章总页数的方法
	int queryArticlePageCount = as.queryArticlePageCount(n);
	//创建session对象
	HttpSession session = req.getSession();
	//把queryAllArticle存入session作用域
	session.setAttribute("articles", queryAllArticle);
	//将文章总页数存入session作用域
	session.setAttribute("pagecount", queryArticlePageCount);
	//将当前页面存入session作用域
	session.setAttribute("page", k);
	resp.sendRedirect("article/list.jsp");
	}
}
