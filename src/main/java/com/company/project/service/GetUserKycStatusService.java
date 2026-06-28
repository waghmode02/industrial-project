package com.company.project.service;

import com.company.project.dto.UserKycStatusDto;

public interface GetUserKycStatusService {
	public UserKycStatusDto getKycDetails(Integer id);
}
