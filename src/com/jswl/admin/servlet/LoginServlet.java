package com.jswl.admin.servlet;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.jswl.admin.bean.AdminBean;
import com.jswl.admin.service.AdminService;
import com.jswl.zscms.exception.AppException;
import com.jswl.zscms.exception.SysException;
import com.jswl.zscms.util.DBUtil;
/**
 * 管理员登录连接 获取页面登录信息 查询数据库
 * @author Abeni
 *
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收页面输入框的数据        获取     	输入框属性name的值
		String loginname = req.getParameter("loginname");
		String password = req.getParameter("password");
		//创建session作用域对象
		HttpSession session = req.getSession();
		//获取验证码
		String yzm=req.getParameter("yzm");
		//获取google验证码
		String gyzm=(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
		if (!gyzm.equals(yzm)) {
			//说明验证码有误
			req.setAttribute("msg", "验证码输入有误，请重新输入");
			//转发到登录页面
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			//跳出方法
			return;
		}
		//创建AdminBean对象
		AdminBean aBean=new AdminBean();
		//把前端页面输入的账号和密码存入封装类
		aBean.setLoginname(loginname);
		aBean.setPassword(password);
		//获取是否记住密码
		String rem = req.getParameter("rem");
		if (rem!=null&&rem.equals("1")) {
			//获取登录名和密码 创建Cookie对象
			Cookie cookie1=new Cookie("loginname", loginname);
			Cookie cookie2=new Cookie("password", password);
			//设置有效时长
			cookie1.setMaxAge(3600*24*7);
			cookie2.setMaxAge(3600*24*7);
			//响应添加cookie对象
			resp.addCookie(cookie1);
			resp.addCookie(cookie2);
			
		}
		//创建AdminService对象 获取登录名称
		AdminService adminService=new AdminService();
		//调用检测管理员用户名和密码的方法
		AdminBean chklogin;
		try {
			
			chklogin = adminService.chklogin(aBean);
			//获取数据库登录名称
			String realname = chklogin.getRealname();
			System.out.println(realname);
			//通过session作用域把管理员id添加到请求
			session.setAttribute("adminId", chklogin.getId());
			//通过session作用域把登录名称添加到请求
			session.setAttribute("realname", realname);
			//使用转发  到成功页面 							携带参数
			req.getRequestDispatcher("main.html").forward(req, resp);
			System.out.println("登录成功");
		} catch (AppException e) {
			//使用 重定向 到失败页面
			req.setAttribute("err", "账号或密码错误，请重新输入");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			System.out.println("登录失败");
		}
		
		
	
		
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
