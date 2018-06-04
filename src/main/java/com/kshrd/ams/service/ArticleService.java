package com.kshrd.ams.service;

import java.util.List;

import com.kshrd.ams.model.Article;

public interface ArticleService {

	void add(Article article);
	Article findOne(int id);
	List<Article> findAll();
	void delete(int id);
	
}
