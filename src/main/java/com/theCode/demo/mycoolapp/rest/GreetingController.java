package com.theCode.demo.mycoolapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theCode.demo.mycoolapp.entities.InfoOfStudent;
import com.theCode.demo.mycoolapp.errors.StudentErrorResponse;

import jakarta.annotation.PostConstruct;




@RestController
@RequestMapping("/api")
public class GreetingController {
	private List<InfoOfStudent> students;
		
	
	//define @PostConstruct to load the data, only once
	@PostConstruct
	public void ClassLoaderData() {
		students= new ArrayList<>();
		students.add(new InfoOfStudent("a","b","c"));
		students.add(new InfoOfStudent("d","e","f"));
	}

	//add code for the /hello endpoing
	@GetMapping("/hello")
	public List<InfoOfStudent> sayHello() {
		
		return students;
	}
	
	//add code for the /hello/{studentId} endpoing
		@GetMapping("/hello/{studentId}")
		public InfoOfStudent sayHelloToOne(@PathVariable int studentId) {
			//check the student id again list size
			if((studentId>=students.size()) || studentId<0) {
				throw new StudentNotFoundException("Student id is not found -"+studentId);
			}
			
			return students.get(studentId);
		}
		

}
