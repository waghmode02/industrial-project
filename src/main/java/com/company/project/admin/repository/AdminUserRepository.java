package com.company.project.admin.repository;

import com.company.project.admin.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    List<AdminUser> findByNameContainingIgnoreCase(String name);

    List<AdminUser> findByEmailContainingIgnoreCase(String email);

    List<AdminUser> findByPhoneContaining(String phone);
}