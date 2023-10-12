package com.practice.demo.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ControllerActionsInterface<E> {

	public ResponseEntity<List<E>> saveAll(@RequestBody(required = true) List<E> saveItems);

	public ResponseEntity<E> save(@RequestBody(required = true) E saveItem);

	public ResponseEntity<?> get(@PathVariable(name = "id", required = true) Integer id);

	public ResponseEntity<?> getAll(@RequestParam(required = false, name = "query") String query);

	public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id,
			@RequestBody(required = true) E updateItem);

	public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Integer id);

}
