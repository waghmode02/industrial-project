package com.company.project.service;

import com.company.project.dto.ApiResponseDto;
import com.company.project.dto.user.PolicyRequestDto;

public interface PolicyService {
	ApiResponseDto createPolicy(PolicyRequestDto request);
}
