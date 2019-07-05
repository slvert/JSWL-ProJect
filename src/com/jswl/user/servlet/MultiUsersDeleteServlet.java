package com.jswl.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 多用户一键删除
 * @author Abeni
 *
 */
@WebServlet("/getdata.do")
public class MultiUsersDeleteServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面多用户id
	//String  userid[] =  req.getParameterValues("usersid");
	//String email = req.getParameter("usersid");
	//获取页面信息
	System.out.println("ooooooop");
			String loginname = req.getParameter("loginname");
			String password = req.getParameter("password");
			System.out.println("用户名:"+loginname+"密码:"+password);
			
			/**
			 * 把接收到的数据信息传到数据库查询
			 * 查询到 响应成功的信息
			 */
			resp.setCharacterEncoding("utf-8");
			
			PrintWriter writer = resp.getWriter();
			writer.print("ajax执行成功");
		
	
	}
}
