package com.practice.demo.services;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.models.Product;
import com.practice.demo.models.Review;
import com.practice.demo.repositories.ReviewInterface;

@Service
public class ReviewService {

	@Autowired
	private ReviewInterface reviewInterface;

	@Autowired
	private ProductService productService;

	public Review save(Integer productId, Review review) {
		Product product = productService.getById(productId);
		if (Objects.nonNull(product)) {
			review.setProduct(product);
			return reviewInterface.save(review);
		}
		return null;
	}

	private Review save(Review review) {
		return reviewInterface.save(review);
	}
	
	public List<Review> saveAll(Integer productId, List<Review> saveItems) {
		Product product = productService.getById(productId);
		if (Objects.nonNull(product)) {
			List<Review> reviewsWithProduct = saveItems.stream().map(review -> {
				review.setProduct(product);
				return review;
			}).collect(Collectors.toList());

			return reviewInterface.saveAll(reviewsWithProduct);
		}
		return Collections.emptyList();
	}

	public Review getProductReviewById(Integer id) {
		return reviewInterface.findById(id).orElse(null);
	}
	
	public Review getProductReviewByIdAndProductId(Integer id, Integer productId) {
		return reviewInterface.findByIdAndProductId(id, productId);
	}

	public List<Review> getAllProductReviews(Integer productId) {
		return reviewInterface.findAllByProductId(productId);
	}

	public List<Review> getAllProductReviewsByQuery(String query, Integer productId) {
		return reviewInterface.findByReviewCommentContainingAndProductId(query, productId);
	}

	public Review update(Integer productId, Integer id, Review review) {
		Review existing = getProductReviewById(id);
		if (Objects.isNull(existing) || !existing.getProduct().getId().equals(productId)) {
			return null;
		} else {
			existing.setId(id);
			existing.setRating(review.getRating());
			existing.setReviewComment(review.getReviewComment());
			return save(existing);
		}
	}

	public Boolean delete(Integer id, Integer productId) {
		reviewInterface.deleteByIdAndProductId(id, productId);
		return Objects.isNull(reviewInterface.findByIdAndProductId(id, productId));
	}

	public Boolean deleteByProductId(Integer productId) {
		reviewInterface.deleteAllByProductId(productId);
		return reviewInterface.findAllByProductId(productId).size() == 0;
	}
}
