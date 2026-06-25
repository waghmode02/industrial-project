package com.company.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.project.dto.UserKycResponse;
import com.company.project.dto.UserKycRequest;
import com.company.project.service.impl.UserKycServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class UserKycController {
	@Autowired
	private UserKycServiceImpl userKycServiceImpl;
	
	@PostMapping("/kyc")
	public UserKycResponse uploadUserKyc(@RequestBody UserKycRequest request) {
		return userKycServiceImpl.uploadUserKyc(request);
	}
}
