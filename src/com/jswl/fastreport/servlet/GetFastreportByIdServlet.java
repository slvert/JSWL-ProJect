package com.jswl.fastreport.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.fastreport.bean.FastreportBean;
import com.jswl.fastreport.service.FastreportService;
/**
 * 根据快报id查询快报信息的servlet层
 * @author Abeni
 *
 */
@WebServlet("/getfastreportbyid.do")
public class GetFastreportByIdServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面要修改的快报id
	int id=Integer.parseInt(req.getParameter("fid"));
	//创建FastreportService
	FastreportService fs=new FastreportService();
	//调用根据快报id查询快报信息的方法
	FastreportBean fastreports = fs.queryFastreportById(id);
	//将fastreports添加人请求
	req.setAttribute("fb", fastreports);
	//转发到更新页面
	req.getRequestDispatcher("fastreport/update.jsp").forward(req, resp);
	}
}
