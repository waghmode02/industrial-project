package com.company.project.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.admin.dto.AdminUserResponseDTO;
import com.company.project.admin.dto.AdminUserSearchResponse;
import com.company.project.admin.service.AdminUserService;

@RestController
@RequestMapping("/api/v1/users")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/search")
    public AdminUserSearchResponse searchUsers(
            @RequestParam String keyword) {

        List<AdminUserResponseDTO> users =
                adminUserService.searchUsers(keyword);

        AdminUserSearchResponse response =
                new AdminUserSearchResponse();

        response.setStatus("SUCCESS");
        response.setData(users);

        return response;
    }
}