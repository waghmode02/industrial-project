package com.company.project.service;

import com.company.project.dto.ValidTokenRequest;
import com.company.project.dto.ValidTokenResponse;
import com.company.project.util.ApiResponseForAuth;

public interface AuthService {
	public ApiResponseForAuth<ValidTokenResponse> validateToken(ValidTokenRequest request);
}
