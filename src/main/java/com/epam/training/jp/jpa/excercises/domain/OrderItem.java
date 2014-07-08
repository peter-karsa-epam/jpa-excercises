package com.epam.training.jp.jpa.excercises.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	@OneToOne
	private Food food;

	public OrderItem() {
	}

	public OrderItem(Food food, Integer quantity) {
		this.food = food;
		this.quantity = quantity;
	}

	public Food getFood() {
		return food;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setFood(Food food) {
		this.food = food;
	}

}
