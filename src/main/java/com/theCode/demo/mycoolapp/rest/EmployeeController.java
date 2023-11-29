package com.theCode.demo.mycoolapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theCode.demo.mycoolapp.cao.EmployeeDAO;
import com.theCode.demo.mycoolapp.entities.Employee;
import com.theCode.demo.mycoolapp.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	//constructor injection
	@Autowired
	public EmployeeController(EmployeeService emplyService) {
		this.employeeService=emplyService;
	}
	
	
	// expose a list of employees and return a list
	@GetMapping("/employees")
	public List<Employee> sendEmployeesList(){
		return employeeService.findAll();
	}
	
	// expose an endpoint of a employee and return it
	@GetMapping("/employees/{employeeId}")
	public Employee sendEmployee(@PathVariable int employeeId){
		Employee theEmployee=employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("the employee is not found"+employeeId);
		}
		
		return theEmployee;
	}
		
	//add mapping for POST /employee -add new employee
	@PostMapping("/employees")	
	public Employee addEmployee(@RequestBody Employee employee) {
		//set id to 0, this is to force a save of new item instead of update
		employee.setId(0);
		Employee dbEmployee=employeeService.save(employee);
		return dbEmployee;
	}
	
	//add mapping for PUT /employees - update existing employee
	@PutMapping("/employees")
	public Employee updatEmployee(@RequestBody Employee employee) {
		Employee dbEmployee=employeeService.save(employee);
		return dbEmployee;
	}
	
	// add mapping for DELETE /employees/{id}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee= employeeService.findById(employeeId);
		if(employee==null) {
			throw new RuntimeException("this employee is not found"+employeeId);
		}
		employeeService.deleteById(employeeId);
		return "the employee "+employeeId+"is deleted";
	}
	

}
