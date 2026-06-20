package com.company.project.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.project.entity.user.UserKyc;

@Repository
public interface UserKycRepository  extends JpaRepository<UserKyc, Integer>{

	boolean existsByPanNumber(String panNumber);

	boolean existsByAadhaarNumber(String aadhaarNumber);

}
