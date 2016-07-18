package com.internship.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void createEntity(T t) {
		getSession().persist(t);
	}

	public void updateEntity(T t) {
		getSession().saveOrUpdate(t);
	}

	public void deleteEntity(T t) {
		getSession().delete(t);
	}
}
