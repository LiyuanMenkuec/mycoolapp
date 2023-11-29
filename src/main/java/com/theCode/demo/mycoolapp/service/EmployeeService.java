package com.theCode.demo.mycoolapp.service;

import java.util.List;

import com.theCode.demo.mycoolapp.entities.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee employee);
	
	void deleteById(int id);

}
