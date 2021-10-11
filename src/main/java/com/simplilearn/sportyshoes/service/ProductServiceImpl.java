package com.simplilearn.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.entity.Product;
import com.simplilearn.sportyshoes.exception.SSException;
import com.simplilearn.sportyshoes.repo.ProductRepo;

@Service
public  class ProductServiceImpl implements ShoesService<Product> {

	@Autowired
	private ProductRepo repo;
	
	@Override
	public Product add(Product product) throws SSException {
		
		if (product == null) throw new SSException("Product cannot be added - details provided are not valid !");
		return repo.save(product);
	
	}

	@Override
	public Product update(Product product) throws SSException {
		if (product == null) throw new SSException("Product cannot be updated - details provided are not valid !");
		return repo.save(product);
	}

	@Override
	public void delete(Integer id) throws SSException {
		if (id == null) throw new SSException("Product cannot be deleted - invalid Id !");
		repo.deleteById(id);
		
	}

	@Override
	public List<Product> getAll() {
		return repo.findAll();
	}

	@Override
	public Product getById(Integer id) throws SSException {
		if (id == null) throw new SSException("Product cannot be found - invalid Id !");
		return repo.findById(id).orElse(null);
	}

	public List<Product> getByCategory(Integer categoryId) throws SSException {
		if (categoryId == null) throw new SSException("Product cannot be found - invalid Id !");
		return repo.findByCategory(categoryId);
	}
}
