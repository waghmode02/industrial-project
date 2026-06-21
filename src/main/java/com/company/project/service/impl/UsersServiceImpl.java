package com.company.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.entity.user.Users;
import com.company.project.exception.kyc.UserNotFoundException;
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

}
