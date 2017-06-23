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
 * 标签页面 Servlet
 */
@WebServlet("/tags")
public class TagsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 是/tags
	 * 		1：取所有文章
	 * 		2：取所有标签
	 * 是/tags?name=xxx
	 * 		1:根据标签名取对应的文章id
	 * 		2：根据文章id取文章
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostService postService = new PostService();
		TagService tagService = new TagService();
		String tagName = request.getParameter("name");
		if (tagName == null) {
			ArrayList<Post> posts = postService.getPostList();
			ArrayList<String> tags = tagService.getTagList();
			request.setAttribute("tags", tags);
			request.setAttribute("posts", posts);
			// 页面跳转
			ServletUtil.returnJsp("tags.jsp", request, response);
		} else {

			ArrayList<Integer> tagNames = tagService.getTagByName(tagName);
			ArrayList<Post> posts = postService.getPostById(tagNames);

			request.setAttribute("tagName", tagName);
			request.setAttribute("posts", posts);
			ServletUtil.returnJsp("tags.jsp", request, response);
		}

	}

}
