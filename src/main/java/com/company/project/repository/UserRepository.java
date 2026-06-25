package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.project.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
