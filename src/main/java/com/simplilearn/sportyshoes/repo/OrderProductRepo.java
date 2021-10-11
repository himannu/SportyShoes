package com.simplilearn.sportyshoes.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.entity.OrderProduct;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Integer> {

}
