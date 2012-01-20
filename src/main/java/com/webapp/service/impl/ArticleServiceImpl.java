package com.webapp.service.impl;
/****
 * @author yanghongquan
 * @created 2012-1-17
 */

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webapp.dao.ArticleDao;
import com.webapp.domain.Article;
import com.webapp.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	ArticleDao articleDao;

//	public Article getArticleById(Integer id) {
//
//		return articleDao.getArticleById(id);
//	}

	public Article makeChioceAction(String choice, Integer articleId,
			Article article) {

		return articleDao.chooseAction(choice, articleId, article);
	}

	public List<Article> getAllArticles() {
		return articleDao.findAllArticles();
	}

	public String getTimeNow() {
		Date date = new Date(System.currentTimeMillis());
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
				DateFormat.MEDIUM, Locale.CHINA);
		String time = df.format(date);
		return time;
	}

}
