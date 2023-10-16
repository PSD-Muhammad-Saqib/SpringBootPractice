package com.practice.demo.controllers.mvc;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("category", new Category());
		return CategoryMVCPaths.getAddCategoryPath();
	}

	@PostMapping("save")
	public String save(Model model, @Validated Category category) {
		Category saved = categoryService.save(category);
		if (Objects.isNull(saved)) {
			model.addAttribute("error", "Errors");
			return CategoryMVCPaths.redirect();
		} else {
			model.addAttribute("saved", true);
			return CategoryMVCPaths.redirect(saved.getId());
		}
	}

	@GetMapping("/{id}")
	public String get(Model model, @PathVariable(name = "id", required = true) Integer id) {
		Category category = categoryService.getById(id);

		if (Objects.isNull(category)) {
			return CategoryMVCPaths.redirect();
		} else {
			model.addAttribute("category", category);
			return CategoryMVCPaths.getViewCategoryPath();
		}
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

	@GetMapping("edit/{id}")
	public String edit(Model model, @PathVariable(name = "id", required = true) Integer id) {
		Category category = categoryService.getById(id);

		if (Objects.isNull(category)) {
			model.addAttribute("error", "Errors");
			return CategoryMVCPaths.redirect();
		} else {
			model.addAttribute("category", category);
			return CategoryMVCPaths.getEditCategoryPath();
		}
	}

	@PostMapping("update/{id}")
	public String update(Model model, @PathVariable(name = "id", required = true) Integer id,
			@Validated Category updateItem) {
		Category category = categoryService.update(id, updateItem);

		if (Objects.isNull(category)) {
			model.addAttribute("error", "Errors");
		}
		return CategoryMVCPaths.redirect();
	}

	@GetMapping("delete/{id}")
	public String delete(Model model, @PathVariable(name = "id", required = true) Integer id) {
		Category category = categoryService.getById(id);

		if (Objects.isNull(category)) {
			model.addAttribute("error", "Errors");
		} else {
			Boolean res = categoryService.delete(id);
			model.addAttribute("delete", res);
		}
		return CategoryMVCPaths.redirect();
	}

}
