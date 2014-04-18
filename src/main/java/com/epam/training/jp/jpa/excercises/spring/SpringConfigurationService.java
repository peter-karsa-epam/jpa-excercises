package com.epam.training.jp.jpa.excercises.spring;

import org.springframework.context.annotation.Bean;

import com.epam.training.jp.jpa.excercises.dao.AddressDao;
import com.epam.training.jp.jpa.excercises.dao.FoodOrderDao;
import com.epam.training.jp.jpa.excercises.dao.MenuDao;
import com.epam.training.jp.jpa.excercises.dao.OrderItemDao;
import com.epam.training.jp.jpa.excercises.dto.ShoppingCartFactory;
import com.epam.training.jp.jpa.excercises.service.OrderService;
import com.epam.training.jp.jpa.excercises.service.PopulateDatabaseService;

public class SpringConfigurationService {

	@Bean
	public OrderService orderService(AddressDao addressDao, FoodOrderDao foodOrderDao, MenuDao menuDao, OrderItemDao orderItemDao) {
		return new OrderService(menuDao, foodOrderDao, addressDao, orderItemDao);
	}
	
	@Bean
	public ShoppingCartFactory shoppingCartFactory(OrderService orderService) {
		return new ShoppingCartFactory(orderService);
	}
	
	@Bean(initMethod = "popluateDatabase")
	public PopulateDatabaseService populateDatabaseService() {
		return new PopulateDatabaseService();
	}
}
