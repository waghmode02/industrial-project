package com.company.project.admin.service;

import java.util.List;

import com.company.project.admin.dto.AdminUserResponseDTO;

public interface AdminUserService {

    List<AdminUserResponseDTO> searchUsers(String keyword);

}