package com.company.project.dto;

public class KycData {

    private String aadhaarNumber;
    private String panNumber;
    private String kycStatus;

    public KycData() {
    }

    public KycData(String aadhaarNumber, String panNumber, String kycStatus) {
        this.aadhaarNumber = aadhaarNumber;
        this.panNumber = panNumber;
        this.kycStatus = kycStatus;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = "XXXXXXXX"+aadhaarNumber.substring(8);
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }
}