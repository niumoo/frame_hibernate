package me.imniu.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.imniu.po.Post;
import me.imniu.utils.HibernateUtils;

/**
 * 文章的业务逻辑
 * 
 * @author niu
 * @data 2017年6月20日 下午10:29:13
 */
public class PostService {
	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	
	/**
	 * 查询文章列表，所有信息,用于首页
	 * @return
	 */
	public List<Post> getPostList() {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Post where status= 1 order by updateTime desc";
		Query query = session.createQuery(hql);
		List<Post> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}
	
	/**
	 * 查询所有信息,用户后台文章管理
	 * @return
	 */
	public List<Post> getPostListOrderByUpdate() {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Post order by updateTime desc";
		Query query = session.createQuery(hql);
		List<Post> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	/**
	 * 根据id查询文章信息
	 * 
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
	 * 插入数据
	 * @param Post
	 * @return id
	 */
	public Integer insert(Post post) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Serializable save = session.save(post);
		logger.info("新增文章ID："+save.toString());
		transaction.commit();
		session.close();
		return Integer.valueOf(save.toString());
	}

	/**
	 * 根据某个字段查询信息
	 * 
	 * @param columnName
	 *            条件字段
	 * @param info
	 *            条件字段匹配信息
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
	}
	/**
	 * 更新信息
	 * @param post
	 */
	public void update(Post post){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(post);
		transaction.commit();
		session.close();
	}
}
