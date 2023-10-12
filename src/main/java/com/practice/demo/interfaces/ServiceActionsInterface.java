package com.practice.demo.interfaces;

import java.util.List;

public interface ServiceActionsInterface<E> {

	public E save(E newObj);
	public List<E> saveAll(List<E> saveItems);
	
	public E getById(Integer id);
	public List<E> getAll();
	public List<E> getAllByQuery(String query);
	
	public E update(Integer id, E existingObj);
	public Boolean delete(Integer id);
	
}
