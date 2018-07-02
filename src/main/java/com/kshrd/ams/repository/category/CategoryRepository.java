package com.kshrd.ams.repository.category;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kshrd.ams.model.Category;

@Repository
public interface CategoryRepository {

	@Select("SELECT id, name FROM tb_categories ORDER BY id ASC")
	public List<Category> findAll();
	
	@Select("SELECT id, name FROM tb_categories WHERE id=#{id}")
	public Category findOne(int id);
	
}
