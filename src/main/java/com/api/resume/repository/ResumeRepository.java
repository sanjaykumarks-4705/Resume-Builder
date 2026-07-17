package com.api.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.resume.entity.Resume;
public interface ResumeRepository extends JpaRepository<Resume, Long> {
        List<Resume> findBySkillsContaining(String skill);

}
