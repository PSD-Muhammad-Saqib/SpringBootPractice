package com.practice.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

import com.practice.demo.dtos.ProductDTO;
import com.practice.demo.helpers.ResponseHelpers;
import com.practice.demo.interfaces.ControllerActionsInterface;
import com.practice.demo.models.Product;
import com.practice.demo.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController implements ControllerActionsInterface<Product> {

	@Autowired
	private ProductService productService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	@PostMapping("saveAll")
	public ResponseEntity<List<Product>> saveAll(@RequestBody(required = true) List<Product> saveItems) {
		return ResponseEntity.ok(productService.saveAll(saveItems));
	}

	@Override
	@PostMapping("save")
	public ResponseEntity<Product> save(@RequestBody(required = true) Product saveItem) {
		return ResponseEntity.ok(productService.save(saveItem));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable(name = "id", required = true) Integer id) {
		Product product = productService.getById(id);

		if (Objects.isNull(product)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Product.class.getName(), id));
		} else {
			ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
			return ResponseEntity.ok(productDTO);
		}
	}

	@Override
	@GetMapping(value = { "", "/" })
	public ResponseEntity<?> getAll(@RequestParam(required = false, name = "query") String query) {
		List<Product> products = new ArrayList<>();
		if (Objects.isNull(query)) {
			products = productService.getAll();
		} else {
			products = productService.getAllByQuery(query);
		}

		List<ProductDTO> productDTOs = products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok(productDTOs);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id,
			@RequestBody(required = true) Product updateItem) {
		Product product = productService.update(id, updateItem);

		if (Objects.isNull(product)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Product.class.getName().toString(), id));
		} else {
			return ResponseEntity.ok(product);
		}
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Integer id) {
		Product product = productService.getById(id);

		if (Objects.isNull(product)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		}

		return ResponseEntity.ok(productService.delete(id));
	}

}
