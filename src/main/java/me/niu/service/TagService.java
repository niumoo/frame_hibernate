package me.niu.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.niu.utils.JDBCTool;

/**
 * 标签类的业务逻辑
 * 
 * @author niu
 * @data 2017年6月20日 下午11:03:41
 */
public class TagService {

	/**
	 * 查询所有的标签名称，去重复
	 * 
	 * @return
	 */
	public ArrayList<String> getTagList() {
		ArrayList<String> tags = new ArrayList<String>();
		String sql = "select DISTINCT TAG_NAME from TAG";
		JDBCTool jdbcTool = new JDBCTool();
		ResultSet rs = jdbcTool.select(sql);
		try {
			while (rs.next()) {
				String tagName = rs.getString("TAG_NAME");
				tags.add(tagName);
			}
			jdbcTool.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tags;
	}

	/**
	 * 根据文章ID查询标签信息
	 * @return
	 */
	public ArrayList<String> getTagByPostId(String postId) {
		ArrayList<String> tags = new ArrayList<String>();
		String sql = "select DISTINCT TAG_NAME from TAG where POST_ID="+postId;
		JDBCTool jdbcTool = new JDBCTool();
		ResultSet rs = jdbcTool.select(sql);
		try {
			while (rs.next()) {
				String tagName = rs.getString("TAG_NAME");
				tags.add(tagName);
			}
			jdbcTool.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tags;
	}
	
	/**
	 * 根据标签名称查询文章id
	 * @return
	 */
	public ArrayList<Integer> getTagByName(String name) {
		ArrayList<Integer> postIds = new ArrayList<Integer>();
		String sql = "select DISTINCT POST_ID from TAG where TAG_NAME=\"" + name+"\"";
		JDBCTool jdbcTool = new JDBCTool();
		ResultSet rs = jdbcTool.select(sql);
		try {
			while (rs.next()) {
				int postId = rs.getInt("POST_ID");
				postIds.add(postId);
			}
			jdbcTool.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postIds;
	}

}
