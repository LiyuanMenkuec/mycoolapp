package com.theCode.demo.mycoolapp.commen;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Primary
public class Student implements UserType{

	@Override
	public String putUser() {
		return "I am a student!!!";
	}
	
	//define our init method
	@PostConstruct
	public void doBeforeInit() {
		System.out.println("in doBefore Init:"+getClass().getName());
		
	}
	
	//define our destory methode
	@PreDestroy
	public void doBeforeDes() {
		System.out.println("doBeforeDes:"+getClass().getName());
		
	}
	
}
