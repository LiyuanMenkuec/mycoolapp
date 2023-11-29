package com.theCode.demo.mycoolapp.cao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.theCode.demo.mycoolapp.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	//define field for EntityManager
	private EntityManager entityManager;

	//Constructor Injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		//create a query
		TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee", Employee.class);
		//execute query and get results
		List<Employee> employees=theQuery.getResultList();
		//return the result
		return employees;
		
	}


	@Override
	public Employee findById(int id) {
		//find employee
		Employee employee=entityManager.find(Employee.class, id);
		
		//return employee
		return employee;
	}


	@Override
	public Employee save(Employee employee) {
		//save employee
		Employee dbEmployee=entityManager.merge(employee);
		//return the saved employee
		return dbEmployee;
	}


	@Override
	public void deleteById(int id) {
		//find employee by id
		Employee employee=entityManager.find(Employee.class, id);
		
		//remove the employee
		entityManager.remove(employee);
		
	}

	
}
