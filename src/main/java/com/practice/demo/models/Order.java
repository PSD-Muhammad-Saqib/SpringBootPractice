package com.practice.demo.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
//	OrderID	CustomerID	EmployeeID	OrderDate	ShipperID	OrderDetailID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true)
	private Date orderDate;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "order_detail_id", nullable = true, referencedColumnName = "id")
	private OrderDetail orderDetail;

	public Order() {
	}

	public Order(Integer id, Date orderDate, OrderDetail orderDetail) {
		this.id = id;
		this.orderDate = orderDate;
		this.orderDetail = orderDetail;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", orderDetail=" + orderDetail + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

}
