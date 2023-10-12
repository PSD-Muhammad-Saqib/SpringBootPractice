package com.practice.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.interfaces.ControllerActionsInterface;
import com.practice.demo.models.Product;

@RestController
@RequestMapping("products")
public class ProductController implements ControllerActionsInterface<Product>{

	@Override
	public ResponseEntity<List<Product>> saveAll(List<Product> saveItems) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Product> save(Product saveItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getAll(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> update(Integer id, Product updateItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Boolean> delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
