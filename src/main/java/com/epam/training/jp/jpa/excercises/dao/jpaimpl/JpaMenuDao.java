package com.epam.training.jp.jpa.excercises.dao.jpaimpl;

import java.util.Date;
import java.util.List;

import com.epam.training.jp.jpa.excercises.dao.MenuDao;
import com.epam.training.jp.jpa.excercises.domain.Food;
import com.epam.training.jp.jpa.excercises.domain.Menu;

public class JpaMenuDao extends GenericJpaDao implements MenuDao {

	@Override
	public List<Menu> getActualMenus() {
		List<Menu> menus = entityManager
				.createQuery(
						"SELECT m FROM Menu m WHERE :now >= m.fromDate AND :now <= m.toDate",
						Menu.class).setParameter("now", new Date())
				.getResultList();
		for (Menu menu : menus) {
			menu.getFoods().size();
		}

		return menus;
	}

	@Override
	public Food findFoodById(int foodId) {
		Food food = entityManager.find(Food.class, foodId);
		return food;
	}

}
