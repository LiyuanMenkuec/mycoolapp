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

import com.theCode.demo.mycoolapp.entities.InfoOfTeacher;
import com.theCode.demo.mycoolapp.service.TeacherService;

@RestController
@RequestMapping("/api")
public class TeacherController {
	/*
	private TeacherService teacherService;
	
	//constructor injection
	@Autowired
	public TeacherController(TeacherService emplyService) {
		this.teacherService=emplyService;
	}
	
	
	// expose a list of teachers and return a list
	@GetMapping("/teachers")
	public List<InfoOfTeacher> sendEmployeesList(){
		return teacherService.findAll();
	}
	
	// expose an endpoint of a teacher and return it
	@GetMapping("/teachers/{teacherId}")
	public InfoOfTeacher sendEmployee(@PathVariable int teacherId){
		InfoOfTeacher theTeacher=teacherService.findById(teacherId);
		if(theTeacher==null) {
			throw new RuntimeException("the teacher is not found"+teacherId);
		}
		
		return theTeacher;
	}
		
	//add mapping for POST /teacher -add new teacher
	@PostMapping("/teachers")	
	public InfoOfTeacher addEmployee(@RequestBody InfoOfTeacher teacher) {
		//set id to 0, this is to force a save of new item instead of update
		teacher.setId(0);
		InfoOfTeacher dbEmployee=teacherService.save(teacher);
		return dbEmployee;
	}
	
	//add mapping for PUT /teachers - update existing teacher
	@PutMapping("/teachers")
	public InfoOfTeacher updatEmployee(@RequestBody InfoOfTeacher teacher) {
		InfoOfTeacher dbEmployee=teacherService.save(teacher);
		return dbEmployee;
	}
	
	// add mapping for DELETE /teachers/{id}
	@DeleteMapping("/teachers/{teacherId}")
	public String deleteEmployee(@PathVariable int teacherId) {
		InfoOfTeacher teacher= teacherService.findById(teacherId);
		if(teacher==null) {
			throw new RuntimeException("this teacher is not found"+teacherId);
		}
		teacherService.deleteById(teacherId);
		return "the teacher "+teacherId+"is deleted";
	}
	
*/

}
