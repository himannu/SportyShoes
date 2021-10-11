package com.simplilearn.sportyshoes.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="order_product")
public class OrderProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderProductPk orderProductId;
	
	private Long quantity;

	
	public OrderProduct() {
		
	}
	
	
	public OrderProduct(Order order, Product product, Long quantity) {
		super();
		orderProductId = new OrderProductPk(order, product);
		this.quantity = quantity;
	}

	public Product getProduct() {
		return orderProductId.getProduct();
	}

	public Double getPricePerProduct() {
		return getProduct().getPrice()*getQuantity();
	}
	
	public void setOrderProductId(OrderProductPk orderProductId) {
		this.orderProductId = orderProductId;
	}


	public OrderProductPk getOrderProductId() {
		return this.orderProductId;
	}

	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderProductId == null) ? 0 : orderProductId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderProduct other = (OrderProduct) obj;
		if (orderProductId == null) {
			if (other.orderProductId != null)
				return false;
		} else if (!orderProductId.equals(other.orderProductId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "OrderProduct [orderProductId=" + orderProductId + ", quantity=" + quantity + "]";
	}
	
	
}
