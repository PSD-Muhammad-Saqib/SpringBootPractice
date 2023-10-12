package com.practice.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.models.Supplier;

@Repository
public interface SupplierInterface extends JpaRepository<Supplier, Integer> {
	List<Supplier> findBySupplierNameContaining(String supplierName);
}
