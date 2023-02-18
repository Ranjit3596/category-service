package com.ranjit.blogger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranjit.blogger.dto.ApiResponse;
import com.ranjit.blogger.dto.Category;
import com.ranjit.blogger.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/createCategory")
	public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
		categoryService.createCategory(category);
		return new ResponseEntity<>(new ApiResponse("Category created successfully", true), HttpStatus.CREATED);

	}
	
	@PutMapping("/updateCategory")
	public ResponseEntity<ApiResponse> updateCategory(Category category,Integer categoryId) {
		categoryService.getCategoryById(categoryId);
		return null;

	}
	@GetMapping("/getCategoryById/{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId") Integer categoryId) {
		Category category = categoryService.getCategoryById(categoryId);
		return  category;

	}
	@DeleteMapping("/deleteCategoryById/{id}")
	public ResponseEntity<ApiResponse> deleteCategoryById(Integer categoryId) {
		 // return new ResponseEntity<>(new ApiResponse("Category created successfully", true), HttpStatus.CREATED);;
		return null;
	}
	@GetMapping("/getAllCategory")
	public ResponseEntity<ApiResponse> getAllCategory() {
		return null;

	}
}
