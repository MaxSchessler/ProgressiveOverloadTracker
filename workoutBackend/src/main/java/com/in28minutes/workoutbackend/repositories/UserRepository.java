package com.in28minutes.workoutbackend.repositories;

import com.in28minutes.workoutbackend.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);
}
