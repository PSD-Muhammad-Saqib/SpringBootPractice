package com.practice.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.models.Category;

@Repository
public interface CategoryInterface extends JpaRepository<Category, Integer> {
	List<Category> findByCategoryNameContaining(String categoryName);
}
