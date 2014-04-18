package com.epam.training.jp.jpa.excercises.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.training.jp.jpa.excercises.domain.Address;
import com.epam.training.jp.jpa.excercises.domain.Food;
import com.epam.training.jp.jpa.excercises.domain.FoodOrder;
import com.epam.training.jp.jpa.excercises.domain.OrderItem;
import com.epam.training.jp.jpa.excercises.domain.OrderState;
import com.epam.training.jp.jpa.excercises.service.OrderService;

public class ShoppingCart {
	private String customer;
	private Map<Integer, Integer> order = new HashMap<Integer, Integer>();
	private Address address;
	private final OrderService menuService;
	
	public ShoppingCart(OrderService menuService) {
		super();
		this.menuService = menuService;
	}

	public ShoppingCart addFood(int foodId, int quantity) {
		if (order.containsKey(foodId)) {
			int currentQuantity = order.get(foodId);
			int q = currentQuantity + quantity;
			if (q > 0)
				order.put(foodId, q);
			else
				order.remove(foodId);
		} else {
			order.put(foodId, quantity);
		}
		return this;
	}

	public ShoppingCart setCustomer(String customer) {
		this.customer = customer;
		return this;
	}

	public ShoppingCart setAddress(Address address) {
		this.address = address;
		return this;
	}

	public FoodOrder build() {
		return new FoodOrder(createOrderItems(), address, customer,
				OrderState.PENDING);
	}

	private List<OrderItem> createOrderItems() {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for (int foodId : order.keySet()) {
			Food f = menuService.findFoodById(foodId);
			if (f != null) {
				OrderItem oi = new OrderItem(f, order.get(foodId));
				orderItemList.add(oi);
			}
			else {
				throw new IllegalArgumentException("Ismeretlen azonositoju etel: " + foodId);
			}
		}
		return orderItemList;
	}

}
