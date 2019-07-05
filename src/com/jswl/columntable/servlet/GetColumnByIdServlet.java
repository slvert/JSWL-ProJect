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
/**
 * 根据id查询栏目信息的servlet层
 * @author Abeni
 *
 */
@WebServlet("/getcolumnbyid.do")
public class GetColumnByIdServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取栏目页面id
	int id=Integer.parseInt(req.getParameter("cid"));
	
	
	//创建ColumntableService对象
	ColumntableService cs=new ColumntableService();
	//d调用查询所有栏目信息的方法
	List<ColumntebleBean> queryAllColumn = cs.queryAllColumn();
	req.setAttribute("cols", queryAllColumn);
	ColumntebleBean queryColumnById = cs.queryColumnById(id);
	req.setAttribute("col", queryColumnById);
	req.getRequestDispatcher("column/update.jsp").forward(req, resp);
	}
}
