package com.company.project.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.entity.user.Users;
import com.company.project.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUsers(@PathVariable Integer id){
		Users user =  usersService.getUsersById(id);
		return ResponseEntity.ok(user);
	}

}
