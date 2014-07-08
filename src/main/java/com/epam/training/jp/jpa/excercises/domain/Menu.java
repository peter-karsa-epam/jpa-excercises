package com.epam.training.jp.jpa.excercises.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Menu {
	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	private Date toDate;
	@OneToMany
	private List<Food> foods;

	public Menu() {
	}

	public List<Food> getFoods() {
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

}
