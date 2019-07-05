package com.jswl.fastreport.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.fastreport.service.FastreportService;
import com.jswl.zscms.exception.AppException;
/**
 * 快报删除servlet层
 * @author Abeni
 *
 */
@WebServlet("/fastreportdelete.do")
public class FastreportDeleteServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面要删除的快报id
		int id=Integer.parseInt(req.getParameter("fid"));
		//创建
		FastreportService fs=new FastreportService();
		try {
			//调用根据id删除快报的方法
			fs.deleteFastreportById(id);
			//删除成功 重定向到list页面
			resp.sendRedirect("fastreportquery.do");
		} catch (AppException e) {
			//删除失败 重定向到list页面
			resp.sendRedirect("fastreportquery.do");
		}
	}
}
