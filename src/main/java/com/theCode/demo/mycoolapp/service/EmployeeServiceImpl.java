package com.theCode.demo.mycoolapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theCode.demo.mycoolapp.cao.EmployeeDAO;
import com.theCode.demo.mycoolapp.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//field
	private EmployeeDAO employeeDAO;
	
	//Constructor injection
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO=employeeDAO;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		
		return employeeDAO.save(employee);
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		
		employeeDAO.deleteById(id);
		
	}

}
