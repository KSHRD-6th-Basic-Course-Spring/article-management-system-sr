package com.kshrd.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepo;
	
	@Override
	public void add(Article article) {
		articleRepo.add(article);
	}

	@Override
	public Article findOne(int id) {
		return articleRepo.findOne(id);
	}

	@Override
	public List<Article> findAll() {
		return articleRepo.findAll();
	}
	
	@Override
	public void delete(int id) {
		articleRepo.delete(id);
	}
	
}
