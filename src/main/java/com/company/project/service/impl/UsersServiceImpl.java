package com.company.project.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.dto.user.UserFailureResponse;
import com.company.project.dto.user.UserRequest;
import com.company.project.dto.user.UserSuccessResponse;
import com.company.project.entity.user.Users;
import com.company.project.exception.kyc.UserNotFoundException;
import com.company.project.exception.kyc.UserProfileAlreadyExistException;
import com.company.project.repository.user.UsersRepository;
import com.company.project.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UsersRepository usersRepository;

	@Override
	public Users getUsersById(Integer id) {

	    Users user = usersRepository.findById(id).orElseThrow(() ->
        new UserNotFoundException("User not found"));

	    System.out.println("User Object = " + user);

	    return user;
	}

	@Override
	public UserSuccessResponse createUserProfile(UserRequest request) {
		Optional<Users> userOptional = usersRepository.findById(request.getUserId());

		if (userOptional.isPresent()) {
			throw new UserProfileAlreadyExistException("Profile already exists");
		}
		Users user = new Users();
		user.setUserId(request.getUserId());
		user.setDateOfBirth(request.getDateOfBirth());
		user.setGender(request.getGender());
		user.setPhone(request.getPhone());

		usersRepository.save(user);

		UserSuccessResponse userSuccessResponse = new UserSuccessResponse();
		userSuccessResponse.setStatus("SUCCESS");
		userSuccessResponse.setMessage("User profile created successfully");
		return userSuccessResponse;
	}

}
