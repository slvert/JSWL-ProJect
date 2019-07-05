package com.jswl.article.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.article.bean.ArticleBean;
import com.jswl.article.service.ArticleService;
import com.jswl.columntable.bean.ColumntebleBean;
import com.jswl.columntable.service.ColumntableService;
import com.jswl.user.bean.DeptBean;
import com.jswl.user.service.UserService;
import com.jswl.zscms.exception.AppException;
/**
 * 根据id查询文章的servelt层
 * @author Abeni
 *
 */
@WebServlet("/getarticlebyid.do")
public class GetAreticleByIdServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面的文章id
	int id=Integer.parseInt(req.getParameter("aid"));
	//创建ArticleService对象
	ArticleService as=new ArticleService();
	//创建ColumntableService对象
	ColumntableService cs=new ColumntableService();
	//调用根据id查询文章的方法
	ArticleBean articles = as.queryArticleById(id);
	List<ColumntebleBean> queryAllColumn = cs.queryAllColumn();
	//将articles加入到请求
	req.setAttribute("ab", articles);
	req.setAttribute("columns", queryAllColumn);
	req.getRequestDispatcher("article/update.jsp").forward(req, resp);
	
	}
}
