package com.epam.training.jp.jpa.excercises.service;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.epam.training.jp.jpa.excercises.domain.Address;
import com.epam.training.jp.jpa.excercises.domain.Food;
import com.epam.training.jp.jpa.excercises.domain.Menu;
import com.epam.training.jp.jpa.excercises.domain.Restaurant;

public class PopulateDatabaseService {
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	
	@Resource
	private PlatformTransactionManager txManager;
	

	public void popluateDatabase() {
//		TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());
//		
//		Food food1 = createFood("Tender lion", 4000, 500, false);
//		Food food2 = createFood("Filet mignon", 5000, 600, false);
//		
//		Menu menu = new Menu();
//		menu.setFromDate(new Date());
//		menu.setToDate(new Date());
//		menu.setFoods(newArrayList(food1, food2));
//		entityManager.persist(menu);		
//		
//		Address address = new Address();
//		address.setCity("Budapest");
//		address.setStreet("Futó utca 57");
//		address.setCountry("Hungary");
//		address.setZipCode("1085");
//		entityManager.persist(address);
//				
//		Restaurant restaurant = new Restaurant();
//		restaurant.setAddress(address);
//		restaurant.setMenus(newArrayList(menu));
//		entityManager.persist(restaurant);
//		
//		txManager.commit(status);
		
	}


//	private Food createFood(String name, int price, int calories, boolean isVegan) {
//		Food food = new Food();
//		food.setName(name);
//		food.setPrice(price);
//		food.setCalories(calories);
//		food.setVegan(isVegan);
//		entityManager.persist(food);
//		return food;
//	}
}
