package com.practice.demo.controllers;

import java.util.List;
import java.util.Objects;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.helpers.ResponseHelpers;
import com.practice.demo.interfaces.ControllerActionsInterface;
import com.practice.demo.models.Category;
import com.practice.demo.services.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController implements ControllerActionsInterface<Category> {

	@Autowired
	private CategoryService categoryService;

	@Override
	@PostMapping("saveAll")
	public ResponseEntity<List<Category>> saveAll(@RequestBody(required = true) List<Category> saveItems) {
		return ResponseEntity.ok(categoryService.saveAll(saveItems));
	}

	@Override
	@PostMapping("save")
	public ResponseEntity<Category> save(@RequestBody(required = true) Category saveItem) {
		return ResponseEntity.ok(categoryService.save(saveItem));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable(name = "id", required = true) Integer id) {
		Category category = categoryService.getById(id);

		if (Objects.isNull(category)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Category.class.getName(), id));
		} else {
			return ResponseEntity.ok(category);
		}
	}

	@Override
	@GetMapping(value = {"", "/"})
	public ResponseEntity<?> getAll(@RequestParam(required = false, name = "query") String query) {
		if (Objects.isNull(query)) {
			return ResponseEntity.ok(categoryService.getAll());
		}
		return ResponseEntity.ok(categoryService.getAllByQuery(query));
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id,
			@RequestBody(required = true) Category updateItem) {
		Category category = categoryService.update(id, updateItem);

		if (Objects.isNull(category)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Category.class.getName().toString(), id));
		} else {
			return ResponseEntity.ok(category);
		}
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Integer id) {
		Category category = categoryService.getById(id);

		if (Objects.isNull(category)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		}
		
		return ResponseEntity.ok(categoryService.delete(id));
	}

}
