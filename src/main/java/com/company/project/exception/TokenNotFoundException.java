package com.company.project.exception;

public class TokenNotFoundException extends KycException {
	
	private String errorCode;

	public TokenNotFoundException( String errorCode ,String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
