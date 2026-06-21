package com.company.project.service;

import com.company.project.dto.user.UserRequest;
import com.company.project.dto.user.UserSuccessResponse;
import com.company.project.entity.user.Users;

public interface UsersService {
	
	public Users getUsersById(Integer id);
	
	public UserSuccessResponse createUserProfile(UserRequest request);
}
