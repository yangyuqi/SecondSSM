package com.second.api.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class DomainFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



	public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		   HttpServletResponse res = (HttpServletResponse) response;  
		   res.setContentType("text/html;charset=UTF-8");  
		   res.setHeader("Access-Control-Allow-Origin", "*");  
		   res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
		   res.setHeader("Access-Control-Max-Age", "0");  
		   res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");  
		   res.setHeader("Access-Control-Allow-Credentials", "true");  
		   res.setHeader("XDomainRequestAllowed","1");  
		   chain.doFilter(request, response);  
	}

}
