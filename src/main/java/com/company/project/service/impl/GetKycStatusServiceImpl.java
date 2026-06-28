package com.company.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.dto.KycData;
import com.company.project.dto.UserKycStatusDto;
import com.company.project.entity.UserKyc;
import com.company.project.repository.GetKycRespository;
import com.company.project.service.GetUserKycStatusService;

@Service
public class GetKycStatusServiceImpl implements GetUserKycStatusService {

    @Autowired
    private GetKycRespository getKycRespository;

    @Override
    public UserKycStatusDto getKycDetails(Integer id) {

        UserKyc user = getKycRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create KYC Data DTO
        KycData data = new KycData();
        data.setAadhaarNumber(user.getAadhaarNumber());
        data.setPanNumber(user.getPanNumber());
        data.setKycStatus(user.getStatus());

        // Create Response DTO
        UserKycStatusDto responseDto = new UserKycStatusDto();
        responseDto.setStatus("SUCCESS");
        responseDto.setData(data);

        return responseDto;
    }
}