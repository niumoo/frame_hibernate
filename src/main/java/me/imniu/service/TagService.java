package me.imniu.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import me.imniu.utils.HibernateUtils;

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
	public List<String> getTagList() {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select distinct(tagName) from Tag";
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		transaction.commit();
		session.close();
		return list;
		// 以下使用jdbc完成
		// ArrayList<String> tags = new ArrayList<String>();
		// String sql = "select DISTINCT TAG_NAME from TAG";
		// JDBCTool jdbcTool = new JDBCTool();
		// ResultSet rs = jdbcTool.select(sql);
		// try {
		// while (rs.next()) {
		// String tagName = rs.getString("TAG_NAME");
		// tags.add(tagName);
		// }
		// jdbcTool.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// return tags;
	}

	/**
	 * 根据文章ID查询标签信息
	 * 
	 * @return
	 */
	public List<String> getTagByPostId(String id) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "select distinct(tagName) from Tag where postId="+id;
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}
	// public ArrayList<String> getTagByPostId(String postId) {
	// ArrayList<String> tags = new ArrayList<String>();
	// String sql = "select DISTINCT TAG_NAME from TAG where POST_ID="+postId;
	// JDBCTool jdbcTool = new JDBCTool();
	// ResultSet rs = jdbcTool.select(sql);
	// try {
	// while (rs.next()) {
	// String tagName = rs.getString("TAG_NAME");
	// tags.add(tagName);
	// }
	// jdbcTool.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return tags;
	// }

	/**
	 * 根据标签名称查询文章id
	 * 
	 * @return
	 */
	public List<Integer> getPostIdByTagName(String name){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select distinct(postId) from Tag where tagName='"+name+"'";
		Query query = session.createQuery(hql);
		List<Integer> postIdList = query.list();
		transaction.commit();
		session.close();
		return postIdList;
	
	}
	// public ArrayList<Integer> getTagByName(String name) {
	// ArrayList<Integer> postIds = new ArrayList<Integer>();
	// String sql = "select DISTINCT POST_ID from TAG where TAG_NAME=\"" +
	// name+"\"";
	// JDBCTool jdbcTool = new JDBCTool();
	// ResultSet rs = jdbcTool.select(sql);
	// try {
	// while (rs.next()) {
	// int postId = rs.getInt("POST_ID");
	// postIds.add(postId);
	// }
	// jdbcTool.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return postIds;
	// }

}
