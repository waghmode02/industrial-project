package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.project.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {

}
