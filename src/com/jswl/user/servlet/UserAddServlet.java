package com.jswl.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Param;

import com.jswl.user.bean.UserBean;
import com.jswl.user.service.UserService;
import com.jswl.zscms.exception.AppException;
/**
 * 用户servlet层 用于获取页面新增用户信息 传到数据库
 * @author Abeni
 *
 */
@WebServlet("/useradd.do")
public class UserAddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码的规则  需要的规则
		//req.setCharacterEncoding("utf-8");
		//resp.setCharacterEncoding("utf-8");
		//获取表单新增用户信息
		String loginname = req.getParameter("loginname");//获取用户名
		String password = req.getParameter("pwd2");//获取密码
		String realname = req.getParameter("realname");//获取真实名称
		String sex = req.getParameter("sex");//获取性别
		String birthday = req.getParameter("birthday");//获取出生日期
		String dept =req.getParameter("dept");//获取部门编号
		String email = req.getParameter("email");//获取邮箱
		String enabled = req.getParameter("enabled");//是否可用
		//创建userBean对象
		UserBean ub=new UserBean();
		//把页面输入的新增用户信息存入userBean封装类
		ub.setLoginname(loginname);
		ub.setPassword(password);
		ub.setRealname(realname);
		ub.setSex(sex);
		ub.setBirthday(birthday);
		ub.setDep(Integer.parseInt(dept));
		ub.setEmail(email);
		ub.setEnabled(Integer.parseInt(enabled));
		//创建session对象 用来获取管理员id
		HttpSession session = req.getSession();
		//通过session作用域获取登录者的id，也就是管理员的id，然后存入userBean封装
		ub.setCretman(Integer.parseInt(session.getAttribute("adminId")+""));
		
		//创建UserService对象 
		UserService us=new UserService();
		try {
			//调用新增用户的方法 把ub存入数据库
			us.insertUser(ub);
			//新增成功 跳转到list页面
			//req.getRequestDispatcher("user/list.html").forward(req, resp);
			resp.sendRedirect("userquery.do");
		} catch (AppException e) {
			//新增失败返回新增页面
			req.getRequestDispatcher("dept.do").forward(req, resp);
		}
		
	}
	
}
