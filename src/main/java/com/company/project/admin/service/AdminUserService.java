package com.company.project.admin.service;

import com.company.project.admin.entity.AdminUser;

import java.util.List;

public interface AdminUserService {
    List<AdminUser> searchUsers(String name, String email, String phone);
}