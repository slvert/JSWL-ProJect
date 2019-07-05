package com.jswl.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.user.bean.UserBean;
import com.jswl.user.service.UserService;
import com.jswl.zscms.exception.AppException;


/**
 * 用户信息修改的servlet层
 * @author Abeni
 *
 */
@WebServlet("/updateuser.do")
public class UpdateUserServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //获取修改用户信息的表单所有信息，将信息封装进UserBean中
	UserBean ub=new UserBean();
	ub.setId(Integer.parseInt(req.getParameter("id")));
	ub.setLoginname(req.getParameter("loginname"));
	ub.setPassword(req.getParameter("pwd1"));
	ub.setRealname(req.getParameter("realname"));
	ub.setSex(req.getParameter("sex"));
	ub.setBirthday(req.getParameter("birthday"));
	ub.setEnabled(Integer.parseInt(req.getParameter("enabled")));
	ub.setDep(Integer.parseInt(req.getParameter("dep")));
	ub.setEmail(req.getParameter("email"));
	//创建UserService对象 调用修改用户的方法
	UserService us=new UserService();
	try {
		//调用修改用户信息的方法
		us.updateUserById(ub);
		//修改成功 重定向到list页面
		resp.sendRedirect("userquery.do");
	} catch (AppException e) {
		//修改失败 重定向到list页面
		resp.sendRedirect("userquery.do");
	}
	}
}
