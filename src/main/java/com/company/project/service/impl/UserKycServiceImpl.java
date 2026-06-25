package com.company.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.dto.UserKycRequest;
import com.company.project.dto.UserKycResponse;
import com.company.project.entity.UserKyc;
import com.company.project.exception.AadhaarAlreadyExistsException;
import com.company.project.exception.PanAlreadyExistsException;
import com.company.project.exception.UserNotFoundException;
import com.company.project.repository.UserKycRepository;
import com.company.project.repository.UsersRepository;
import com.company.project.service.UserKycService;

@Service
public class UserKycServiceImpl implements UserKycService{

    @Autowired
    private UserKycRepository userKycRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserKycResponse uploadUserKyc(UserKycRequest request) {
    	usersRepository.findById(request.getUserId()).orElseThrow(()->new  UserNotFoundException("User not found"));
        UserKycResponse response = new UserKycResponse();
        if (userKycRepository.existsById(request.getUserId())) {
            response.setStatus("ERROR");
            response.setErrorCode("USER_002");
            response.setMessage("KYC already submitted");
            return response;
        }
        if (userKycRepository.existsByPanNumber(request.getPanNumber())) {
            throw new PanAlreadyExistsException("Pan already exists");
        }

        if (userKycRepository.existsByAadhaarNumber(request.getAadhaarNumber())) {
            throw new AadhaarAlreadyExistsException("Aadhaar already exists");
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