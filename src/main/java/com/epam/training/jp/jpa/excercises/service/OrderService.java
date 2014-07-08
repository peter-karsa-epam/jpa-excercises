package com.epam.training.jp.jpa.excercises.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.jp.jpa.excercises.dao.AddressDao;
import com.epam.training.jp.jpa.excercises.dao.FoodOrderDao;
import com.epam.training.jp.jpa.excercises.dao.MenuDao;
import com.epam.training.jp.jpa.excercises.dao.OrderItemDao;
import com.epam.training.jp.jpa.excercises.domain.Food;
import com.epam.training.jp.jpa.excercises.domain.FoodOrder;
import com.epam.training.jp.jpa.excercises.domain.Menu;
import com.epam.training.jp.jpa.excercises.domain.OrderItem;
import com.epam.training.jp.jpa.excercises.dto.ShoppingCart;

public class OrderService {

	private final MenuDao menuDao;
	private final FoodOrderDao foodOrderDao;
	private final AddressDao addressDao;
	private final OrderItemDao orderItemDao;

	@Resource
	private PlatformTransactionManager txManager;

	public OrderService(MenuDao menuDao, FoodOrderDao foodOrderDao,
			AddressDao addressDao, OrderItemDao orderItemDao) {
		super();
		this.menuDao = menuDao;
		this.foodOrderDao = foodOrderDao;
		this.addressDao = addressDao;
		this.orderItemDao = orderItemDao;
	}

	@Transactional(readOnly = true)
	public List<Menu> getActualMenus() {
		return menuDao.getActualMenus();
	}

	public Food findFoodById(int foodId) {
		return menuDao.findFoodById(foodId);
	}

	@Transactional
	public int submitOrder(ShoppingCart shopingCart) {
		// TODO: implement, save all the related data
		// throw new UnsupportedOperationException();
		FoodOrder foodOrder = shopingCart.build();

		addressDao.save(foodOrder.getAddress());

		for (OrderItem orderItem : foodOrder.getOrderItems()) {
			orderItemDao.save(orderItem);
		}
		foodOrderDao.save(foodOrder);

		return foodOrder.getId();

	}

}
