package com.company.project.service;

import com.company.project.dto.UserRequest;
import com.company.project.dto.UserSuccessResponse;
import com.company.project.entity.Users;

public interface UsersService {
	
	public Users getUsersById(Integer id);
	
	public UserSuccessResponse createUserProfile(UserRequest request);
}
