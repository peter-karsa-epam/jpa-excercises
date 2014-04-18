package com.epam.training.jp.jpa.excercises.dao;

import java.util.List;

import com.epam.training.jp.jpa.excercises.domain.Food;
import com.epam.training.jp.jpa.excercises.domain.Menu;

public interface MenuDao {

	public List<Menu> getActualMenus();

	public Food findFoodById(int foodId);
}
