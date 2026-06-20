package com.company.project.exception.kyc;

public class PanAlreadyExistsException extends KycException {
	public PanAlreadyExistsException () {
		super("PAN already exists");
	}
}
