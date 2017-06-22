package me.niu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.niu.po.Post;
import me.niu.service.PostService;
import me.niu.service.TagService;
import me.niu.utils.ServletUtil;

/**
 * 标签页面 Servlet implementation class TagsServlet
 */
@WebServlet("/tags")
public class TagsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet:/tags");
		PostService postService = new PostService();
		ArrayList<Post> posts = postService.getPostList();

		TagService tagService = new TagService();
		ArrayList<String> tags = tagService.getTagList();

		request.setAttribute("tags", tags);
		request.setAttribute("posts", posts);
		// 页面跳转
		ServletUtil.returnJsp("tags.jsp", request, response);
	}

}
