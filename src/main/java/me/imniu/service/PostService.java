package me.imniu.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import me.imniu.po.Post;
import me.imniu.utils.HibernateUtils;

/**
 * 文章的业务逻辑
 * 
 * @author niu
 * @data 2017年6月20日 下午10:29:13
 */
public class PostService {

	/**
	 * 查询文章列表，所有信息，不分页
	 * 
	 * @return
	 */
	public List<Post> getPostList() {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Post";
		Query query = session.createQuery(hql);
		List<Post> list = query.list();
		transaction.commit();
		session.close();
		return list;
		// 以下是之前使用jdbc完成
		// ArrayList<Post> posts = new ArrayList<Post>();
		// String sql = "select * from POST";
		// JDBCTool jdbcTool = new JDBCTool();
		// ResultSet rs = jdbcTool.select(sql);
		// try {
		// while (rs.next()) {
		// int id = rs.getInt("ID");
		// String title = rs.getString("TITLE");
		// String subhead = rs.getString("SUBHEAD");
		// String summary = rs.getString("SUMMARY");
		// String markdown = rs.getString("MARKDOWN");
		// String htmlContent = rs.getString("HTML_CONTENT");
		// String path = rs.getString("PATH");
		// Date createTime = rs.getDate("CREATE_TIME");
		// Date updateTime = rs.getDate("UPDATE_TIME");
		// int readCount = rs.getInt("READ_COUNT");
		// int status = rs.getInt("STATUS");
		// posts.add(new Post(id, title, subhead, summary, markdown,
		// htmlContent,path, createTime, updateTime,
		// readCount, status));
		// }
		// jdbcTool.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// return posts;
	}

	/**
	 * 根据id查询文章信息
	 * @param id
	 * @return
	 */
	public Post getPostById(Integer id) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Post post = (Post) session.get(Post.class, id);
		transaction.commit();
		session.close();
		
		return post;
	}
	/**
	 * 根据某个字段查询信息
	 * 
	 * @param columnName 条件字段
	 * @param info 条件字段匹配信息
	 * @return
	 */
	public List<Post> getPostBy(String columnName, String info) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Post.class);
		criteria.add(Restrictions.eq(columnName, info));
		List<Post> list = criteria.list();
		transaction.commit();
		session.close();
		return list;
		// 以下是之前使用jdbc完成
		// ArrayList<Post> posts = new ArrayList<Post>();
		// // 拼接sql
		// String inId = "(";
		// for (int id : ids) {
		// inId = inId + id + ",";
		// }
		// inId = inId.substring(0, inId.length() - 1) + ")";
		// String sql = "select * from POST where id in " + inId;
		// JDBCTool jdbcTool = new JDBCTool();
		// ResultSet rs = jdbcTool.select(sql);
		// try {
		// while (rs.next()) {
		// int postId = rs.getInt("ID");
		// String title = rs.getString("TITLE");
		// String subhead = rs.getString("SUBHEAD");
		// String summary = rs.getString("SUMMARY");
		// String markdown = rs.getString("MARKDOWN");
		// String htmlContent = rs.getString("HTML_CONTENT");
		// String path = rs.getString("PATH");
		// Date createTime = rs.getDate("CREATE_TIME");
		// Date updateTime = rs.getDate("UPDATE_TIME");
		// int readCount = rs.getInt("READ_COUNT");
		// int status = rs.getInt("STATUS");
		// posts.add(new Post(postId, title, subhead, summary, markdown,
		// htmlContent, path, createTime, updateTime,
		// readCount, status));
		// }
		// jdbcTool.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// return posts;
	}

//	public Post getPostByPath(String urlPath) {
//		Post post = null;
//		String sql = "select * from POST where PATH = '" + urlPath + "'";
//		JDBCTool jdbcTool = new JDBCTool();
//		ResultSet rs = jdbcTool.select(sql);
//		try {
//			while (rs.next()) {
//				int postId = rs.getInt("ID");
//				String title = rs.getString("TITLE");
//				String subhead = rs.getString("SUBHEAD");
//				String summary = rs.getString("SUMMARY");
//				String markdown = rs.getString("MARKDOWN");
//				String htmlContent = rs.getString("HTML_CONTENT");
//				String path = rs.getString("PATH");
//				Date createTime = rs.getDate("CREATE_TIME");
//				Date updateTime = rs.getDate("UPDATE_TIME");
//				int readCount = rs.getInt("READ_COUNT");
//				int status = rs.getInt("STATUS");
//				post = new Post(postId, title, subhead, summary, markdown, htmlContent, path, createTime, updateTime,
//						readCount, status);
//			}
//			jdbcTool.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return post;
//	}

}
