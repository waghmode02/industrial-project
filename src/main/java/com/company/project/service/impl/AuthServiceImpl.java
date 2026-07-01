package com.company.project.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.dto.ValidTokenRequest;
import com.company.project.dto.ValidTokenResponse;
import com.company.project.entity.AuthToken;
import com.company.project.exception.TokenNotFoundException;
import com.company.project.repository.AuthTokenRepository;
import com.company.project.service.AuthService;
import com.company.project.util.ApiResponseForAuth;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	private AuthTokenRepository authTokenRepository;

	@Override
	public ApiResponseForAuth<ValidTokenResponse> validateToken(ValidTokenRequest request) {
		// TODO Auto-generated method stub
		AuthToken authToken=authTokenRepository.
				findByToken(request. getToken())
				.orElseThrow(()->new  TokenNotFoundException("AUTH_007","Invalid or expired token"));
		if(authToken.getExpiryTime().isBefore(LocalDateTime.now())) {
			throw new  TokenNotFoundException("AUTH_007","Invalid or expired token");
		}
		ValidTokenResponse response=new ValidTokenResponse();
		response.setValid(true);
		response.setUserId(authToken.getUserId());
		ApiResponseForAuth<ValidTokenResponse>apiResponse=new ApiResponseForAuth<>();
		apiResponse.setStatus("SUCCESS");
		apiResponse.setData(response);
		return apiResponse;
	}

}
