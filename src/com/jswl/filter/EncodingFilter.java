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
/**
 * 过滤器
 * @author Abeni
 *
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//servletRequest转换HttpServletRequest
		HttpServletRequest req=(HttpServletRequest)arg0;
		//ServletResponse转换HttpServletResponse
		HttpServletResponse resp=(HttpServletResponse)arg1;
		//设置请求编码的规则  需要的规则
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//继续向后执行过滤器的链
		arg2.doFilter(arg0, arg1);
		

	}

}
