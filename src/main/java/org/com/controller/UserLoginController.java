package org.com.controller;

import org.com.model.UserLogin;
import org.com.model.users;
import org.com.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @PostMapping("/login")
    public ResponseEntity<Optional<users>> userLogin(@Valid @RequestBody UserLogin userLogin) {
        try {
            Optional<users> user = userLoginService.userLogin(userLogin);
            return new ResponseEntity<Optional<users>>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.IM_USED);
        }

    }
}
