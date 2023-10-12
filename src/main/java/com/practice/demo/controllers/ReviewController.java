package com.practice.demo.controllers;

import java.util.ArrayList;
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
import com.practice.demo.models.Product;
import com.practice.demo.models.Review;
import com.practice.demo.services.ProductService;
import com.practice.demo.services.ReviewService;

@RestController
@RequestMapping("products/{productId}/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private ProductService productService;

	@PostMapping("saveAll")
	public ResponseEntity<List<Review>> saveAll(@PathVariable(name = "productId", required = true) Integer productId,
			@RequestBody(required = true) List<Review> saveItems) {
		return ResponseEntity.ok(reviewService.saveAll(productId, saveItems));
	}

	@PostMapping("save")
	public ResponseEntity<Review> save(@PathVariable(name = "productId", required = true) Integer productId,
			@RequestBody(required = true) Review saveItem) {
		return ResponseEntity.ok(reviewService.save(productId, saveItem));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductReviewById(@PathVariable(name = "productId", required = true) Integer productId,
			@PathVariable(name = "id", required = true) Integer id) {

		Product product = productService.getById(productId);
		if (Objects.isNull(product)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Product.class.getName(), productId));
		}

		Review review = reviewService.getProductReviewById(id);
		if (Objects.isNull(review)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Review.class.getName(), id));
		} else {
			return ResponseEntity.ok(review);
		}
	}

	@GetMapping(value = { "", "/" })
	public ResponseEntity<?> getAll(@PathVariable(name = "productId", required = true) Integer productId,
			@RequestParam(required = false, name = "query") String query) {

		Product product = productService.getById(productId);
		if (Objects.isNull(product)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Product.class.getName(), productId));
		}

		System.out.println("================================");
		System.out.println(product.toString());
		System.out.println(query);
		System.out.println("================================");

		List<Review> reviews = new ArrayList<>();
		if (Objects.isNull(query)) {
			reviews = reviewService.getAllProductReviews(productId);
		} else {
			reviews = reviewService.getAllProductReviewsByQuery(query, productId);
		}
		return ResponseEntity.ok(reviews);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "productId", required = true) Integer productId,
			@PathVariable(name = "id", required = true) Integer id, @RequestBody(required = true) Review updateItem) {

		Product product = productService.getById(productId);
		if (Objects.isNull(product)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Product.class.getName(), productId));
		}

		Review review = reviewService.update(productId, id, updateItem);

		if (Objects.isNull(review)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					ResponseHelpers.notFoundResponse(Product.class.getName(), productId, Review.class.getName(), id));
		} else {
			return ResponseEntity.ok(review);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "productId", required = true) Integer productId,
			@PathVariable(name = "id", required = true) Integer id) {
		Review review = reviewService.getProductReviewByIdAndProductId(id, productId);

		if (Objects.isNull(review)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					ResponseHelpers.notFoundResponse(Product.class.getName(), productId, Review.class.getName(), id));
		}

		return ResponseEntity.ok(reviewService.delete(id, productId));
	}

	@DeleteMapping(value = { "", "/" })
	public ResponseEntity<?> deleteAllReviews(
			@PathVariable(name = "productId", required = true) Integer productId) {
		Product product = productService.getById(productId);
		if (Objects.isNull(product)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Product.class.getName(), productId));
		}
		return ResponseEntity.ok(reviewService.deleteByProductId(productId));
	}

}
