package com.company.project.service;

import com.company.project.dto.UserKycRequest;
import com.company.project.dto.UserKycResponse;

public interface UserKycService {
	public UserKycResponse uploadUserKyc(UserKycRequest request);
}
