package com.practice.demo.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.helpers.ResponseHelpers;
import com.practice.demo.interfaces.ControllerActionsInterface;
import com.practice.demo.models.Supplier;
import com.practice.demo.services.SupplierService;

@RestController
@RequestMapping("suppliers")
public class SupplierController implements ControllerActionsInterface<Supplier> {

	@Autowired
	private SupplierService supplierService;

	@Override
	@PostMapping("saveAll")
	public ResponseEntity<List<Supplier>> saveAll(@RequestBody(required = true) List<Supplier> saveItems) {
		return ResponseEntity.ok(supplierService.saveAll(saveItems));
	}

	@Override
	@PostMapping("save")
	public ResponseEntity<Supplier> save(@RequestBody(required = true) Supplier saveItem) {
		return ResponseEntity.ok(supplierService.save(saveItem));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable(name = "id", required = true) Integer id) {
		Supplier supplier = supplierService.getById(id);

		if (Objects.isNull(supplier)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Supplier.class.getName(), id));
		} else {
			return ResponseEntity.ok(supplier);
		}
	}

	@Override
	@GetMapping(value = {"", "/"})
	public ResponseEntity<?> getAll(@RequestParam(required = false, name = "query") String query) {
		if (Objects.isNull(query)) {
			return ResponseEntity.ok(supplierService.getAll());
		}
		return ResponseEntity.ok(supplierService.getAllByQuery(query));
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id,
			@RequestBody(required = true) Supplier updateItem) {
		Supplier supplier = supplierService.update(id, updateItem);

		if (Objects.isNull(supplier)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ResponseHelpers.notFoundResponse(Supplier.class.getName().toString(), id));
		} else {
			return ResponseEntity.ok(supplier);
		}
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Integer id) {
		Supplier supplier = supplierService.getById(id);

		if (Objects.isNull(supplier)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		}
		
		return ResponseEntity.ok(supplierService.delete(id));
	}

}
