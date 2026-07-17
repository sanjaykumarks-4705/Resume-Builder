package com.api.resume.dto.request;

import lombok.Data;

@Data
public class ResumeRequest {

    private Long userId;

    private String fullName;

    private String phone;

    private String address;

    private String education;

    private String skills;

    private String experience;

}

