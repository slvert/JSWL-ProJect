package com.jswl.columntable.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jswl.columntable.bean.ColumntebleBean;
import com.jswl.columntable.bean.UpchannelBean;
import com.jswl.columntable.service.ColumntableService;
/**
 * 上级栏目查询
 * @author Abeni
 *
 */
@WebServlet("/upchannelquery.do")
public class UpchannelQueryServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//创建ColumntableService对象
	ColumntableService cs=new ColumntableService();
	//调用查询所有栏目信息的方法
	List<ColumntebleBean> queryAllColumn = cs.queryAllColumn();
	//创建session作用域对象
		HttpSession session = req.getSession();
	//将queryAllColumn添加到session作用域
		session.setAttribute("columns", queryAllColumn);
		//重定向到list页面
		resp.sendRedirect("column/add.jsp");
		
	}
}
