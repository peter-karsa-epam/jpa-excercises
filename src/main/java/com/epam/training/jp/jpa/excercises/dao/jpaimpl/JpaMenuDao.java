package com.epam.training.jp.jpa.excercises.dao.jpaimpl;

import java.util.List;

import javax.persistence.TypedQuery;

import com.epam.training.jp.jpa.excercises.dao.MenuDao;
import com.epam.training.jp.jpa.excercises.domain.Food;
import com.epam.training.jp.jpa.excercises.domain.Menu;

public class JpaMenuDao extends GenericJpaDao implements MenuDao {

	@Override
	public List<Menu> getActualMenus() {
		TypedQuery<Menu> query = entityManager.createQuery(
				"SELECT m FROM Menu m", Menu.class);
		List<Menu> menus = query.getResultList();
		return menus;
	}

	@Override
	public Food findFoodById(int foodId) {
		Food food = entityManager.find(Food.class, foodId);
		return food;
	}

}
