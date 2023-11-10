package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Macbook;

@Repository
public interface MacbookDao{

	List<Macbook> findAll();
	
	Macbook findById(int id);
	
	List<Macbook> findByName(String name);

	List<Macbook> findByModel(String model);
	
	List<Macbook> findByReleaseDate(String date);
	
	List<Macbook> findByColor(String color);

	Macbook save(Macbook macbook);
	
	void delete(Macbook macbook);
}
