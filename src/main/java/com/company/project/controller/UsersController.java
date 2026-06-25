package com.company.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.dto.UserRequest;
import com.company.project.dto.UserSuccessResponse;
import com.company.project.entity.Users;
import com.company.project.service.UsersService;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUsers(@PathVariable Integer id){
		Users user =  usersService.getUsersById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/profile")
	public ResponseEntity<UserSuccessResponse> createUserProfile(@RequestBody UserRequest userRequest){
		UserSuccessResponse response = usersService.createUserProfile(userRequest);
		return ResponseEntity.ok(response);
	}

}
