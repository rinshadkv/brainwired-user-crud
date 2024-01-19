package com.brainwired.usercrud.controller;

import com.brainwired.usercrud.model.User;
import com.brainwired.usercrud.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);


    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.debug("REST request to create user");

        if (user.getId() != null) {
            throw new IllegalArgumentException("A new user cannot already have an ID");
        }
        if (user.getFirstName() == null) {
            throw new IllegalArgumentException("first name cannot be null");
        }
        if (user.getDob() == null) {
            throw new IllegalArgumentException("date of birth cannot be null");
        }

        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        log.debug("REST request to update user : {}, {}", id, user);
        if (user.getId() == null && id == null) {
            throw new IllegalArgumentException("id is null");
        }
        if (!userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("user not found");
        }
        User existingUser = userRepository.save(user);
        return new ResponseEntity<>(existingUser, HttpStatus.CREATED);

    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAllByIsDeletedIsFalse();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getOneUser(@PathVariable long id) {
        Optional<User> user = userRepository.findByIdAndIsDeletedIsFalse(id);

        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneUser(@PathVariable long id){
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
