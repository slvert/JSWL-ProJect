package com.jswl.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.user.bean.DeptBean;
import com.jswl.user.bean.UserBean;
import com.jswl.user.service.UserService;
import com.jswl.zscms.exception.AppException;
/**
 * 根据用户id查询用户的方法
 * @author Abeni
 *
 */
@WebServlet("/getuserbyid.do")
public class GetUserByIdServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收页面要修改的用户id
	int id=Integer.parseInt(req.getParameter("id"));
	//创建UserService对象
	UserService us=new UserService();
	//调用根据id查询用户的方法
	UserBean userBean = us.queryUserById(id);
	try {
		//将读取的用户信息加入到请求
		req.setAttribute("ub", userBean);
		//调用查询部门的方法
		List<DeptBean> queryDept = us.queryDept();
		req.setAttribute("depts", queryDept);
		req.getRequestDispatcher("user/update.jsp").forward(req, resp);
	} catch (AppException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
