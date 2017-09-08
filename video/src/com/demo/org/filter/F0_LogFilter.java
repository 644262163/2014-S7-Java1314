package com.demo.org.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.demo.org.bean.Log;
import com.demo.org.dao.LogDao;
import com.demo.org.dao.impl.LogDaoImpl;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(filterName="FB",urlPatterns="/*")
public class F0_LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public F0_LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//获取dao
		LogDao ld = new LogDaoImpl();
		
		//获取用户信息
		HttpServletRequest hsr = (HttpServletRequest)request;
		String username = (String)hsr.getSession().getAttribute("username");
		int id = 0;
		if(hsr.getSession().getAttribute("user_id") != null){
			id = (int)hsr.getSession().getAttribute("user_id");
		}
		//获取用户访问信息
		String url = hsr.getServletPath();
		
		//记录用户访问信息
		Log log = new Log();
		log.setAccount_id(id);
		log.setDescription("访问url:"+url);
		
		ld.addLog(log);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}