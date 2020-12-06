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
public class UserLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String url = ((HttpServletRequest) request).getRequestURL().toString();
		HttpSession session = ((HttpServletRequest) request).getSession();
		HttpServletResponse httpResponse = (HttpServletResponse) response; 

		if (url.contains("/user/post/add")) { 
			if (session.getAttribute(UserConstant.USER_ID) != null) {
				chain.doFilter(request, response);
			}
			else httpResponse.sendRedirect("/user/login");
				
		} else {
			chain.doFilter(request, response);
		}
	}

}
