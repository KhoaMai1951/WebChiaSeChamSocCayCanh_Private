package com.myclass.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.myclass.constant.UserConstant;

@Component
public class AdminLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String url = ((HttpServletRequest) request).getRequestURL().toString();
		HttpSession session = ((HttpServletRequest) request).getSession();
		HttpServletResponse httpResponse = (HttpServletResponse) response; 

		// if url has 'admin' in the link
		if (url.contains("/admin")) { 
			// if session has ADMIN_ID attribute with value
			// then continue
			if (session.getAttribute(UserConstant.ADMIN_ID) != null) {
				chain.doFilter(request, response);
			}
			// else redirect to admin login page
			else httpResponse.sendRedirect("/ad-login");
				
		} 
		// if url doesn't have 'admin' in the link, proceed as normal
		else chain.doFilter(request, response);
	}

}
