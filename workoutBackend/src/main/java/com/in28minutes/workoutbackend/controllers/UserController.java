package com.in28minutes.workoutbackend.controllers;

import com.in28minutes.workoutbackend.models.User;
import com.in28minutes.workoutbackend.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findbyemail/")
    public ResponseEntity<User> getUserByName(@RequestParam String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userRepository.save(user));
    }

    @GetMapping("/emptyuser")
    public ResponseEntity<User> getEmptyUser() {
        User user = new User();
        user.setId(0);
        user.setFirstname("Max");
        user.setLastname("Schessler");
        user.setEmail("email@gmail.com");
        user.setPassword("password");
        return ResponseEntity.ok().body(user);
    }

}
