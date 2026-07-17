package com.api.resume.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.resume.dto.request.ResumeRequest;
import com.api.resume.dto.response.ApiResponse;
import com.api.resume.entity.Resume;
import com.api.resume.repository.ResumeRepository;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public ApiResponse createResume(ResumeRequest request) {

        Resume resume = new Resume();

        resume.setUserId(request.getUserId());
        resume.setFullName(request.getFullName());
        resume.setPhone(request.getPhone());
        resume.setAddress(request.getAddress());
        resume.setEducation(request.getEducation());
        resume.setSkills(request.getSkills());
        resume.setExperience(request.getExperience());

        resumeRepository.save(resume);

        return new ApiResponse("Resume Created Successfully");
    }

    // Get All Resumes
    public List<Resume> getAllResumes() {

        return resumeRepository.findAll();

    }

    // Get Resume By Id
    public Resume getResumeById(Long id) {

        Optional<Resume> resume = resumeRepository.findById(id);

        if (resume.isPresent()) {
            return resume.get();
        }

        return null;

    }

    // Update Resume
    public ApiResponse updateResume(Long id, ResumeRequest request) {

        Resume resume = resumeRepository.findById(id).orElse(null);

        if (resume == null) {
            return new ApiResponse("Resume Not Found");
        }
        resume.setUserId(request.getUserId());
        resume.setFullName(request.getFullName());
        resume.setPhone(request.getPhone());
        resume.setAddress(request.getAddress());
        resume.setEducation(request.getEducation());
        resume.setSkills(request.getSkills());
        resume.setExperience(request.getExperience());

        resumeRepository.save(resume);

        return new ApiResponse("Resume Updated Successfully");

    }

    // Delete Resume
    public ApiResponse deleteResume(Long id) {

        if (!resumeRepository.existsById(id)) {
            return new ApiResponse("Resume Not Found");
        }

        resumeRepository.deleteById(id);

        return new ApiResponse("Resume Deleted Successfully");
    }

}
