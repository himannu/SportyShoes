package com.simplilearn.sportyshoes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
