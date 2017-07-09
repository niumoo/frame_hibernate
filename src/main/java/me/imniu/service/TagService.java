package me.imniu.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.slf4j.LoggerFactory;


import me.imniu.po.Tag;
import me.imniu.utils.HibernateUtils;

/**
 * 标签类的业务逻辑
 * 
 * @author niu
 * @data 2017年6月20日 下午11:03:41
 */
public class TagService {
	private static final org.slf4j.Logger logger= LoggerFactory.getLogger(TagService.class);
	
	
	/**
	 * 插入数据
	 * @param Tag
	 * @return id
	 */
	public Integer insert(Tag tag) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Serializable save = session.save(tag);
		transaction.commit();
		session.close();
		return Integer.valueOf(save.toString());
	}
	
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
	}

	/**
	 * 根据文章ID查询标签信息
	 * 
	 * @return
	 */
	public List<Tag> getTagByPostId(Integer id) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "from Tag where postId="+id;
		Query query = session.createQuery(hql);
		List<Tag> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

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
	
	public void delete(Tag tag){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(tag);
		transaction.commit();
		session.close();
	}

}
