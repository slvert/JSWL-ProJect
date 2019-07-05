package com.jswl.fastreport.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jswl.fastreport.bean.FastreportBean;
import com.jswl.fastreport.service.FastreportService;
import com.jswl.zscms.exception.AppException;
/**
 * 查询所有快报的servlet层
 * @author Abeni
 *
 */
@WebServlet("/fastreportquery.do")
public class FastreportQueryAllServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建FastreportService对象
	FastreportService fs=new FastreportService();
	try {
		//调用查询的方法
		List<FastreportBean> queryAllFastreport = fs.queryAllFastreport();
		//创建session对象
		HttpSession session = req.getSession();
		//把queryAllFastreport存入session作用域
		session.setAttribute("fastreports", queryAllFastreport);
		resp.sendRedirect("fastreport/list.jsp");
	} catch (AppException e) {
		resp.sendRedirect("fastreport/list.jsp");
	}
	}
}
