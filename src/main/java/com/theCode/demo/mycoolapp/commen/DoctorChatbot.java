package com.theCode.demo.mycoolapp.commen;

import org.springframework.stereotype.Component;

@Component
public class DoctorChatbot implements Chatbot {

	@Override
	public String getMessage() {
		return "What Problem do you have?";
	}
	

}
