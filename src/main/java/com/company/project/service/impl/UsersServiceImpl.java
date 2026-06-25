package com.company.project.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.dto.UserRequest;
import com.company.project.dto.UserSuccessResponse;
import com.company.project.entity.Users;
import com.company.project.exception.UserNotFoundException;
import com.company.project.exception.UserProfileAlreadyExistException;
import com.company.project.repository.UsersRepository;
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
