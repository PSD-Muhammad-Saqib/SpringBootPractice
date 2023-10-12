package com.practice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.models.Product;

@Repository
public interface ProductInterface extends JpaRepository<Product, Integer>{

}
