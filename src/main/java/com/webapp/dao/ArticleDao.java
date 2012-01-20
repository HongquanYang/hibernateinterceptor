package com.webapp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.webapp.core.Choice;
import com.webapp.domain.Article;

/*****
 * 
 * @author yanghongquan
 * @created 2012-1-17
 */

@Repository
public class ArticleDao {
	@Resource
	SessionFactory sessionFactory;

	// private final ThreadLocal<Session> threadLocal = new
	// ThreadLocal<Session>();

//	// 获取session
//	public Session getSession() throws HibernateException {
//		Session session = (Session) threadLocal.get();
//		if (null == session) {
//			session = sessionFactory.openSession();
//			threadLocal.set(session);
//		}
//		return session;
//	}

	public Article chooseAction(String choice, Integer articleId,
			Article article) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		switch (Choice.getChoice(choice)) {
		case get:
			article = (Article) session.get(Article.class, articleId);
			return article;
		case add:
			session.save(article);
			break;
		case update:
			session.update(article);
			break;
		case delete:
			article = (Article) session.get(Article.class, articleId);
			session.delete(article);
			break;
		default:
			break;
		}
		tx.commit();
		session.close();
		System.out.println("session=" + session);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Article> findAllArticles() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Article";
		Query query = session.createQuery(hql);
		List<Article> articleList = query.list();
		tx.commit();
		session.close();
		return articleList;
	}

	// // 查询
	// public Article getArticleById(Integer articleId) {
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// Article article = (Article) session.get(Article.class, articleId);
	// tx.commit();
	// session.close();
	// sessionFactory.close();
	// return article;
	// }
	//
	// // 增加
	// public void add(Article article) {
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// session.save(article);
	// tx.commit();
	// session.close();
	// sessionFactory.close();
	// }
	//
	// // 更新
	// public void update(Article article) {
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// session.update(article);
	// tx.commit();
	// session.close();
	// sessionFactory.close();
	// }
	//
	// // 删除
	// public void delete(Article article) {
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// session.delete(article);
	// tx.commit();
	// session.close();
	// sessionFactory.close();
	// }

}
