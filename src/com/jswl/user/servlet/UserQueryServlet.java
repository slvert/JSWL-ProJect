package com.jswl.user.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jswl.user.bean.UserBean;
import com.jswl.user.service.UserService;
/**
 * 查询所有用户的servlet
 * @author Abeni
 *
 */
@WebServlet("/userquery.do")
public class UserQueryServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//创建userService对象
	UserService us=new UserService();
	//定义每页显示的条数
	int n=3;
	//获取当前的页数
	String page = req.getParameter("page");
	//定义当前的页面
	int k;
	//如果获得当前页面page为null,那说明位于首页 将k赋值为1
	if (page==null) {
		k=1;
	}else {
		//如果获取了当前页面，那么将当前页面赋值给k
		k=Integer.parseInt(page);
	}
	//定义m 为sql语句中的起始行数
	int m=(k-1)*n;
	//调取查询所有用户的方法
	List<UserBean> users = us.queryAllUser(m,n);
	//调用总页数方法
	int queryUserPageCount = us.queryUserPageCount(n);
	//创建session对象
	HttpSession session = req.getSession();
	//把users存入session作用域
	session.setAttribute("users", users);
	//把总页数存入session作用域
	session.setAttribute("pagecount", queryUserPageCount);
	//把当前页存入session作用域
	session.setAttribute("page",k);
	//重定向到list页面
	resp.sendRedirect("user/list.jsp");
	}
}
