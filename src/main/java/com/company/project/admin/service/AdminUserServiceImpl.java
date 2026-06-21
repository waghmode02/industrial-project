package com.company.project.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.admin.dto.AdminUserResponseDTO;
import com.company.project.admin.entity.User;
import com.company.project.admin.exception.UserNotFoundException;
import com.company.project.admin.repository.AdminUserRepository;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public List<AdminUserResponseDTO> searchUsers(String keyword) {

        List<User> users =
                adminUserRepository
                        .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContaining(
                                keyword,
                                keyword,
                                keyword);

        if (users.isEmpty()) {
            throw new UserNotFoundException(
                    "No user found with keyword : " + keyword);
        }

        List<AdminUserResponseDTO> response = new ArrayList<>();

        for (User user : users) {

            AdminUserResponseDTO dto = new AdminUserResponseDTO();

            dto.setUserId(user.getUserId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());

            response.add(dto);
        }

        return response;
    }
}