package com.api.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.resume.dto.request.ResumeRequest;
import com.api.resume.dto.response.ApiResponse;
import com.api.resume.entity.Resume;
import com.api.resume.service.ResumeService;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin("*")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping
    public ApiResponse createResume(@RequestBody ResumeRequest request) {

        return resumeService.createResume(request);

    }

    @GetMapping
    public List<Resume> getAllResumes() {

        return resumeService.getAllResumes();

    }

    @GetMapping("/{id}")
    public Resume getResumeById(@PathVariable Long id) {

        return resumeService.getResumeById(id);

    }

    @PutMapping("/{id}")
    public ApiResponse updateResume(@PathVariable Long id, @RequestBody ResumeRequest request) {

        return resumeService.updateResume(id, request);

    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteResume(@PathVariable Long id) {

        return resumeService.deleteResume(id);

    }

}