package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Macbook;

public interface MacbookService {

	//Read
	
	public List<Macbook> findAllMacbooks();
	
	public Macbook findById(int id);
	
	public List<Macbook> findByName(String name);
	
	public List<Macbook> findByModel(String model);
	
	public List<Macbook> findByReleaseDate(String date);
	
	public List<Macbook> findByColor(String color);
	
	//Create
	
	public Macbook saveMacbook(Macbook macbook);
	
//	public List<Macbook> saveAllMacbooks(List<Macbook> macbooks);
	
	//Update
	
	public Macbook updateMacbook(Macbook macbook);
	
//	public List<Macbook> updateAllMacbooks(List<Macbook> macbooks);
	
	//Delete
	
	public String deleteMacbook(int id);
}
