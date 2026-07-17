package com.api.resume.dto.response;

import lombok.Data;

@Data
public class ResumeResponse {

    private Long id;

    private Long userId;

    private String fullName;

    private String phone;

    private String address;

    private String education;

    private String skills;

    private String experience;

}
