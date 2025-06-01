package com.api.chatspring.controller;

public class ControllerError {
	private String message;
	
	public ControllerError(String msg) {
		this.message = msg;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
