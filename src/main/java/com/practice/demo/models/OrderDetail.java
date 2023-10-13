package com.practice.demo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetail {

//OrderDetailID	OrderID	ProductID	Quantity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer quantity;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
	private Product product;

	@OneToOne(fetch = FetchType.LAZY, optional = false, mappedBy = "orderDetail")
	private Order order;

	public OrderDetail() {
	}

	public OrderDetail(Integer id, Integer quantity, Product product, Order order) {
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", quantity=" + quantity + ", product=" + product + ", order=" + order + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
