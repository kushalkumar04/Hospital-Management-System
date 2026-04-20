package com.example.hospitalmanagementsystem.repository;

/*
 * User Repository
 * Handles DB operations for User
 */


import com.bridgelabz.hospitalmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}