package com.kshrd.ams.repository;

import java.util.List;

import com.kshrd.ams.model.Article;

public interface ArticleRepository {

	void add(Article article);
	Article findOne(int id);
	List<Article> findAll();
	void delete(int id);
	
}
