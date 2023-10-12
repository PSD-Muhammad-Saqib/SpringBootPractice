package com.practice.demo.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.interfaces.ServiceActionsInterface;
import com.practice.demo.models.Category;
import com.practice.demo.repositories.CategoryInterface;

@Service
public class CategoryService implements ServiceActionsInterface<Category> {

	@Autowired
	private CategoryInterface categoryInterface;

	@Override
	public Category save(Category category) {
		return categoryInterface.save(category);
	}

	@Override
	public List<Category> saveAll(List<Category> saveItems) {
		return categoryInterface.saveAll(saveItems);
	}

	@Override
	public Category getById(Integer id) {
		return categoryInterface.findById(id).orElse(null);
	}

	@Override
	public List<Category> getAll() {
		return categoryInterface.findAll();
	}

	@Override
	public List<Category> getAllByQuery(String query) {
		return categoryInterface.findByCategoryNameContaining(query);
	}

	@Override
	public Category update(Integer id, Category category) {
		Category existing = getById(id);
		if (Objects.isNull(existing)) {
			return null;
		} else {
			existing.setId(id);
			existing.setCategoryName(category.getCategoryName());
			return save(existing);
		}
	}

	@Override
	public Boolean delete(Integer id) {
		categoryInterface.deleteById(id);
		return Objects.isNull(getById(id));
	}

}
