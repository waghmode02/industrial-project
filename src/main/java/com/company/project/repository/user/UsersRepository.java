package com.company.project.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.project.entity.user.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
