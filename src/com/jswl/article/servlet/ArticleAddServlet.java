package com.jswl.article.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.article.bean.ArticleBean;
import com.jswl.article.service.ArticleService;
import com.jswl.zscms.exception.AppException;
/**
 * 文章新增servlet类
 * @author Abeni
 *
 */
@WebServlet("/articleadd.do")
public class ArticleAddServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//设置请求编码的规则  需要的规则
	//req.setCharacterEncoding("utf-8");
	//resp.setCharacterEncoding("utf-8");
		//接收页面新增文章信息
	String title = req.getParameter("title");//接收文章标题
	String content = req.getParameter("content");//接收文章内容
	String author = req.getParameter("author");//接收文章作者
	String crtime = req.getParameter("crtime");//接收添加时间
	String channel = req.getParameter("channel");//接收所属栏目
	String isremod = req.getParameter("isremod");//接收是否推荐
	String ishot = req.getParameter("ishot");//接收是否热点
	//创建ArticleBean封装类对象
	ArticleBean ab=new ArticleBean();
	//把页面信息存入ArticleBean封装类
	ab.setTitle(title);
	ab.setContent(content);
	ab.setAuthor(author);
	ab.setCrtime(crtime);
	ab.setChannel(Integer.parseInt(channel));
	ab.setIsremod(Integer.parseInt(isremod));
	ab.setIshot(Integer.parseInt(ishot));
	//创建ArticleService对象
	ArticleService as=new ArticleService();
	
	try {
		//调用文章新增方法 把ab存入数据库
		as.addArticle(ab);
		//新增成功重定向到list页面
		resp.sendRedirect("articlequery.do");
	} catch (AppException e) {
		//新增失败重定向到list页面
		resp.sendRedirect("articlequery.do");
	
	}
}
}
