package com.company.project.exception.kyc;


public class UserProfileAlreadyExistException extends RuntimeException{
	
	public UserProfileAlreadyExistException(String message) {
		super(message);
	}
}
