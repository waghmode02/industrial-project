package com.company.project.service;

import com.company.project.dto.ApiResponseDto;
import com.company.project.dto.PolicyRequestDto;
import com.company.project.dto.PolicyTypeRequestDto;

public interface PolicyService {

    ApiResponseDto createPolicy(PolicyRequestDto request);

    ApiResponseDto createPolicyType(PolicyTypeRequestDto request);
}