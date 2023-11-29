package com.theCode.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theCode.demo.mycoolapp.commen.Chatbot;
import com.theCode.demo.mycoolapp.commen.CoachChatbot;
import com.theCode.demo.mycoolapp.commen.DoctorChatbot;
import com.theCode.demo.mycoolapp.commen.UserType;

@RestController
public class FunRestController {
	
	//injecting custom Application properties from application.properties
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	
	//injecting dependency class or interface(define a private field for the dependencies)
	private Chatbot chatbot;
	private UserType userType;
	
	//After enabling annotation Aotowired injection, we can use autowiring on properties, 
	//setters, and constructors.
	//@Qualifier has higher priority than @primary
	@Autowired
	public FunRestController(@Qualifier("patientChatbot") Chatbot theChatbot) {//By using the @Qualifier annotation, 
		//we can eliminate the issue of which bean needs to be injected. first character lower-case
		chatbot=theChatbot;
		
	}
	
	@Autowired
	public void setUserType(UserType theUserType) {
		userType=theUserType;
		
	}
	
	
	@GetMapping("/CoachChatbot")
	public String putInfoFromCoach() {
		return chatbot.getMessage()+ userType.putUser();
		
	}
	
	@GetMapping("/teamInfo")
	public String putInfoOfTeam() {
		return "ssss: "+coachName+"sss: "+teamName;
		
	}
	
	
	@GetMapping("/")
	public String sayHallo() {
		return "Hallow, World!!!!";
		
	}
	
	@GetMapping("/well")
	public String sayWell() {
		return "Hallow, Well done!!!!";
		
	}
	
	
}
