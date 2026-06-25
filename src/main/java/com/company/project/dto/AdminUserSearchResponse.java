package com.company.project.dto;

import java.util.List;

public class AdminUserSearchResponse {

    private String status;
    private List<AdminUserResponseDTO> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AdminUserResponseDTO> getData() {
        return data;
    }

    public void setData(List<AdminUserResponseDTO> data) {
        this.data = data;
    }
}