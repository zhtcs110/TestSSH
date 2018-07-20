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
		// ��������������Ҫ�õ�request,response,session����
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // ����û������URI
        String path = servletRequest.getRequestURI();
        // ��session��ȡ�û�
        Employee employee = (Employee) session.getAttribute("existEmployee");
        // ��½ҳ���������
        if("/TestSSH/".equals(path) || "/TestSSH/index.jsp".equals(path)) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        // �ж����û��ȡ���û���Ϣ,˵�����������û�е�¼��������     ����ת����½ҳ�� 
        if (employee== null) {
            // ��ת����½ҳ��
            servletResponse.sendRedirect(servletRequest.getContextPath());
        } else {
            // �Ѿ���½,�����˴�����
            chain.doFilter(request, response);
        }

    }

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
