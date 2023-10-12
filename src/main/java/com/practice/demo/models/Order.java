package com.practice.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
//	OrderID	CustomerID	EmployeeID	OrderDate	ShipperID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
}
