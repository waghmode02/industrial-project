package com.company.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.company.project.dto.ValidTokenRequest;
import com.company.project.dto.ValidTokenResponse;
import com.company.project.service.AuthService;
import com.company.project.util.ApiResponseForAuth;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/validate-token")
    public ResponseEntity<ApiResponseForAuth<ValidTokenResponse>> validateToken(
            @RequestBody ValidTokenRequest request) {

        return ResponseEntity.ok(authService.validateToken(request));
    }
}