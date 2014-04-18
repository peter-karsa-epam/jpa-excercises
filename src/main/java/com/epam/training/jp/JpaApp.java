package com.epam.training.jp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.epam.training.jp.jpa.excercises.domain.Address;
import com.epam.training.jp.jpa.excercises.domain.Food;
import com.epam.training.jp.jpa.excercises.domain.FoodOrder;
import com.epam.training.jp.jpa.excercises.domain.Menu;
import com.epam.training.jp.jpa.excercises.domain.OrderItem;
import com.epam.training.jp.jpa.excercises.dto.ShoppingCart;
import com.epam.training.jp.jpa.excercises.dto.ShoppingCartFactory;
import com.epam.training.jp.jpa.excercises.service.OrderService;
import com.epam.training.jp.jpa.excercises.spring.SpringConfigurationDao;
import com.epam.training.jp.jpa.excercises.spring.SpringConfigurationJpa;
import com.epam.training.jp.jpa.excercises.spring.SpringConfigurationService;

public class JpaApp {

	private final OrderService orderService;
	private final ShoppingCart shoppingCart;

	public JpaApp() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				SpringConfigurationJpa.class, 
				SpringConfigurationDao.class,
				SpringConfigurationService.class);
		orderService = context.getBean(OrderService.class);
		shoppingCart = context.getBean(ShoppingCartFactory.class).getCart();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		JpaApp test = new JpaApp();
		test.getOrder();
	}

	public void getOrder() {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader buf_in = new BufferedReader(reader);
		String input = "";
		do {
			printMenu();
			try {
				input = buf_in.readLine();
				doEvent(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!"".equals(input));
		printOrder();
	}

	private void doEvent(String input) {
		if ("".equals(input)) {
			shoppingCart.setAddress(getAddress());
			shoppingCart.setCustomer(getCustomer());
			System.out.println("Az on rendelesenek a szama: "
					+ orderService.submitOrder(shoppingCart));
		} else {
			try {
				int foodId = Integer.parseInt(input);
				int quantity = askQuantity();
				shoppingCart.addFood(foodId, quantity);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
	}

	private String getCustomer() {
		System.out.println("Kerem adja meg a nevet: ");
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader buf_in = new BufferedReader(reader);
		try {
			return buf_in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private Address getAddress() {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader buf_in = new BufferedReader(reader);
		Address a = new Address();
		try {
			System.out.println("Kerem irja be az orszagot:");
			a.setCountry(buf_in.readLine());
			System.out.println("Kerem irja be a varost:");
			a.setCity(buf_in.readLine());
			System.out.println("Kerem irja be az utcat es a hazszamot:");
			a.setStreet(buf_in.readLine());
			System.out.println("Kerem irja be az iranyitoszamot:");
			a.setZipCode(buf_in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return a;
	}

	private int askQuantity() {
		System.out.println("mennyit: ");
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader buf_in = new BufferedReader(reader);
		String input = "";
		try {
			input = buf_in.readLine();
			return Integer.parseInt(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private void printMenu() {
		for (Menu menu : orderService.getActualMenus()) {
			for (Food food : menu.getFoods()) {
				System.out.println(food.getId() + ". " + food.getName()
						+ " cals: " + food.getCalories());
			}
		}
		printOrder();
		printSeparator();
		System.out
				.println("Az etel szamanak kivalasztasaval tudja boviteni a rendeleset, Enter: rendeles veglegesitese.");
	}

	private void printOrder() {
		FoodOrder order = this.shoppingCart.build();
		if (order.getOrderItems().size() > 0)
			printSeparator();
		for (OrderItem orderItem : order.getOrderItems()) {
			System.out.println(orderItem.getFood().getId() + ". "
					+ orderItem.getFood().getName() + " "
					+ orderItem.getQuantity() + " db");
		}
	}

	private void printSeparator() {
		System.out.println("----------------------------------------------");
	}
	


}
