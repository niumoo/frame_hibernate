package me.niu.controller;

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

/**
 * 
 * 拦截器进行字符编码过滤
 */
@WebFilter("/*")
public class EncodedFilter implements Filter {
//	private FilterConfig config;
    public EncodedFilter() {
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 获取web.xml里配置的字符编码
		// String encode = config.getInitParameter("encode");
		// 设置请求和反馈编码
		System.out.println("Filter：过滤字符编码为UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		chain.doFilter(req, resp);

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
