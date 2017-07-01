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
 * 根据文章路径查询文章信息,返回文章详细页面
 * 
 * @author niu
 *
 */
@WebServlet("/post")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostService postService = new PostService();
		List<Post> postList = postService.getPostBy("path", request.getParameter("path"));
		Post post = postList.get(0);
		TagService tagService = new TagService();
		List<String> postTags = tagService.getTagByPostId(String.valueOf(post.getId()));
		List<String> tags = tagService.getTagList();

		request.setAttribute("postTags", postTags);
		request.setAttribute("tags", tags);
		request.setAttribute("post", post);
		// 页面跳转
		ServletUtil.returnJsp("post.jsp", request, response);

	}

}
