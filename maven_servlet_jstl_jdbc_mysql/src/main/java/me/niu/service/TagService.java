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

}
