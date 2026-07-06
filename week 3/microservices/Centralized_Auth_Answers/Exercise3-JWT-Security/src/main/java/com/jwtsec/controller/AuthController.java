package com.jwtsec.controller;

import com.jwtsec.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public String login(@RequestParam String username) {
        // Normally you would verify credentials against a DB here.
        // For simplicity, we just generate a token based on the provided username.
        return jwtTokenProvider.createToken(username);
    }
}
