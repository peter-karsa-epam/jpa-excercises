package com.epam.training.jp.jpa.excercises.dao.jpaimpl;

import com.epam.training.jp.jpa.excercises.dao.AddressDao;
import com.epam.training.jp.jpa.excercises.domain.Address;

public class JpaAddressDao extends GenericJpaDao implements AddressDao {

	@Override
	public void save(Address address) {
		entityManager.getTransaction().begin();
		entityManager.persist(address);
		entityManager.getTransaction().commit();
	}

}
