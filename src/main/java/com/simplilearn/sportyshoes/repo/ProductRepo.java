package com.simplilearn.sportyshoes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query("from Product p where p.category.id = :categoryId")
	List<Product> findByCategory(Integer categoryId);
	
}
