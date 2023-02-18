package com.ranjit.blogger.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranjit.blogger.Exception.CategoryNotFoundException;
import com.ranjit.blogger.dto.Category;

import com.ranjit.blogger.entity.CategoryEntity;
import com.ranjit.blogger.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public Category createCategory(Category category) {
		CategoryEntity categoryEntity = this.mapper.map(category, CategoryEntity.class);
		categoryEntity = categoryRepo.save(categoryEntity);
		category = this.mapper.map(categoryEntity, Category.class);
		return category;
	}

	@Override
	public Category updateCategory(Category category, Integer categoryId) {
		CategoryEntity categoryEntity = categoryRepo.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("Category", "id", categoryId));
		category = this.mapper.map(categoryEntity, Category.class);
		return category;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		categoryRepo.deleteById(categoryId);
	}

	@Override
	public Category getCategoryById(Integer categoryId) {
		CategoryEntity categoryEntity = categoryRepo.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("Category", "id", categoryId));
		Category category = this.mapper.map(categoryEntity, Category.class);
		return category;
	}

	@Override
	public List<Category> getAllCategory() {
		List<CategoryEntity> categoryEntity = categoryRepo.findAll();
		List<Category> listOfCategory = categoryEntity.stream().map(userEntity -> {
			Category user = new Category();
			user.setCategoryId(userEntity.getCategoryId());
			user.setCategoryTitle(userEntity.getCategoryTitle());
			user.setCategoryDescription(userEntity.getCategoryDescription());
			return user;
		}).collect(Collectors.toList());
		return listOfCategory;
	}
}
