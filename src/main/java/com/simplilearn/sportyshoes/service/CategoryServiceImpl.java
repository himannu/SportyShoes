package com.simplilearn.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.entity.Category;
import com.simplilearn.sportyshoes.exception.SSException;
import com.simplilearn.sportyshoes.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements ShoesService<Category>{

	@Autowired
	private CategoryRepo repo;

	@Override
	public Category add(Category category) throws SSException {
		if (category == null) throw new SSException("Category cannot be added - details provided are not valid !");
		return repo.save(category);
	}

	@Override
	public Category update(Category category) throws SSException {
		if (category == null) throw new SSException("Category cannot be updated - details provided are not valid !");
		return repo.save(category);
	}

	@Override
	public void delete(Integer id) throws SSException {
		if (id == null) throw new SSException("Category cannot be deleted - invalid Id !");
		repo.deleteById(id);		
	}

	@Override
	public List<Category> getAll() {
		return repo.findAll();
	}

	@Override
	public Category getById(Integer id) throws SSException {
		if (id == null) throw new SSException("Category cannot be found - invalid Id !");
		return repo.findById(id).orElse(null);

	}

	
}
