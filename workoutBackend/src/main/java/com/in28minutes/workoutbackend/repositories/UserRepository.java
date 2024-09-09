package com.in28minutes.workoutbackend.repositories;

import com.in28minutes.workoutbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);


}
