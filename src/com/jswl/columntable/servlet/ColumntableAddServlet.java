package com.jswl.columntable.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.columntable.bean.ColumntebleBean;
import com.jswl.columntable.service.ColumntableService;
import com.jswl.zscms.exception.AppException;
/**
 * 栏目新增servlet层
 * @author Abeni
 *
 */
@WebServlet("/columntableadd.do")
public class ColumntableAddServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建 对象
	ColumntebleBean cb=new ColumntebleBean();
	cb.setColumnname(req.getParameter("columnname"));
	cb.setUpchannel(Integer.parseInt(req.getParameter("upchannel")));
	cb.setCorder(Integer.parseInt(req.getParameter("corder")));
	//创建ColumntableService对象
	ColumntableService cs=new ColumntableService();
	try {
		//调用新增栏目的方法
		cs.addColumntable(cb);
		//重定向到list页面
		resp.sendRedirect("columnqueryall.do");
	} catch (AppException e) {
		resp.sendRedirect("columnqueryall.do");
	}
	
	}
}
