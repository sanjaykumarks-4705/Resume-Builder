package com.api.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.resume.dto.request.LoginRequest;
import com.api.resume.dto.request.RegisterRequest;
import com.api.resume.dto.response.ApiResponse;
import com.api.resume.entity.User;
import com.api.resume.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public ApiResponse register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return new ApiResponse("User Registered Successfully");
    }


    public ApiResponse login(LoginRequest request) {

            boolean exists = userRepository.findAll()
            .stream()
            .anyMatch(user ->
                    user.getEmail().equals(request.getEmail()) &&
                    user.getPassword().equals(request.getPassword())
                );

        if (exists) {
         return new ApiResponse("Login Successful");
        }

        return new ApiResponse("Invalid Email or Password");
    }
    public List<User> getAllUsers() {

        return userRepository.findAll().stream().toList();
    }
}
