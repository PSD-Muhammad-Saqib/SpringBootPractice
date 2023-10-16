package com.practice.demo.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.demo.helpers.CategoryMVCPaths;
import com.practice.demo.models.Category;
import com.practice.demo.services.CategoryService;


@Controller
@RequestMapping("categories")
public class MvcCategoryController {

	@Autowired
	private CategoryService categoryService;

//	@PostMapping("saveAll")
//	public ResponseEntity<List<Category>> saveAll(@RequestBody(required = true) List<Category> saveItems) {
//		return ResponseEntity.ok(categoryService.saveAll(saveItems));
//	}

	@PostMapping("add")
	public String add(Model model ) {
		return CategoryMVCPaths.getAddCategoryPath();
	}
	
	@PostMapping("save")
	public ResponseEntity<Category> save(@RequestBody(required = true) Category saveItem) {
		return ResponseEntity.ok(categoryService.save(saveItem));
	}

	@GetMapping("/{id}")
	public String get(Model model, @PathVariable(name = "id", required = true) Integer id) {
		Category category = categoryService.getById(id);
//
//		if (Objects.isNull(category)) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					.body(ResponseHelpers.notFoundResponse(Category.class.getName(), id));
//		} else {
//		}
	    model.addAttribute("category", category);

		return CategoryMVCPaths.getViewCategoryPath();
	}

	@GetMapping(value = { "", "/" })
	public String getAll(Model model, @RequestParam(required = false, name = "query") String query) {
		System.out.println("In Category Home!!!!");
//		if (Objects.isNull(query)) {
//			return ResponseEntity.ok(categoryService.getAll());
//		}
//		return ResponseEntity.ok(categoryService.getAllByQuery(query));
		model.addAttribute("categories", categoryService.getAll());

		return CategoryMVCPaths.getAllCategoriesPath();
	}
//
//	@Override
//	@PutMapping("/{id}")
//	public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id,
//			@RequestBody(required = true) Category updateItem) {
//		Category category = categoryService.update(id, updateItem);
//
//		if (Objects.isNull(category)) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					.body(ResponseHelpers.notFoundResponse(Category.class.getName().toString(), id));
//		} else {
//			return ResponseEntity.ok(category);
//		}
//	}
//
//	@Override
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Integer id) {
//		Category category = categoryService.getById(id);
//
//		if (Objects.isNull(category)) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
//		}
//		
//		return ResponseEntity.ok(categoryService.delete(id));
//	}

}
