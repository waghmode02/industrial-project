package com.company.project.service;

import com.company.project.entity.AdminUser;

import java.util.List;

public interface AdminUserService {
    List<AdminUser> searchUsers(String name, String email, String phone);
}