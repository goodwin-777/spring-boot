package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

//import com.example.demo.configuration.AppConfiguration;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Role;
import com.example.demo.exception.EmployeeNotFoundException;

@Component
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
//	private AppConfiguration appConfiguration;
//	
//	public EmployeeServiceImpl(EmployeeDao employeeDao, AppConfiguration appConfiguration) {
//		this.employeeDao = employeeDao;
//		this.appConfiguration = appConfiguration;
//	}
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> optional = employeeDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EmployeeNotFoundException("Invalid employee id");
		}
	}

	@Override
	public List<Employee> findByName(String name) {
		return employeeDao.findByName(name);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setId(0);
//		String password = employee.getPassword();
//		String encryptedPass = appConfiguration.passwordEncryptor(password);
//		employee.setPassword("{bcrypt}" + encryptedPass);
		List<Role> list = employee.getRoleList();
		if (list==null) {
			Employee dbEmployee = employeeDao.save(employee);
			Optional<Employee> optional = employeeDao.findById(dbEmployee.getId());
			return optional.get();
		}
		else {
			for (Role role : list) {
				role.setId(0);
				role.setName(employee.getName());
				role.setRole("ROLE_"+ role.getRole());
			}
			Employee dbEmployee = employeeDao.save(employee);
			Optional<Employee> optional = employeeDao.findById(dbEmployee.getId());
			return optional.get();
		}	
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		int id = employee.getId();
		//will check with database if not found will throw custom exception
		findById(id);
		
//		String password = employee.getPassword();
//		String encryptedPass = appConfiguration.passwordEncryptor(password);
//		employee.setPassword("{bcrypt}" + encryptedPass);
		List<Role> list = employee.getRoleList();
		if (list==null) {
			Employee dbEmployee = employeeDao.save(employee);
			Optional<Employee> optional = employeeDao.findById(dbEmployee.getId());
			return optional.get();
		}
		else {
			for (Role role : list) {
				role.setId(0);
				role.setName(employee.getName());
				role.setRole("ROLE_"+ role.getRole());
			}
			Employee dbEmployee = employeeDao.save(employee);
			return dbEmployee;
		}	
	}

	@Override
	public String deleteEmployee(int id) {
		//will check with database if not found will throw custom exception
		Employee employee = findById(id);
		employeeDao.delete(employee);
		return "Successfully deleted employee id: "+ id;
	}

}
