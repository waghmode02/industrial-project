package com.company.project.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.project.admin.entity.AdminUser;
import com.company.project.admin.exception.UserNotFoundException;
import com.company.project.admin.repository.AdminUserRepository;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserRepository repository;

    public AdminUserServiceImpl(AdminUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AdminUser> searchUsers(String name, String email, String phone) {

        List<AdminUser> users;

        if (name != null && !name.isBlank()) {
            users = repository.findByNameContainingIgnoreCase(name);
        } else if (email != null && !email.isBlank()) {
            users = repository.findByEmailContainingIgnoreCase(email);
        } else if (phone != null && !phone.isBlank()) {
            users = repository.findByPhoneContaining(phone);
        } else {
            throw new RuntimeException("No search parameter provided");
        }

        if (users.isEmpty()) {
            throw new UserNotFoundException("No users found");
        }

        return users;
    }
}