package com.theCode.demo.mycoolapp.cao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.theCode.demo.mycoolapp.entities.InfoOfStudent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/*Spring Repository annotation is a specialization of @Component annotation, 
so Spring Repository classes are autodetected by spring framework through classpath scanning. 
Spring Repository is very close to DAO pattern where DAO classes are responsible for providing
 CRUD operations on database tables. However, if you are using Spring Data for managing database operations, 
 then you should use Spring Data Repository interface.
*/
@Repository
public class StudentDaoImpl implements StudentDao{

	//define field for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
		// TODO Auto-generated constructor stub
	}
	
	//implement save method
	//Transactional automatically manage Spring Transactions
	@Override
	@Transactional
	public void save(InfoOfStudent theStudent){
		entityManager.persist(theStudent);
		
	}

	@Override
	public InfoOfStudent findById(int id) {
		
		return entityManager.find(InfoOfStudent.class, id);
	}

	@Override
	public List<InfoOfStudent> findAll() {
		//create query
		TypedQuery<InfoOfStudent> theQuery=entityManager.createQuery("FROM InfoOfStudent",InfoOfStudent.class);
		//the parameter is name of JPA Entity=the class name, not the name of the database table
		
		
		//return query results
		return theQuery.getResultList();
	}

	@Override
	public List<InfoOfStudent> findByLastname(String lastName) {
		//create query
		TypedQuery<InfoOfStudent> theQuery=entityManager.createQuery(
				"FROM InfoOfStudent WHERE lastname=:theData",InfoOfStudent.class);
		//the parameter is name of JPA Entity=the class name, not the name of the database table
		
		//set query parameters
		theQuery.setParameter("theData", lastName);
				
		//return query results
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(InfoOfStudent infoOfStudent) {
		entityManager.merge(infoOfStudent);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		
		InfoOfStudent infoOfStudent=entityManager.find(InfoOfStudent.class, id);
		if(infoOfStudent!=null) 
			{entityManager.remove(infoOfStudent);}
		else {
			System.out.println("this object is already deleted!!!");
		}
		
		
	}

}
