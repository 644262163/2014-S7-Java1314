package com.demo.org.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.demo.org.dao.AccountDao;
import com.demo.org.dao.impl.AccountDaoImpl;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(filterName="FA",urlPatterns="/*")
public class F1_AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public F1_AuthFilter() {
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

		//获取用户信息
		HttpServletRequest hsr = (HttpServletRequest)request;
		int id = 0;
		if(hsr.getSession().getAttribute("user_id")!=null) {
			id = (int)hsr.getSession().getAttribute("user_id");
		}
		
		//获取访问地址
		String url = hsr.getServletPath();
		
		//获取用户权限信息
		AccountDao ad = new AccountDaoImpl();
		List<String> urlList = ad.getAuthUrl(id);
		
		//判断是否有该访问地址的权限
		if(urlList.contains(url)) {
			//如果有权限
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else {
			//如果没有权限
			//跳转到无权限页面
			request.getRequestDispatcher("/WEB-INF/jsp/NoAuth.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}