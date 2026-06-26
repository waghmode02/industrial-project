package com.company.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.dto.ApiResponseDto;
import com.company.project.dto.PolicyRequestDto;
import com.company.project.dto.PolicyTypeRequestDto;
import com.company.project.entity.Policy;
import com.company.project.entity.PolicyType;
import com.company.project.exception.ResourceNotFoundException;
import com.company.project.repository.PolicyRepository;
import com.company.project.repository.PolicyTypeRepository;
import com.company.project.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private PolicyTypeRepository policyTypeRepository;

    @Override
    public ApiResponseDto createPolicy(PolicyRequestDto request) {

        PolicyType policyType = policyTypeRepository.findById(request.getPolicyTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Policy Type Not Found"));

        Policy policy = new Policy();

        policy.setPolicyName(request.getPolicyName());
        policy.setCoverageAmount(request.getCoverageAmount());
        policy.setDurationInYears(request.getDurationInYears());
        policy.setPolicyType(policyType);

        policyRepository.save(policy);

        return new ApiResponseDto(
                "SUCCESS",
                "Policy created successfully");
    }

    @Override
    public ApiResponseDto createPolicyType(PolicyTypeRequestDto request) {

        PolicyType policyType = new PolicyType();

        policyType.setPolicyTypeName(request.getPolicyTypeName());
        policyType.setDescription(request.getDescription());
        policyType.setBasePremium(request.getBasePremium());

        policyTypeRepository.save(policyType);

        return new ApiResponseDto(
                "SUCCESS",
                "Policy Type created successfully");
    }
}