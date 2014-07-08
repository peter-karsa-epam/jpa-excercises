package com.epam.training.jp.jpa.excercises.dao.jpaimpl;

import com.epam.training.jp.jpa.excercises.dao.FoodOrderDao;
import com.epam.training.jp.jpa.excercises.domain.FoodOrder;

public class JpaFoodOrderDao extends GenericJpaDao implements FoodOrderDao {

	@Override
	public void save(FoodOrder foodOrder) {
		entityManager.getTransaction().begin();
		entityManager.persist(foodOrder);
		entityManager.getTransaction().commit();
	}

}
