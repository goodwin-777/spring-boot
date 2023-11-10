package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Role;
import com.example.demo.service.EmployeeService;

import jakarta.annotation.PostConstruct;


@Controller
@RequestMapping("/apple")
public class EmployeeRestController {
	private EmployeeService employeeService;
	
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@GetMapping("/employees")
	public String getEmployees(Model model){
		 List<Employee> list = employeeService.findAllEmployees();
		 model.addAttribute("list",list);
		 System.out.println(model);
		 return "okay";	
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		return employeeService.findById(id);
	}
	@GetMapping("/employee/{name}")
	public List<Employee> getEmployeeByName(String name){
		return employeeService.findByName(name);
	}
	
	@PostMapping("/employees")
	public Employee insertEmployee(@RequestBody Employee employee){
		return employeeService.saveEmployee(employee);
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee){
		return employeeService.updateEmployee(employee);
	}
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id){
		return employeeService.deleteEmployee(id);
	}
	@PostConstruct
	private void dbEntries() {
		List<Role> list = new ArrayList<>();
		Role role1 = new Role(0, null, "STAFF");
		list.add(role1);
		Employee employee1 = new Employee(0, "goodwin", "enoch", true, list);
		insertEmployee(employee1);
		
		List<Role> list2 = new ArrayList<>();
		Role role2 = new Role(0, null, "STAFF");
		list2.add(role2);
		Employee employee2 = new Employee(0, "jai", "kumar", true, list2);
		insertEmployee(employee2);
	
		List<Role> list3 = new ArrayList<>();
		Role role3 = new Role(0, null, "STAFF");
		list3.add(role3);
		Employee employee3 = new Employee(0, "eswara", "moorthy", true, list3);
		insertEmployee(employee3);
		
		List<Role> list4 = new ArrayList<>();
		Role role41 = new Role(0, null, "STAFF");
		Role role42 = new Role(0, null, "MANAGER");
		list4.add(role41);
		list4.add(role42);
		Employee employee4 = new Employee(0, "jaya", "surya", true, list4);
		insertEmployee(employee4);
		
		List<Role> list5 = new ArrayList<>();
		Role role51 = new Role(0, null, "STAFF");
		Role role52 = new Role(0, null, "MANAGER");
		Role role53 = new Role(0, null, "ADMIN");
		list5.add(role51);
		list5.add(role52);
		list5.add(role53);
		Employee employee5 = new Employee(0, "admin", "password", true, list5);
		insertEmployee(employee5);
	}
}
