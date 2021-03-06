package org.com.controller;

import org.com.error.RecordNotFoundException;
import org.com.model.users;
import org.com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<users> addUser(@Valid @RequestBody users user) {
        try {
            userService.addUser(user);
            return new ResponseEntity<users>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.IM_USED);
        }

    }

    @GetMapping("/user/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<users> findUserById(@PathVariable("id") int userId) {
        Optional<users> findById = userService.viewUserById(userId);
        try {
            if (findById.isPresent()) {
                users user = findById.get();
                return new ResponseEntity<users>(user, HttpStatus.FOUND);
            } else {
                throw new RecordNotFoundException("No user record found with the provided " + userId + " user Id.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity("No user record found with the provided " + userId + " user Id." + e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user")
    public List<users> viewAllUser() {
        return userService.viewAllUser();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<users> modifyUser(@Valid @RequestBody users users, @PathVariable("id") int userId) {
        Optional<users> findById = userService.viewUserById(userId);
        try {
            if (findById.isPresent()) {
                userService.updateUser(users);
                return new ResponseEntity(users, HttpStatus.CREATED);
            } else {
                throw new RecordNotFoundException("No User record with  user Id " + userId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<users> deleteUser(@PathVariable("id") int userId) {
        Optional<users> findById = userService.viewUserById(userId);
        try {
            if (findById.isPresent()) {
                userService.deleteUser(userId);
                return new ResponseEntity(findById, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No record with user Id " + userId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }
}
