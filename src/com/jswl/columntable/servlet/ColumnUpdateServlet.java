package com.jswl.columntable.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.columntable.bean.ColumntebleBean;
import com.jswl.columntable.service.ColumntableService;
import com.jswl.zscms.exception.AppException;
/**
 * 根据id修改栏目信息servlet层
 * @author Abeni
 *
 */
@WebServlet("/columnupdate.do")
public class ColumnUpdateServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取栏目页面要修改的信息 存入封装类
	ColumntebleBean cb=new ColumntebleBean();
	cb.setId(Integer.parseInt(req.getParameter("cid")));
	cb.setColumnname(req.getParameter("columnname"));
	cb.setUpchannel(Integer.parseInt(req.getParameter("upchannel")));
	cb.setCorder(Integer.parseInt(req.getParameter("corder")));
	//创建ColumntableService对象
	ColumntableService cs=new ColumntableService();
	try {
		//调用修改栏目的方法
		cs.updateColumnById(cb);
		resp.sendRedirect("columnqueryall.do");
	} catch (AppException e) {
		resp.sendRedirect("columnqueryall.do");
	}
	}
}
