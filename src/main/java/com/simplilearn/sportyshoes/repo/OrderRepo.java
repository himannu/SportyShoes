package com.simplilearn.sportyshoes.repo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
	
	@Query("from Order o join o.orderProducts q where q.orderProductId.product.category.name like %:category%")
	public List<Order> getOrdersByCriteria(String category);

}
