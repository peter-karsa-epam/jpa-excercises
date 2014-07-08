package com.epam.training.jp.jpa.excercises.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private int id;
	private String country;
	private String city;
	private String street;
	private String zipCode;

	public Address() {
	}

	public void setCountry(String readLine) {
		this.country = readLine;
	}

	public void setCity(String readLine) {
		this.city = readLine;
	}

	public void setStreet(String readLine) {
		this.street = readLine;
	}

	public void setZipCode(String readLine) {
		this.zipCode = readLine;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getZipCode() {
		return zipCode;
	}

}
