package com.company.project.dto;

public class UserKycStatusDto {

    private String status;
    private KycData data;

    public UserKycStatusDto() {
    }

    public UserKycStatusDto(String status, KycData data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public KycData getData() {
        return data;
    }

    public void setData(KycData data) {
        this.data = data;
    }
}