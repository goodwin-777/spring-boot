package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	List<Employee> findByName(String name);

}
