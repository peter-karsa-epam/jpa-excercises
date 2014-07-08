package com.epam.training.jp.jpa.excercises.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue
	private int id;
	private String customer;
	@OneToMany
	private List<OrderItem> createOrderItems;
	@OneToOne
	private Address address;
	@Enumerated(EnumType.STRING)
	private OrderState pending;

	public FoodOrder() {
	}

	public FoodOrder(List<OrderItem> createOrderItems, Address address,
			String customer, OrderState pending) {
		this.createOrderItems = createOrderItems;
		this.address = address;
		this.customer = customer;
		this.pending = pending;
	}

	public List<OrderItem> getCreateOrderItems() {
		return createOrderItems;
	}

	public void setCreateOrderItems(List<OrderItem> createOrderItems) {
		this.createOrderItems = createOrderItems;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public OrderState getPending() {
		return pending;
	}

	public void setPending(OrderState pending) {
		this.pending = pending;
	}

	public List<OrderItem> getOrderItems() {
		return createOrderItems;
	}

}
