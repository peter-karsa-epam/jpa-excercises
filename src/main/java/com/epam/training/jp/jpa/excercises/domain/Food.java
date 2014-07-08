package com.epam.training.jp.jpa.excercises.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Food {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int calories;
	private int price;
	private boolean isVegan;

	public Food() {
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getCalories() {
		return calories;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isVegan() {
		return isVegan;
	}

	public void setVegan(boolean isVegan) {
		this.isVegan = isVegan;
	}

}
