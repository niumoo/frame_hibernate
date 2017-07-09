package me.imniu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.imniu.utils.ServletUtil;

/**
 * 过滤器来验证是否已经登陆
 */
@WebFilter("/mark/*")
public class LoginFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class); 
	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			chain.doFilter(req, resp);
		} else {
			ServletUtil.returnJsp("mark/login.jsp", req, resp);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
