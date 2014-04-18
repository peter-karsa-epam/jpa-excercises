package com.epam.training.jp.jpa.excercises.spring;

import org.springframework.context.annotation.Bean;

import com.epam.training.jp.jpa.excercises.dao.AddressDao;
import com.epam.training.jp.jpa.excercises.dao.FoodOrderDao;
import com.epam.training.jp.jpa.excercises.dao.MenuDao;
import com.epam.training.jp.jpa.excercises.dao.OrderItemDao;
import com.epam.training.jp.jpa.excercises.dao.jpaimpl.JpaAddressDao;
import com.epam.training.jp.jpa.excercises.dao.jpaimpl.JpaFoodOrderDao;
import com.epam.training.jp.jpa.excercises.dao.jpaimpl.JpaMenuDao;
import com.epam.training.jp.jpa.excercises.dao.jpaimpl.JpaOrderItemDao;

public class SpringConfigurationDao {

	@Bean
	public AddressDao addressDao() {
		return new JpaAddressDao();
	}
	
	@Bean
	public FoodOrderDao foodOrderDao() {
		return new JpaFoodOrderDao();
	}
	
	@Bean
	public MenuDao menuDao() {
		return new JpaMenuDao();
	}
	
	@Bean
	public OrderItemDao orderItemDao() {
		return new JpaOrderItemDao();
	}
	
}

