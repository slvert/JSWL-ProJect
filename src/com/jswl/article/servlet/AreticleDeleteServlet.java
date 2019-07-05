package com.jswl.article.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.article.service.ArticleService;
import com.jswl.zscms.exception.AppException;
/**
 * 文章删除servlet层
 * @author Abeni
 *
 */
@WebServlet("/areticledelete.do")
public class AreticleDeleteServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//获取页面传过来的id
	int id=Integer.parseInt(req.getParameter("aid"));
	System.out.println(id);
	//创建articleService对象
	ArticleService as=new ArticleService();
	try {
		//调用根据文章id删除文章的方法
		as.deleteArticleById(id);
		//删除成功 重定向到list页面
		resp.sendRedirect("articlequery.do");
	} catch (AppException e) {
		//删除失败 重定向到list页面
		resp.sendRedirect("articlequery.do");
	}
	}
}
