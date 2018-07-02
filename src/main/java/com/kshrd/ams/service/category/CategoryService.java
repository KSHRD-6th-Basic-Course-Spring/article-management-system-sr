package com.kshrd.ams.service.category;

import java.util.List;

import com.kshrd.ams.model.Category;

public interface CategoryService {
	
	List<Category> findAll();
	Category findOne(int id);
	
}
