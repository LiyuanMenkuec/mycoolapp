package com.theCode.demo.mycoolapp.commen;

public class PatientChatbot implements Chatbot{

	public PatientChatbot() {
		System.out.println("in constructor:"+getClass().getName());
	}
	
	
	@Override
	public String getMessage() {
		
		return "I have some problems!!!";
	}

}
