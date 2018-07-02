package com.kshrd.ams.repository.category;

import java.util.ArrayList;
import java.util.List;

import com.kshrd.ams.model.Category;

//@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	private List<Category> categories = new ArrayList<>();
	
	public CategoryRepositoryImpl() {
		categories.add(new Category(1, "Spring"));
		categories.add(new Category(2, "Java"));
		categories.add(new Category(3, "Web"));
		categories.add(new Category(4, "Database"));
		categories.add(new Category(5, "Korean"));
	}
	
	@Override
	public List<Category> findAll() {
		return categories;
	}

	@Override
	public Category findOne(int id) {
		for(Category c : categories) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

}
