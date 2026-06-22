package com.company.project.admin;

import com.company.project.admin.entity.AdminUser;
import com.company.project.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class AdminUserController {

    @Autowired
    private AdminUserService service;

    @GetMapping("/search")
    public List<AdminUser> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone
    ) {
        return service.searchUsers(name, email, phone);
    }
}