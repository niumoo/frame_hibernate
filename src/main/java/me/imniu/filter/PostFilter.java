package me.imniu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebFilter("/post/*")
public class PostFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(PostFilter.class); 
	public PostFilter() {
	}
	public void destroy() {
	}

	/**
	 * 截取出请求参数，实现伪静态 
	 * 请求路径：/post/tomcat 
	 * 处理成为：/post?path=tomcat
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String url = req.getServletPath();
		url = "/post?path=" + url.replace("/post/", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
