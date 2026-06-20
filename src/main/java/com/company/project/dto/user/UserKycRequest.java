package com.company.project.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserKycRequest {
	
    @NotNull(message = "UserId is required")
    private Integer userId;

    @NotNull(message = "Aadhaar number is required")
    @Size(min = 12, max = 12, message = "Aadhaar must be 12 digits")
    private String aadhaarNumber;

    @NotNull(message = "PAN number is required")
    private String panNumber;

    private String documentId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	
}
