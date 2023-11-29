package com.theCode.demo.mycoolapp;

import java.util.List;

import org.hibernate.query.sqm.mutation.internal.temptable.UpdateExecutionDelegate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.theCode.demo.mycoolapp.cao.StudentDao;
import com.theCode.demo.mycoolapp.entities.InfoOfStudent;



@SpringBootApplication(
		scanBasePackages = {"com.theCode.demo.mycoolapp"})//Explicitly list base packages yo scan
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}
	
	//executed after the Spring Beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {deleteAStu(studentDao);};

	}
	
	
	
	
	
	private void deleteAStu(StudentDao studentDao) {
		studentDao.delete(1);
		
	}

	private void doUpdateOfAStu(StudentDao studentDao) {
		//retrieve student in database
		List<InfoOfStudent> tempStudents=studentDao.findByLastname("One");
		
		//change the info
		for(InfoOfStudent istu:tempStudents) {
			istu.setEmail("wwwww@sss.de");
		}
		
		//update this student
		for(InfoOfStudent istu:tempStudents) {
			studentDao.update(istu);
		}
		
		//display the updated student
		
	}

	private void queryStudentByLastNmae(StudentDao studentDao) {
		List<InfoOfStudent> tempStudents=studentDao.findByLastname("One");
		for (InfoOfStudent infoOfStudent : tempStudents) {
			System.out.println(infoOfStudent);
		}
		
	}

	private void queryAllStudent(StudentDao studentDao) {
		// get the list of all students
		List<InfoOfStudent> tempStudents=studentDao.findAll();
		for (InfoOfStudent infoOfStudent : tempStudents) {
			System.out.println(infoOfStudent);
		}
		
	}

	private void createStudent(StudentDao studentDao) {
		// create a student object
		System.out.println("Creating a new student object...");
		InfoOfStudent tempStudent1=new InfoOfStudent("www1@d.de","one","one");
		InfoOfStudent tempStudent2=new InfoOfStudent("ww@d.de","two","two");
		//save this student object
		System.out.println("Saving a new student object...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		//display id of saved student
		int id=tempStudent1.getId();
			
		//retrieve student based on id: primary key
		InfoOfStudent retrInfoOfStu=studentDao.findById(id);
		//Display the retrieved student 
		System.out.println(retrInfoOfStu.toString());
		
	}


}
