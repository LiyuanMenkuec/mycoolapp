package com.theCode.demo.mycoolapp.commen;

import org.springframework.stereotype.Component;


@Component
public class Teacher implements UserType{

	
	public Teacher() {
		System.out.println("in constructure"+getClass().getSimpleName());
	}
	
	@Override
	public String putUser(){
		
		return "I am a teacher!";
	}

}
