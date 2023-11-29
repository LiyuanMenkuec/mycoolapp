package com.theCode.demo.mycoolapp.errors;

public class StudentErrorResponse {
	
	private int status;
	private String messageString;
	private long timeStamp;
	
	public StudentErrorResponse() {
		
	}
	
	public StudentErrorResponse(int status, String messageString, long timeStamp) {
		this.status = status;
		this.messageString = messageString;
		this.timeStamp = timeStamp;
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
