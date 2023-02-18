package com.ranjit.blogger.service;

import java.util.List;

import com.ranjit.blogger.dto.Category;

public interface CategoryService {

	Category createCategory(Category category);

	Category updateCategory(Category category, Integer categoryId);

	void deleteCategory(Integer categoryId);

	Category getCategoryById(Integer categoryId);

	List<Category> getAllCategory();

}
