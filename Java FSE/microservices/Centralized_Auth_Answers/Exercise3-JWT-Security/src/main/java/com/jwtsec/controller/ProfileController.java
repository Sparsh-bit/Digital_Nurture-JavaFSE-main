package com.jwtsec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ProfileController {

    @GetMapping("/api/profile")
    public String getProfile(Principal principal) {
        return "Hello " + principal.getName() + ", you have successfully accessed a secured endpoint using a valid JWT!";
    }
}
