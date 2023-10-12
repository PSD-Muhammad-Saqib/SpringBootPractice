package com.practice.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetail {

//OrderDetailID	OrderID	ProductID	Quantity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
}
