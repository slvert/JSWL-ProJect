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
 * 快报的servlet层
 * @author Abeni
 *
 */
@WebServlet("/fastreportadd.do")
public class FastreportAddServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//设置请求编码的规则  需要的规则
	//req.setCharacterEncoding("utf-8");
	//resp.setCharacterEncoding("utf-8");
	//接收快报页面新增的表单信息
	String title=req.getParameter("title");
	String content=req.getParameter("content");
	String ctime=req.getParameter("ctime");
	String cman=req.getParameter("cman");
	//创建FastreportBean 快报封装类对象 把页面表单数据存入封装类
	FastreportBean fb=new FastreportBean();
	fb.setTitle(title);
	fb.setContent(content);
	fb.setCtime(ctime);
	fb.setCman(cman);
	//创建FastreportService 对象
	FastreportService fs=new FastreportService();
	try {
		//调用快报新增的方法
		fs.addFastreport(fb);
		//新增成功重定向到list页面
		resp.sendRedirect("fastreportquery.do");
	} catch (AppException e) {
		//新增失败重定向到list页面
		resp.sendRedirect("fastreportquery.do");
	}
	}
}
