package com.practice.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.demo.models.Review;

import jakarta.transaction.Transactional;

@Repository
public interface ReviewInterface extends JpaRepository<Review, Integer> {

	public List<Review> findByReviewCommentAndProduct_Id(String reviewComment, Integer productId);

	public List<Review> findAllByProduct_Id(Integer productId);

	@Query("SELECT r FROM Review r WHERE r.id = :id AND r.product.id = :productId")
	Review findByIdAndProductId(@Param("id") Integer id, @Param("productId") Integer productId);

	@Modifying
	@Transactional
	@Query("DELETE FROM Review r WHERE r.id = :id AND r.product.id = :productId")
	void deleteByIdAndProductId(@Param("id") Integer id, @Param("productId") Integer productId);

	@Transactional
	public void deleteAllByProduct_Id(Integer productId);

}
