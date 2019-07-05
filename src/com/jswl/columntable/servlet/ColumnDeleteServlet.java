package com.jswl.columntable.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.columntable.bean.ColumntebleBean;
import com.jswl.columntable.service.ColumntableService;
import com.jswl.zscms.exception.AppException;
/**
 * 根据id删除栏目的servlet层
 * @author Abeni
 *
 */
@WebServlet("/columndelete.do")
public class ColumnDeleteServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取栏目页面要删除的id
	int id=Integer.parseInt(req.getParameter("cid"));
	//创建ColumntableService对象
	ColumntableService cs=new ColumntableService();
	//调用查询的所有栏目的方法
	List<ColumntebleBean> queryAllColumn = cs.queryAllColumn();
	for (ColumntebleBean cb : queryAllColumn) {
		if (cb.getUpchannel()==id) {
			//调用删除栏目的方法
			try {
				cs.deleteColumnById(cb.getId());
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	try {
		//调用删除栏目的方法
		cs.deleteColumnById(id);
		resp.sendRedirect("columnqueryall.do");
	} catch (AppException e) {
		resp.sendRedirect("columnqueryall.do");
	}
	}
}
