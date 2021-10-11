package com.simplilearn.sportyshoes.service;

import java.util.List;

import com.simplilearn.sportyshoes.exception.SSException;

public interface ShoesService<T> {
	T add(T t) throws SSException ;
	T update(T t) throws SSException;
	void delete(Integer id) throws SSException;
	List<T> getAll();
	T getById(Integer id) throws SSException;
	
}
