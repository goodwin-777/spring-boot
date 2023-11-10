package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	//Read
	
	public List<Employee> findAllEmployees();
	
	public Employee findById(int id);
	
	public List<Employee> findByName(String name);
	
	//Create
	
	public Employee saveEmployee(Employee employee);
	
//	public List<Employee> saveAllEmployees(List<Employee> employee);
	
	//Update
	
	public Employee updateEmployee(Employee employee);
	
//	public List<Macbook> updateAllMacbooks(List<Macbook> macbooks);
	
	//Delete
	
	public String deleteEmployee(int id);
}
