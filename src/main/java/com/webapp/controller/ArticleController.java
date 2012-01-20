package com.webapp.controller;

/*****
 * @author yanghongquan
 * @created 2012-1-17
 */

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.domain.Article;
import com.webapp.service.ArticleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ArticleController {
	@Resource
	ArticleService articleService;
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is " + locale.toString());

		model.addAttribute("HelloWorld", "HelloWorld");

		return "home";
	}

	@RequestMapping(value = "/showArticle", method = RequestMethod.GET)
	public String showArticle(Integer id, Model model) {
		Article article = articleService.makeChioceAction("get", id, null);
		model.addAttribute("article", article);
		return "showarticle";
	}

	@RequestMapping(value = "/editArticle", method = RequestMethod.GET)
	public String editArticle(Integer id, Model model) {
		Article article = articleService.makeChioceAction("get", id, null);
		model.addAttribute("article", article);
		return "editarticle";
	}

	@RequestMapping(value = "/saveEditArticle", method = RequestMethod.POST)
	public String saveEditArticle(Article article) {
		article.setArtCatagory("默认");
		articleService.makeChioceAction("update", article.getArtId(), article);
		Integer artId = article.getArtId();
		return "redirect:showArticle?id=" + artId;
	}

	@RequestMapping(value = "/showAllArticles", method = RequestMethod.GET)
	public String showAllArticles(Model model) {
		List<Article> articles = articleService.getAllArticles();
		model.addAttribute("articleList", articles);
		return "articlelist";
	}

	@RequestMapping(value = "/delArticle", method = RequestMethod.GET)
	public String delArticle(Integer id, Model model) {
		articleService.makeChioceAction("delete", id, null);
		return "redirect:showAllArticles";
	}

	@RequestMapping(value = "/wirteArticle", method = RequestMethod.GET)
	public String wirteArticle(Model model) {
		String time = articleService.getTimeNow();
		Article article = new Article();
		article.setArtAuthor("blog");
		article.setArtTime(time);
		article.setArtCatagory("默认");
		model.addAttribute("article", article);
		return "writearticle";
	}

	@RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
	public String saveArticle(Article article) {
		articleService.makeChioceAction("add", null, article);
		return "redirect:showAllArticles";
	}
}
