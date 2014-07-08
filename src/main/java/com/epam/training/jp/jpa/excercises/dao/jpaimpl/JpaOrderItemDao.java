package com.epam.training.jp.jpa.excercises.dao.jpaimpl;

import com.epam.training.jp.jpa.excercises.dao.OrderItemDao;
import com.epam.training.jp.jpa.excercises.domain.OrderItem;

public class JpaOrderItemDao extends GenericJpaDao implements OrderItemDao {

	@Override
	public void save(OrderItem orderItem) {
		entityManager.getTransaction().begin();
		entityManager.persist(orderItem);
		entityManager.getTransaction().commit();
	}

}
