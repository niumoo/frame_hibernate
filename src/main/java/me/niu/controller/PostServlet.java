package me.niu.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.niu.po.Post;
import me.niu.service.PostService;
import me.niu.service.TagService;
import me.niu.utils.JDBCTool;
import me.niu.utils.ServletUtil;

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
//		Post post = postService.getPostById(request.getParameter("id"));
		Post post = postService.getPostByPath(request.getParameter("path"));
		
		TagService tagService = new TagService();
		ArrayList<String> postTags = tagService.getTagByPostId(String.valueOf(post.getId()));
		ArrayList<String> tags = tagService.getTagList();
		
		request.setAttribute("postTags", postTags);
		request.setAttribute("tags", tags);
		request.setAttribute("post", post);
		// 页面跳转
		ServletUtil.returnJsp("post.jsp", request, response);

	}

}
