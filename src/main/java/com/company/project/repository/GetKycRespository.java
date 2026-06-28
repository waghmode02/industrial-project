package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.project.entity.UserKyc;

public interface GetKycRespository  extends JpaRepository<UserKyc, Integer>{

}
