package com.practice.demo.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.interfaces.ServiceActionsInterface;
import com.practice.demo.models.Supplier;
import com.practice.demo.repositories.SupplierInterface;

@Service
public class SupplierService implements ServiceActionsInterface<Supplier> {

	@Autowired
	private SupplierInterface supplierInterface;

	@Override
	public Supplier save(Supplier supplier) {
		return supplierInterface.save(supplier);
	}

	@Override
	public List<Supplier> saveAll(List<Supplier> saveItems) {
		return supplierInterface.saveAll(saveItems);
	}

	@Override
	public Supplier getById(Integer id) {
		return supplierInterface.findById(id).orElse(null);
	}

	@Override
	public List<Supplier> getAll() {
		return supplierInterface.findAll();
	}

	@Override
	public List<Supplier> getAllByQuery(String query) {
		return supplierInterface.findBySupplierNameContaining(query);
	}

	@Override
	public Supplier update(Integer id, Supplier supplier) {
		Supplier existing = getById(id);
		if (Objects.isNull(existing)) {
			return null;
		} else {
			existing.setSupplierName(supplier.getSupplierName());
			existing.setCountry(supplier.getCountry());
			existing.setPostalCode(supplier.getPostalCode());
			existing.setSupplierAddress(supplier.getSupplierAddress());
			existing.setSupplierCity(supplier.getSupplierCity());
			return save(existing);
		}
	}

	@Override
	public Boolean delete(Integer id) {
		supplierInterface.deleteById(id);
		return Objects.isNull(getById(id));
	}

}
