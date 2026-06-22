package com.company.project.service;

import com.company.project.dto.AddressRequestDto;
import com.company.project.dto.ApiResponseDto;

public interface AddressService {

	ApiResponseDto  addAddress(AddressRequestDto request);
}
