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
				String path = rs.getString("PATH");
				Date createTime = rs.getDate("CREATE_TIME");
				Date updateTime = rs.getDate("UPDATE_TIME");
				int readCount = rs.getInt("READ_COUNT");
				int status = rs.getInt("STATUS");
				posts.add(new Post(id, title, subhead, summary, markdown, htmlContent,path, createTime, updateTime,
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
	public ArrayList<Post> getPostById(ArrayList<Integer> ids){
		 ArrayList<Post> posts = new ArrayList<Post>();
		 //拼接sql
		 String inId = "(";
		 for(int id:ids){
			 inId = inId+id+",";
		 }
		 inId =inId.substring(0,inId.length()-1)+")";
		String sql = "select * from POST where id in "+inId;
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
				String path = rs.getString("PATH");
				Date createTime = rs.getDate("CREATE_TIME");
				Date updateTime = rs.getDate("UPDATE_TIME");
				int readCount = rs.getInt("READ_COUNT");
				int status = rs.getInt("STATUS");
				posts.add(new Post(postId, title, subhead, summary, markdown, 
						htmlContent,path, createTime, updateTime,readCount, status));
			}
			jdbcTool.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}
	
	
	public Post getPostByPath(String urlPath){
		Post post = null;
		String sql = "select * from POST where PATH = '"+urlPath+"'";
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
				String path = rs.getString("PATH");
				Date createTime = rs.getDate("CREATE_TIME");
				Date updateTime = rs.getDate("UPDATE_TIME");
				int readCount = rs.getInt("READ_COUNT");
				int status = rs.getInt("STATUS");
				post = new Post(postId, title, subhead, summary, markdown, htmlContent,path, createTime, updateTime,readCount, status);
			}
			jdbcTool.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		Integer [] ids={1};
		 String inId = "(";
		 for(int id:ids){
			 inId = inId+id+",";
		 }
		 inId = inId.substring(0,inId.length()-1)+")";
		 System.out.println(inId);
	}
}
