package com.theCode.demo.mycoolapp.cao;


import java.util.List;

import com.theCode.demo.mycoolapp.entities.InfoOfStudent;

public interface StudentDao {
	
	/*we can also change the tables by SQL Conmand:
	 * int numOfChanges= entityManager.createQuery(
	 * "DELETE/UPDATE FROM InfoStudent WHERE lastname='two'").excuteUpdate()
	 * 
	 * */
	
	//create
	void save(InfoOfStudent theStudent);
	//read
	InfoOfStudent findById(int id);
	//query
	List<InfoOfStudent> findAll();
	List<InfoOfStudent> findByLastname(String lastName);
	//update
	void update(InfoOfStudent infoOfStudent);
	//delete
	void delete(int id);
	
}
