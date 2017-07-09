package me.imniu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.imniu.po.Post;
import me.imniu.po.Tag;
import me.imniu.service.PostService;
import me.imniu.service.TagService;
import me.imniu.utils.ServletUtil;
import sun.security.jgss.LoginConfigImpl;

/**
 * 后台首页
 * 		判断是否有id参数进来，
 * 		有：跳转到更新页面
 * 		没有：跳转到新建文章页面
 * @author Niu on 2017年7月8日 上午9:03:37
 *
 */
@WebServlet({"/login","/mark/index"})
public class MarkServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(MarkServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath().toString();
		
		if(url.endsWith("/mark/index")){
			markIndex(request,response);
		}
		
		if(url.endsWith("/login")){
			login(request,response);
		}
		
	}
	
	
	/**
	 * 登陆操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		logger.info("username:" + username + ",email:" + email + ",password:" + password);
		
		if ("niu".equals(username) && "123".equals(password)) {
			logger.info("登陆成功！");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.getWriter().print(1);
//			request.getRequestDispatcher("/mark/index").forward(request,response);
		} else {
			logger.info("登陆失败！");
			response.getWriter().print(0);
//			ServletUtil.returnJsp("mark/login.jsp", request, response);
		}

	
	}

	/**
	 * 后台首页
	 * @param request
	 * @param response
	 */
	private void markIndex(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		PostService postService = new PostService();
		List<Post> postList = postService.getPostListOrderByUpdate();
		request.setAttribute("postList", postList);
		//有id，取详细数据，跳转到更新页面
		if(id != null){
			TagService tagService = new TagService();
			List<Tag> tagsList = tagService.getTagByPostId(Integer.valueOf(id));
			StringBuffer tagString = new StringBuffer();
			for (Tag tag : tagsList) {
				tagString.append(tag.getTagName()+",");
			}
			Post p = postService.getPostById(Integer.valueOf(id));
			request.setAttribute("p", p);
			request.setAttribute("tags", tagString.toString());
			ServletUtil.returnJsp("mark/update.jsp", request, response);
			return ;
		}
		ServletUtil.returnJsp("mark/write.jsp", request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
