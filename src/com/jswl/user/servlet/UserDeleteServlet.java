package com.jswl.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.user.service.UserService;
import com.jswl.zscms.exception.AppException;
/**
 * 用户删除的servlet层
 * @author Abeni
 *
 */
@WebServlet("/userdelete.do")
public class UserDeleteServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//获取页面传过来的id
	int id=Integer.parseInt(req.getParameter("id"));
	System.out.println(id);
	//创建userService对象
	UserService us=new UserService();
	try {
		//调用根据用户id删除用户的方法
		us.deleteUserById(id);
		//删除成功 重定向到list页面
		resp.sendRedirect("userquery.do");
	} catch (AppException e) {
		System.out.println(e.getMsg());
		//删除失败 重定向到list页面
		resp.sendRedirect("userquery.do");
	}
	}
}
