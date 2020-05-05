package org.com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping(value = "/")
    public String hello(){
        return "<h1>Hello World<h1>";
    }

}
