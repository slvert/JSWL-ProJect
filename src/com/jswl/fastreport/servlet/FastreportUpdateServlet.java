package com.jswl.fastreport.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.fastreport.bean.FastreportBean;
import com.jswl.fastreport.service.FastreportService;
import com.jswl.zscms.exception.AppException;
/**
 * 快报信息修改servlet层
 * @author Abeni
 *
 */
@WebServlet("/fastreporeupdate.do")
public class FastreportUpdateServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取修改快报页面表单的快报信息
	FastreportBean fb=new FastreportBean();
	fb.setId(Integer.parseInt(req.getParameter("fid")));
	fb.setTitle(req.getParameter("title"));
	fb.setContent(req.getParameter("content"));
	fb.setCtime(req.getParameter("ctime"));
	fb.setCman(req.getParameter("cman"));
	//创建FastreportService对象
	FastreportService fS=new FastreportService();
	//调用修改快报的方法
	try {
		fS.updateFastreportById(fb);
		//修改成功重定向到list页面
		resp.sendRedirect("fastreportquery.do");
	} catch (AppException e) {
		//修改失败重定向到list页面
		resp.sendRedirect("fastreportquery.do");
	}
	}
}
