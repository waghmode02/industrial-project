package com.company.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.project.entity.AuthToken;
@Repository
public interface AuthTokenRepository  extends JpaRepository<AuthToken, Long>{

	Optional<AuthToken> findByToken(String token);

}
