package com.company.project.exception;

public class PanAlreadyExistsException extends KycException {
	public PanAlreadyExistsException (String message) {
		super(message);
	}
}
