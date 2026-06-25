package com.company.project.repository;

import com.company.project.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    List<AdminUser> findByNameContainingIgnoreCase(String name);

    List<AdminUser> findByEmailContainingIgnoreCase(String email);

    List<AdminUser> findByPhoneContaining(String phone);
}