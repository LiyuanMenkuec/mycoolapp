package com.theCode.demo.mycoolapp.cao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.theCode.demo.mycoolapp.entities.InfoOfTeacher;

@RepositoryRestResource(path="infoOfTeachers")//custom the path
public interface TeacherRepository extends JpaRepository<InfoOfTeacher, Integer>{

	//no need to write any code
	//when data-rest is used, the url is: 
	//http://localhost:8081/mycoolapp/infoOfTeachers
	
	
}
