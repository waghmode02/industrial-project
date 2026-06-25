package com.company.project.exception;


public class UserProfileAlreadyExistException extends RuntimeException{
	
	public UserProfileAlreadyExistException(String message) {
		super(message);
	}
}
