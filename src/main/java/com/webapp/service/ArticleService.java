package com.webapp.service;

import java.util.List;

import com.webapp.domain.Article;
/****
 * 
 * @author yanghongquan
 * @created 2012-1-17
 */
public interface ArticleService {
//	Article getArticleById(Integer id);
	List<Article> getAllArticles();
	Article makeChioceAction(String choice, Integer articleId,Article article);
	String getTimeNow();
}
