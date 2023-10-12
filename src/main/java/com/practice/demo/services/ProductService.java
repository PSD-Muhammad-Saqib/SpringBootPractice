package com.practice.demo.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.interfaces.ServiceActionsInterface;
import com.practice.demo.models.Product;
import com.practice.demo.repositories.ProductInterface;

@Service
public class ProductService implements ServiceActionsInterface<Product> {

	@Autowired
	private ProductInterface productInterface;

	@Override
	public Product save(Product product) {
		return productInterface.save(product);
	}

	@Override
	public List<Product> saveAll(List<Product> saveItems) {
		return productInterface.saveAll(saveItems);
	}

	@Override
	public Product getById(Integer id) {
		return productInterface.findById(id).orElse(null);
	}

	@Override
	public List<Product> getAll() {
		return productInterface.findAll();
	}

	@Override
	public List<Product> getAllByQuery(String query) {
		return productInterface.findByProductNameContaining(query);
	}

	@Override
	public Product update(Integer id, Product product) {
		Product existing = getById(id);
		if (Objects.isNull(existing)) {
			return null;
		} else {
			existing.setId(id);
			existing.setPrice(product.getPrice());
			existing.setProductName(product.getProductName());
			existing.setCategory(product.getCategory());
			existing.setSupplier(product.getSupplier());
			return save(existing);
		}
	}

	@Override
	public Boolean delete(Integer id) {
		productInterface.deleteById(id);
		return Objects.isNull(getById(id));
	}

}
