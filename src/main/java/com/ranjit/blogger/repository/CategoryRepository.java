package com.ranjit.blogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjit.blogger.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	
	

}
