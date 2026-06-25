package com.company.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.dto.AddressRequestDto;
import com.company.project.dto.ApiResponseDto;
import com.company.project.service.AddressService;

@RestController
@RequestMapping("/api/v1/users")
public class AddressController {

	 private final AddressService addressService;

	    public AddressController(AddressService addressService) {
	        this.addressService = addressService;
	    }

	    @PostMapping("/address")
	    public ApiResponseDto addAddress( @RequestBody AddressRequestDto request) {

	        return addressService.addAddress(request);
	    }
}
