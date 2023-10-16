package com.practice.demo.controllers.mvc;

import com.practice.demo.dtos.ProductDTO;
import com.practice.demo.helpers.ProductMVCPaths;
import com.practice.demo.helpers.ResponseHelpers;
import com.practice.demo.helpers.SupplierMVCPaths;
import com.practice.demo.interfaces.ControllerActionsInterface;
import com.practice.demo.models.Product;
import com.practice.demo.models.Supplier;
import com.practice.demo.services.CategoryService;
import com.practice.demo.services.ProductService;
import com.practice.demo.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("products")
public class MvcProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("suppliers", supplierService.getAll());
		return ProductMVCPaths.getSaveProductPath();
	}

	@GetMapping("edit/{id}")
	public String update(Model model, @PathVariable(name = "id", required = true) Integer id) {
		Product product = productService.getById(id);

		if (Objects.isNull(product)) {
			model.addAttribute("error", "Errors");
			return ProductMVCPaths.redirect();
		} else {
			model.addAttribute("product", product);
			model.addAttribute("categories", categoryService.getAll());
			model.addAttribute("suppliers", supplierService.getAll());
			return ProductMVCPaths.getSaveProductPath();
		}
	}

	@PostMapping("save")
	public String save(Model model, @Validated Product product) {
		if (Objects.isNull(product.getId())) {
			Product saved = productService.save(product);

			if (Objects.isNull(saved)) {
				model.addAttribute("error", "Errors");
				return ProductMVCPaths.redirect();
			} else {
				model.addAttribute("saved", true);
				return ProductMVCPaths.redirect(saved.getId());
			}
		} else {
			Product updated = productService.update(product.getId(), product);

			if (Objects.isNull(updated)) {
				model.addAttribute("error", "Errors");
			}
			return ProductMVCPaths.redirect(updated.getId());
		}
	}

	@GetMapping("/{id}")
	public String get(Model model, @PathVariable(name = "id", required = true) Integer id) {
		Product product = productService.getById(id);

		if (Objects.isNull(product)) {
			return ProductMVCPaths.redirect();
		} else {
			model.addAttribute("product", product);
			return ProductMVCPaths.getViewProductPath();
		}
	}

	@GetMapping(value = { "", "/" })
	public String getAll(Model model, @RequestParam(required = false, name = "query") String query) {
//		List<Product> products = new ArrayList<>();
//		if (Objects.isNull(query)) {
//			products = productService.getAll();
//		} else {
//			products = productService.getAllByQuery(query);
//		}
//
//		List<ProductDTO> productDTOs = products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
//				.collect(Collectors.toList());
		List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		return ProductMVCPaths.getAllProductsPath();
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Integer id) {
		Product product = productService.getById(id);

		if (Objects.isNull(product)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		}

		return ResponseEntity.ok(productService.delete(id));
	}

}
