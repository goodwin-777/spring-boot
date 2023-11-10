package com.example.demo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Macbook;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class MacbookDaoImpl implements MacbookDao{

	private EntityManager entityManager;
	
	@Autowired
	public MacbookDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Macbook> findAll() {
		TypedQuery<Macbook> query = entityManager.createQuery("from Macbook", Macbook.class);
		return query.getResultList();
	}


	@Override
	public Macbook findById(int id) {
		return entityManager.find(Macbook.class, id);
	}

	@Override
	public List<Macbook> findByName(String name) {
		TypedQuery<Macbook> query = entityManager.createQuery("from Macbook where name = :name", Macbook.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public List<Macbook> findByModel(String model) {
		TypedQuery<Macbook> query = entityManager.createQuery("from Macbook where model = :model", Macbook.class);
		query.setParameter("model",model);
		return query.getResultList();
	}

	@Override
	public List<Macbook> findByReleaseDate(String date) {
		TypedQuery<Macbook> query = entityManager.createQuery("from Macbook where releaseDate = :date", Macbook.class);
		query.setParameter("date",date);
		return query.getResultList();
	}

	@Override
	public List<Macbook> findByColor(String color) {
		TypedQuery<Macbook> query = entityManager.createQuery("from Macbook where color = :color", Macbook.class);
		query.setParameter("color", color);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Macbook save(Macbook macbook) {
		return entityManager.merge(macbook);
	}

	@Override
	@Transactional
	public void delete(Macbook macbook) {
		 entityManager.remove(macbook);
	}

}
