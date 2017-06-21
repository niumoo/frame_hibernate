package me.niu.utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * 
 * @author Niu
 * @data   2017年6月20日 下午10:24:53
 */
public class ServletUtil {
	/**
	 * 页面跳转
	 * @param jsp
	 * @param request
	 * @param response
	 */
	public static void returnJsp(String jsp,HttpServletRequest request,HttpServletResponse response){
		RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
		try {
			dispatcher .forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
