package com.jswl.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.user.bean.DeptBean;
import com.jswl.user.service.UserService;
import com.jswl.zscms.exception.AppException;
/**
 * 部门信息的DeptServlet层 用于获取部门信息 然后去JSP页面展示部门信息
 * @author Abeni
 *
 */
@WebServlet("/dept.do")
public class DeptInitServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//创建UserService对象
	UserService userService=new UserService();
	
	try {
		//调用queryDept方法
		List<DeptBean> depts = userService.queryDept();
		//将参数信息放到请求中
		req.setAttribute("depts", depts);
		//携带参数转发到页面
		req.getRequestDispatcher("user/add.jsp").forward(req, resp);
		//resp.sendRedirect("user/add.jsp");
	} catch (AppException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
