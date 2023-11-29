package com.theCode.demo.mycoolapp.commen;

import org.springframework.stereotype.Component;

@Component
public class CoachChatbot implements Chatbot{
	
	@Override
	public String getMessage() {
		
		return "Do you have any dreams?";
	}
	
}
