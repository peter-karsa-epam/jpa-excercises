package com.epam.training.jp.jpa.excercises.dto;

import com.epam.training.jp.jpa.excercises.service.OrderService;

public class ShoppingCartFactory {
	private OrderService orderService;

	public ShoppingCartFactory(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public ShoppingCart getCart() {
		return new ShoppingCart(orderService);
	}

}
