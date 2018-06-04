package com.kshrd.ams.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.service.ArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/article")
	public String article(ModelMap m) {
		List<Article> articles = articleService.findAll();
		System.out.println(articles);
		m.addAttribute("articles", articles);
		return "article";
	}
	
	@GetMapping("/add")
	public String add(ModelMap m) {
		m.addAttribute("article", new Article());
		return "add";
	}
	
	@PostMapping("/add")
	public String saveArticle(@ModelAttribute Article article) {
		article.setCreatedDate(new Date().toString());
		System.out.println(article);
		articleService.add(article);
		return "redirect:/add";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		articleService.delete(id);
		return "redirect:/article";
	}
	
}
