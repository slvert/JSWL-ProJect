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
 * 根据id修改文章信息的方法
 * @author Abeni
 *
 */
@WebServlet("/articleupdate.do")
public class ArticleUpdateServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//将文章页面要修改的信息 存入封装类
	ArticleBean ab=new ArticleBean();
	ab.setId(Integer.parseInt(req.getParameter("aid")));
	ab.setTitle(req.getParameter("title"));
	ab.setContent(req.getParameter("content"));
	ab.setAuthor(req.getParameter("author"));
	ab.setCrtime(req.getParameter("crtime"));
	ab.setChannel(Integer.parseInt(req.getParameter("channel")));
	ab.setIsremod(Integer.parseInt(req.getParameter("isremod")));
	ab.setIshot(Integer.parseInt(req.getParameter("ishot")));
	//创建ArticleService对象
	ArticleService as=new ArticleService();
	try {
		//调用修改文章的方法
		as.updateArticleById(ab);
		//修改成功 重定向到list页面
		resp.sendRedirect("articlequery.do");
	} catch (AppException e) {
		//修改失败 重定向到list页面
		resp.sendRedirect("articlequery.do");
	}
	}
}
