package com.practice.demo.dtos;

import java.util.List;

import com.practice.demo.models.Review;

public class ProductDTO {
	private Integer id;
	private String productName;
	private Double price;
	private Integer supplierId;
	private Integer categoryId;
	private List<Review> reviews;

	public ProductDTO() {
	}

	public ProductDTO(Integer id, String productName, Double price, Integer supplierId, Integer categoryId, List<Review> reviews) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", productName=" + productName + ", price=" + price + ", supplierId="
				+ supplierId + ", categoryId=" + categoryId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
