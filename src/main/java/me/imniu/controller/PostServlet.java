 package me.imniu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import me.imniu.po.Post;
import me.imniu.po.Tag;
import me.imniu.service.PostService;
import me.imniu.service.TagService;
import me.imniu.utils.ServletUtil;

/**
 * 
 * 保存文章
 * 
 * @author Niu on 2017年7月7日 下午8:01:12
 */
@WebServlet({"/post","/mark/save","/mark/update"})
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getServletPath().toString();
		if(url.equals("/post")){
			postInfo(req,resp);
		}
		if(url.endsWith("/mark/save")){
			savePost(req,resp);
		}
		if(url.equals("/mark/update")){
			updatePost(req,resp);
		}
		
		
	}
	
	/**
	 * 文章详情
	 * @param request
	 * @param response
	 */
	private void postInfo(HttpServletRequest request, HttpServletResponse response) {
		PostService postService = new PostService();
		List<Post> postList = postService.getPostBy("path", request.getParameter("path"));
		Post post = postList.get(0);
		TagService tagService = new TagService();
		List<Tag> tagList = tagService.getTagByPostId(post.getId());
		List<String> postTags = new ArrayList<String>();
		for (Tag tag : tagList) {
			postTags.add(tag.getTagName());
		}	
		List<String> tags = tagService.getTagList();

		request.setAttribute("postTags", postTags);
		request.setAttribute("tags", tags);
		request.setAttribute("post", post);
		// 页面跳转
		ServletUtil.returnJsp("post.jsp", request, response);
	}

	/**
	 * 更新
	 * 检查各个值是否存在，不存在返回状态0
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void updatePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Integer id = Integer.valueOf(req.getParameter("id"));
		String status = req.getParameter("status");
		String title = req.getParameter("title");
		String subhead = req.getParameter("subhead");
		String summary = req.getParameter("summary");
		String path = req.getParameter("path");
		String markdown = req.getParameter("markdown");
		String htmlContent = req.getParameter("htmlContent");
		String tags  = req.getParameter("tags");
		// 1.检查值不能为空
		if (checkIsEmpty(status) || checkIsEmpty(title) || checkIsEmpty(subhead) || checkIsEmpty(summary)
				|| checkIsEmpty(path) || checkIsEmpty(markdown) || checkIsEmpty(htmlContent) || checkIsEmpty(tags)) {
			resp.getWriter().print(0);
			return;
		}

		PostService postService = new PostService();
		// 2.更新文章
		Post p = postService.getPostById(id);
		Post post = new Post(id, title, subhead, summary, markdown, htmlContent, path, p.getCreateTime(), new Date(),
				p.getReadCount(), Integer.valueOf(status));
		postService.update(post);
		// 3.更新标签
		TagService tagService = new TagService();
		// 3.1:删除老标签
		List<Tag> tagsList = tagService.getTagByPostId(id);
		for (Tag tag : tagsList) {
			tagService.delete(tag);
		}
		// 3.2增加新标签
		String[] tagArray = tags.split(",");
		for (String tagName : tagArray) {
			if(tagName.equals("") || tagName.length()<1){
				continue;
			}
			Tag tag =new Tag(null, tagName, id);
			tagService.insert(tag);
		}
		resp.getWriter().print(1);
	
	}

	/**
	 * /*
	 * 保存文章：
	 *  返回值：0，有值为空，1成功，2.路径已存在3:保存失败
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void savePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String status = req.getParameter("status");
		String title = req.getParameter("title");
		String subhead = req.getParameter("subhead");
		String summary = req.getParameter("summary");
		String path = req.getParameter("path");
		String markdown = req.getParameter("markdown");
		String htmlContent = req.getParameter("htmlContent");
		String tags = req.getParameter("tags");
		// 检查值不能为空
		if (checkIsEmpty(status)||checkIsEmpty(title)||checkIsEmpty(subhead)||checkIsEmpty(summary)||
				checkIsEmpty(path)||  checkIsEmpty(markdown)|| checkIsEmpty(htmlContent)||checkIsEmpty(tags)) {
			resp.getWriter().print(0);
			return ;
		}
		PostService postService = new PostService();
		TagService tagService = new TagService();
		// 检查路径是否已经存在
		List<Post> postByPath = postService.getPostBy("path", path);
		if (postByPath.size()>0) {
			resp.getWriter().print(2);
			return;
		}
		//写如数据
		Post post = new Post(null, title, subhead, summary, markdown, htmlContent, path, new Date(), new Date(), 1,
				Integer.valueOf(status));
		Integer postId = postService.insert(post);
		//写标签信息
		String[] tagArray = tags.split(",");
		for (String tagName : tagArray) {
			if(tagName.equals("") || tagName.length()<1){
				continue;
			}
			Tag tag =new Tag(null, tagName, postId);
			tagService.insert(tag);
		}
		resp.getWriter().print(1);
		
	}

	private boolean checkIsEmpty(String temp) {
		if(temp == null){
			return true;
		}
		if(temp.trim().length()<1){
			return true;
		}
		return false;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
