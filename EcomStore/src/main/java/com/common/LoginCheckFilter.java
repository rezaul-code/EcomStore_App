package com.common;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Objects;


@WebFilter(urlPatterns = {"/admin/*", "/seller/*", "/user/*"})
public class LoginCheckFilter extends HttpFilter {
       
   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResonse = (HttpServletResponse) response;
		
		String urlPath = httpRequest.getRequestURI();
		
		HttpSession hts = httpRequest.getSession(false);
		
		
		if(urlPath.contains("/admin/")) {
			
			
			Object admin =  hts.getAttribute("admin");
			if(!Objects.nonNull(admin)) {
				httpResonse.sendRedirect(httpRequest.getContextPath()+ "/admin_login");
				return;
			}
			
			
			
		}else if(urlPath.contains("/seller/")) {
			
			Object seller = hts.getAttribute("seller");
			if (!Objects.nonNull(seller)) {
				httpResonse.sendRedirect(httpRequest.getContextPath()+ "/seller_login");
				return;
			}
			
			
		}else if(urlPath.contains("/user/")) {
			Object user = hts.getAttribute("customer");
			if(!Objects.nonNull(user)) {
				httpResonse.sendRedirect(httpRequest.getContextPath()+ "/user_login");
				return;
			}
			
		}
		

		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
