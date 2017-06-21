package me.niu.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.niu.po.Post;
import me.niu.utils.JDBCTool;

/**
 * 文章的业务逻辑
 * @author niu
 * @data 2017年6月20日 下午10:29:13
 */
public class PostService {
	
	/**
	 * 查询文章列表，所有信息，不分页
	 * @return
	 */
	public ArrayList<Post> getPostList() {
		ArrayList<Post> posts = new ArrayList<Post>();
		String sql = "select * from POST";
		JDBCTool jdbcTool = new JDBCTool();
		ResultSet rs = jdbcTool.select(sql);
		try {
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String subhead = rs.getString("SUBHEAD");
				String summary = rs.getString("SUMMARY");
				String markdown = rs.getString("MARKDOWN");
				String htmlContent = rs.getString("HTML_CONTENT");
				Date createTime = rs.getDate("CREATE_TIME");
				Date updateTime = rs.getDate("UPDATE_TIME");
				int readCount = rs.getInt("READ_COUNT");
				int status = rs.getInt("STATUS");
				posts.add(new Post(id, title, subhead, summary, markdown, htmlContent, createTime, updateTime,
						readCount, status));
			}
			jdbcTool.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}

	/**
	 * 根据文章ID查询文章信息
	 * @param id
	 * @return
	 */
	public Post getPostById(String id){
		Post post = null;
		String sql = "select * from POST where id = "+id;
		JDBCTool jdbcTool = new JDBCTool();
		ResultSet rs = jdbcTool.select(sql);
		try {
			while(rs.next()){
				int postId = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String subhead = rs.getString("SUBHEAD");
				String summary = rs.getString("SUMMARY");
				String markdown=rs.getString("MARKDOWN");
				String htmlContent = rs.getString("HTML_CONTENT");
				Date createTime = rs.getDate("CREATE_TIME");
				Date updateTime = rs.getDate("UPDATE_TIME");
				int readCount = rs.getInt("READ_COUNT");
				int status = rs.getInt("STATUS");
				post = new Post(postId, title, subhead,summary, markdown, htmlContent, createTime, updateTime, readCount, status);
			}
			jdbcTool.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}
}
