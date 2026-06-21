
package com.company.project.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.project.admin.entity.User;

@Repository
public interface AdminUserRepository extends JpaRepository<User, Long> {

    List<User> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContaining(
            String name,
            String email,
            String phone);

}