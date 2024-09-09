package com.in28minutes.workoutbackend.controllers;

import com.in28minutes.workoutbackend.models.User;
import com.in28minutes.workoutbackend.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.OptionalInt;

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
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
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
        user.setName("maxschessler");
        user.setEmail("email@gmail.com");
        user.setPassword("password");
        return ResponseEntity.ok().body(user);
    }

}
