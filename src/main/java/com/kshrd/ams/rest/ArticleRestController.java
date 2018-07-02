package com.kshrd.ams.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.model.ArticleFilter;
import com.kshrd.ams.service.article.ArticleService;
import com.kshrd.ams.utility.Paging;

@RestController
@RequestMapping("/api/v1")
public class ArticleRestController {
	
	private ArticleService articleService;
	
	public ArticleRestController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@GetMapping("/articles")
	public Map<String, Object> findAll(ArticleFilter filter, Paging paging) {
		List<Article> articles = articleService.findAllFilter(filter, paging);
		
		Map<String, Object> response = new HashMap<>();
		
		if (!articles.isEmpty()) {
			response.put("status", true);
			response.put("message", "Retrived data succesfully.");
			response.put("data", articles);
			response.put("paging", paging);
		} else {
			response.put("status", false);
			response.put("message", "There is no article.");
		}
		
		return response;
		
	}
	
	@GetMapping("/articles/{id}")
	public ResponseEntity<Map<String, Object>> findOne(@PathVariable int id) {
		Map<String, Object> response = new HashMap<>();
		
		Article article = articleService.findOne(id);
		
		if (article != null) {
			response.put("status", true);
			response.put("message", "Retrived data succesfully.");
			response.put("data", article);
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		} else {
			response.put("status", false);
			response.put("message", "Article not found!");
		}
		
		System.out.println(response);

		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		
	}
	
	@PostMapping("/articles")
	public Map<String, Object> save(@RequestBody Article article) {
		article.setCreatedDate(new Date().toString());
		Map<String, Object> response = new HashMap<>();
		
		if (articleService.add(article)) {
			response.put("status", true);
			response.put("message", "Data inserted successfully.");
		} else {
			response.put("status", false);
			response.put("message", "Inserte data failed!");
		}
		return response;
	}
	
	@PutMapping("/articles")
	public Article update(@RequestBody Article article) {
		articleService.update(article);
		return article;
	}
	
	@DeleteMapping("/articles/{a_id}")
	public boolean delete(@PathVariable("a_id") int id) {
		return articleService.delete(id);
	}
	
}








