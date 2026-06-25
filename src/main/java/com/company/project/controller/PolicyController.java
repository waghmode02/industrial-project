package com.company.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.dto.ApiResponseDto;
import com.company.project.dto.PolicyRequestDto;
import com.company.project.service.PolicyService;

@RestController
@RequestMapping("/api/v1/policies")
public class PolicyController {
	@Autowired
	private PolicyService policyService;
	@PostMapping
	public ResponseEntity<ApiResponseDto> createPolicy(@RequestBody PolicyRequestDto request){
		ApiResponseDto response=policyService.createPolicy(request);
		return ResponseEntity.ok(response);
	}
}

