package me.imniu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.imniu.po.Post;
import me.imniu.service.PostService;
import me.imniu.service.TagService;
import me.imniu.utils.ServletUtil;

/**
 * 查询文章列表，返回首页
 * 
 * @author niu
 *
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PostService postService = new PostService();
		List<Post> posts = postService.getPostList();
		
		TagService tagService = new TagService();
		List<String> tags = tagService.getTagList();
		
		request.setAttribute("tags", tags);
		request.setAttribute("posts", posts);
		// 页面跳转
		ServletUtil.returnJsp("index.jsp", request, response);
	}
}
