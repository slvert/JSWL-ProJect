package com.jswl.article.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.columntable.bean.ColumntebleBean;
import com.jswl.columntable.service.ColumntableService;
import com.jswl.fastreport.bean.FastreportBean;
import com.jswl.fastreport.service.FastreportService;
import com.jswl.user.bean.DeptBean;
import com.jswl.user.service.UserService;
import com.jswl.zscms.exception.AppException;
/**
 * 栏目信息的DeptServlet层 用于获取部门信息 然后去JSP页面展示栏目信息
 * @author Abeni
 *
 */
@WebServlet("/channel.do")
public class ChannelInitServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//创建ColumntableService对象
		ColumntableService cs=new ColumntableService();
	
		List<ColumntebleBean> queryAllColumn = cs.queryAllColumn();
	//将参数信息放到请求中
	req.setAttribute("columns", queryAllColumn);
	//携带参数转发到页面
	req.getRequestDispatcher("article/add.jsp").forward(req, resp);
	}
}
