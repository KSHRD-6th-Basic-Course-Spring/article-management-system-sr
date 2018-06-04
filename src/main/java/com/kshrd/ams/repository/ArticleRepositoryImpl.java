package com.kshrd.ams.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.kshrd.ams.model.Article;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

	private List<Article> articles = new ArrayList<>();
	
	public ArticleRepositoryImpl() {
		Faker f = new Faker();
		articles.add(new Article(1, f.book().title(), f.book().title(), f.artist().name(), new Date().toString()));
		articles.add(new Article(2, f.book().title(), f.book().title(), f.artist().name(), new Date().toString()));
		articles.add(new Article(3, f.book().title(), f.book().title(), f.artist().name(), new Date().toString()));
		articles.add(new Article(4, f.book().title(), f.book().title(), f.artist().name(), new Date().toString()));
		articles.add(new Article(5, f.book().title(), f.book().title(), f.artist().name(), new Date().toString()));
		articles.add(new Article(6, f.book().title(), f.book().title(), f.artist().name(), new Date().toString()));
		articles.add(new Article(7, f.book().title(), f.book().title(), f.artist().name(), new Date().toString()));
		articles.add(new Article(8, f.book().title(), f.book().title(), f.artist().name(), new Date().toString()));	
	}
	
	@Override
	public void add(Article article) {
		articles.add(article);
	}

	@Override
	public Article findOne(int id) {
		for(Article article : articles) {
			if(article.getId() == id)
				return article;
		}
		return null;
	}

	@Override
	public List<Article> findAll() {
		return articles;
	}
	
	@Override
	public void delete(int id) {
		for(Article article : articles) {
			if(article.getId() == id) {
				articles.remove(article);
				return;
			}
		}
	}
	
}
