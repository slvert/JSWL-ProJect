package com.jswl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * 路径拦截器
 * @author Abeni
 *
 */
@WebFilter("/*")

public class URLFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//servletRequest转换HttpServletRequest
		HttpServletRequest req=(HttpServletRequest)request;
		//ServletResponse转换HttpServletResponse
		HttpServletResponse resp=(HttpServletResponse)response;
		//获取所有访问路径
		String url=req.getServletPath();
		// 创建session对象 获取登录员id
		HttpSession session = req.getSession();
		//检查是否登录  获取登录员id
		Object adminid = session.getAttribute("adminId");
		//判断路径是否包含 .do 的所有路径 ，并且放行login.do
			if (url.contains(".do")&&!url.contains("login.do")) {
				if (adminid==null) {
					//说明没有进行登录，属于恶意访问
					resp.sendRedirect("login.jsp");
					return;
				}
				
			}
			//判断路径是否包含 .jsp的所有路径 ，并且放行login.jsp
			if (url.contains(".jsp")&&!url.contains("login.jsp")) {
				if (adminid==null) {
					//说明没有进行登录，属于恶意访问
					resp.sendRedirect("../login.jsp");
					return;
				}
			}
			//判断路径是否包含 .html的所有路径
			if (url.contains(".html")) {
				if (adminid==null) {
					//说明没有进行登录，属于恶意访问
					resp.sendRedirect("login.jsp");
					return;
				}
			}
			//正常访问放行
			chain.doFilter(req, resp);
		}


}
