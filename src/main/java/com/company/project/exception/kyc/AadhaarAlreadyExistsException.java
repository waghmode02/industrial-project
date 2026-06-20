package com.company.project.exception.kyc;

public class AadhaarAlreadyExistsException  extends KycException{
	public AadhaarAlreadyExistsException() {
        super("Aadhaar already exists");
    }
}
