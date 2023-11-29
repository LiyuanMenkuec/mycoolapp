package com.theCode.demo.mycoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.theCode.demo.mycoolapp.commen.Chatbot;
import com.theCode.demo.mycoolapp.commen.PatientChatbot;

@Configuration
public class ChatbotConfig {
	
	@Bean //the bean id defaults to the method name
	public Chatbot patientChatbot() {
		return new PatientChatbot();
	}

}
