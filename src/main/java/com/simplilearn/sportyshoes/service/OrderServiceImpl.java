package com.simplilearn.sportyshoes.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.entity.Order;
import com.simplilearn.sportyshoes.exception.SSException;
import com.simplilearn.sportyshoes.repo.OrderRepo;

@Service
@Transactional
public class OrderServiceImpl implements ShoesService<Order> {

	@Autowired
	private OrderRepo repo;
	
	@Override
	public Order add(Order order) throws SSException {

		if (order == null) throw new SSException("Order cannot be added - details provided are not valid !");
		
		return repo.save(order);
	}

	@Override
	public Order update(Order order) throws SSException {
		if (order == null) throw new SSException("Order cannot be updated - details provided are not valid !");
		return repo.save(order);
	}

	@Override
	public void delete(Integer id) throws SSException {
		if (id == null) throw new SSException("Order cannot be deleted - invalid Id !");
		repo.deleteById(id);

	}

	@Override
	public List<Order> getAll() {
		return repo.findAll();
	}

	@Override
	public Order getById(Integer id) throws SSException {
		if (id == null) throw new SSException("Order cannot be found - invalid Id !");
		return repo.findById(id).orElse(null);
	}

	public List<Order> getOrdersByCriteria(LocalDate orderDate, String category) {
		return repo.getOrdersByCriteria(category);
	}
	
}
