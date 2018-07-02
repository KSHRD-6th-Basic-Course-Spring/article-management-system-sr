package com.kshrd.ams.service.article;

import java.util.List;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.model.ArticleFilter;
import com.kshrd.ams.utility.Paging;

public interface ArticleService {

	boolean add(Article article);
	Article findOne(int id);
	List<Article> findAll();
	boolean delete(int id);
	boolean update(Article article);
	
	List<Article> findAllFilter(ArticleFilter filter, Paging paging);
	
}
