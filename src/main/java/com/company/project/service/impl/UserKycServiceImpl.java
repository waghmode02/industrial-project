package com.company.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.dto.user.UserKycRequest;
import com.company.project.dto.user.UserKycResponse;
import com.company.project.entity.user.UserKyc;
import com.company.project.exception.kyc.AadhaarAlreadyExistsException;
import com.company.project.exception.kyc.PanAlreadyExistsException;
import com.company.project.repository.user.UserKycRepository;

@Service
public class UserKycServiceImpl {

    @Autowired
    private UserKycRepository userKycRepository;

    public UserKycResponse uploadUserKyc(UserKycRequest request) {

        UserKycResponse response = new UserKycResponse();
        if (userKycRepository.existsById(request.getUserId())) {
            response.setStatus("ERROR");
            response.setErrorCode("USER_002");
            response.setMessage("KYC already submitted");
            return response;
        }
        if (userKycRepository.existsByPanNumber(request.getPanNumber())) {
            throw new PanAlreadyExistsException();
        }

        if (userKycRepository.existsByAadhaarNumber(request.getAadhaarNumber())) {
            throw new AadhaarAlreadyExistsException();
        }

        UserKyc user = new UserKyc();
        user.setUserId(request.getUserId());
        user.setAadhaarNumber(request.getAadhaarNumber());
        user.setPanNumber(request.getPanNumber());
        user.setDocumentId(request.getDocumentId());
        user.setStatus("PENDING");
        userKycRepository.save(user);

        response.setStatus("SUCCESS");
        response.setMessage("KYC details submitted successfully");

        return response;
    }
}