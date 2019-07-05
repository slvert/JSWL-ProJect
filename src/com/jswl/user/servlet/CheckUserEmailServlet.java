package com.jswl.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.user.service.UserService;
/**
 * 检测新增邮箱是否符合要求的servlet层
 * @author Abeni
 *
 */
@WebServlet("/chkemail.do")
public class CheckUserEmailServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取新增邮箱
		String email = req.getParameter("email");
		UserService us=new UserService();
		//从响应中获取流对象
		 PrintWriter pw = resp.getWriter();
		 //定义邮箱正则
		 String regex= "^\\w+@[a-z0-9]{2,5}(\\.[a-z]{2,3}){1,2}$";
		 //正则验证
		 boolean flag = email.matches(regex);
		 if (flag) {
				//符合正则表达式 然后调取查重的方法
				int result=us.queryUserEmail(email);
				if (result==0) {
					//说明数据库中没有此邮箱，可以新增
					//通过流对象给ajax传送数据信息---YES
					pw.write("YES");
				}else {
					//说明数据库中有这个用户，不允许新增
					//通过流对象给ajax传送数据信息---NO1
					pw.write("NO1");
				}	
			}else {
				//不符合正则表达式--格式错误
				//通过流对象给ajax传送数据信息---NO2
				pw.write("NO2");
			}
			//刷新流对象  可以让ajax获取实时数据信息
			pw.flush();
			//关闭
			pw.close();
		

	}
}
