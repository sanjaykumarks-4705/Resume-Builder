package com.api.resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.resume.dto.request.LoginRequest;
import com.api.resume.dto.request.RegisterRequest;
import com.api.resume.dto.response.ApiResponse;
import com.api.resume.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse register(@RequestBody RegisterRequest request) {

        return userService.register(request);

    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginRequest request) {

        return userService.login(request);

    }

}
