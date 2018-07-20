package com.zht.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zht.entity.Employee;

public class JspFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        // 从session里取用户
        Employee employee = (Employee) session.getAttribute("existEmployee");
        // 登陆页面无需过滤
        if("/TestSSH/".equals(path) || "/TestSSH/index.jsp".equals(path)) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 判断如果没有取到用户信息,说明这个请求是没有登录就在请求     就跳转到登陆页面 
        if (employee== null) {
            // 跳转到登陆页面
            servletResponse.sendRedirect(servletRequest.getContextPath());
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }

    }

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
