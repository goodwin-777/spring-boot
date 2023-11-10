package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.MacbookDao;
import com.example.demo.entity.Macbook;
import com.example.demo.exception.MacbookNotFoundException;

@Service
public class MacbookServiceImpl implements MacbookService{

	private MacbookDao macbookDao;
	
	public MacbookServiceImpl(MacbookDao macbookDao) {
		this.macbookDao = macbookDao;
	}

	@Override
	public List<Macbook> findAllMacbooks() {
		List<Macbook> list = macbookDao.findAll();
		return list;
	}

	@Override
	public Macbook findById(int id) {
		Macbook macbook = macbookDao.findById(id);
		if (macbook!=null) {
			return macbook;
		}
		else {
			throw new MacbookNotFoundException("Unable to find Macbook with id:" + id);
		}
	}

	@Override
	public List<Macbook> findByName(String name) {
		List<Macbook> list = macbookDao.findByName(name);
		if (!list.isEmpty()) {
			return list;
		}
		else {
			throw new MacbookNotFoundException("Unable to find Macbook with name: " + name);
		}
	}

	@Override
	public List<Macbook> findByModel(String model) {
		List<Macbook> list = macbookDao.findByModel(model);
		
		if (!list.isEmpty()) {
			return list;
		}
		else {
			throw new MacbookNotFoundException("Unable to find Macbook with model: " + model);
		}
	}

	@Override
	public List<Macbook> findByReleaseDate(String date) {
		List<Macbook> list = macbookDao.findByReleaseDate(date);
		System.out.println(list==null);
		if (!list.isEmpty()) {
			return list;
		}
		else {
			throw new MacbookNotFoundException("Unable to find Macbook with date: " + date);
		}
	}

	@Override
	public List<Macbook> findByColor(String color) {
		List<Macbook> list = macbookDao.findByColor(color);
		if (!list.isEmpty()) {
			return list;
		}
		else {
			throw new MacbookNotFoundException("Unable to find Macbook with color: " + color);
		}
	}

	@Override
	public Macbook saveMacbook(Macbook macbook) {
		macbook.setId(0);
		Macbook dbMacbook = macbookDao.save(macbook);
		return dbMacbook;
	}

//	@Override
//	public List<Macbook> saveAllMacbooks(List<Macbook> macbooks) {
//		for (Macbook macbook : macbooks) {
//			macbook.setId(0);
//		}
//		List<Macbook> list = macbookDao.saveAll(macbooks);
//		return list;
//	}

	@Override
	public Macbook updateMacbook(Macbook macbook) {
		int id = macbook.getId();
		@SuppressWarnings("unused")
		Macbook dbMacbook = findById(id);
		Macbook updatedMacbook = macbookDao.save(macbook);
		return updatedMacbook;
	}

//	@Override
//	public List<Macbook> updateAllMacbooks(List<Macbook> macbooks) {
//		for (Macbook macbook : macbooks) {
//			int id = macbook.getId();
//			@SuppressWarnings("unused")
//			Macbook dbMacbook = findById(id);
//		}
//		List<Macbook> list = macbookDao.saveAll(macbooks);
//		return list;
//	}

	@Override
	public String deleteMacbook(int id) {
		Macbook macbook = findById(id);
		macbookDao.delete(macbook);
		return "Successfully deleted Macbook with id:" + id;
	}
	
}
