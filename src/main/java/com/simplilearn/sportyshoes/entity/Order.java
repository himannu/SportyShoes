package com.simplilearn.sportyshoes.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer orderId;
	
	@OneToOne
	private User user;
	
	@OneToMany(mappedBy="orderProductId.order", cascade = CascadeType.ALL)
	private List<OrderProduct> orderProducts = new ArrayList<>();
	
	private LocalDate orderDate;
	
	private String status;
	
	public Order() {
		
	}
	
	public Order(User user, List<OrderProduct> orderProducts, LocalDate orderDate, String status) {
		super();
		this.user = user;
		this.orderProducts = orderProducts;
		this.orderDate = orderDate;
		this.status = status;
	}

	public Double getTotalOrderPrice() {
		return orderProducts.stream().collect(Collectors.summingDouble(orderProduct -> orderProduct.getPricePerProduct())); 
	}
	
	public Long getNumberOfProducts() {
		return orderProducts.stream().collect(Collectors.summingLong(orderProduct -> orderProduct.getQuantity())); 
	}
	
	public List<Product> getProducts() {
		return orderProducts.stream().map(orderProd->orderProd.getProduct()).collect(Collectors.toList());
	}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", orderDate=" + orderDate + ", status=" + status + "]";
	}
	
	
	
}
