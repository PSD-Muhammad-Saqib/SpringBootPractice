package com.practice.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "suppliers")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable = false)
	private String supplierName;
	private String supplierAddress;
	
	@Column(nullable = false)
	private String supplierCity;
	private String postalCode;
	
	@Column(nullable = false)
	private String country;
	
	public Supplier() {
	}
	
	public Supplier(Integer id, String supplierName, String supplierAddress, String supplierCity, String postalCode,
			String country) {
		this.id = id;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.supplierCity = supplierCity;
		this.postalCode = postalCode;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", supplierName=" + supplierName + ", supplierAddress=" + supplierAddress
				+ ", supplierCity=" + supplierCity + ", postalCode=" + postalCode + ", country=" + country + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierCity() {
		return supplierCity;
	}

	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
