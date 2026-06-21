package com.company.project.service.impl;

import org.springframework.stereotype.Service;

import com.company.project.dto.AddressRequestDto;
import com.company.project.dto.ApiResponseDto;
import com.company.project.entity.Address;
import com.company.project.entity.User;
import com.company.project.repository.AddressRepository;
import com.company.project.repository.UserRepository;
import com.company.project.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	  private final AddressRepository addressRepository;
	  private final UserRepository userRepository;
	  
	  public AddressServiceImpl(AddressRepository addressRepository,UserRepository userRepository) 
	  {
		  this.addressRepository = addressRepository;
		  this.userRepository = userRepository;
	  }
	 
	  public ApiResponseDto addAddress(AddressRequestDto request) {

	        User user = userRepository.findById(request.getUserId()).orElseThrow(() ->new RuntimeException("User not found"));

	        Address address = new Address();
	        address.setAddressLine1(request.getAddressLine1());
	        address.setCity(request.getCity());
	        address.setState(request.getState());
	        address.setPincode(request.getPincode());
	        address.setUser(user);

	        addressRepository.save(address);
	        return new ApiResponseDto(
              "SUCCESS",
              "Address added successfully"
      );
}
}