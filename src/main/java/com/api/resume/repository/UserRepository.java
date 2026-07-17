package com.api.resume.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.resume.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
