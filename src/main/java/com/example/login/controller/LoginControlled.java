package com.example.login.controller;

import com.example.login.dao.JwtAuthenticationResponse;
import com.example.login.dao.SignUpRequest;
import com.example.login.dao.SigninRequest;
import com.example.login.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginControlled {

    AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest signUpRequest) throws Exception {

        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SigninRequest signinRequest) throws Exception {
        return ResponseEntity.ok(authenticationService.signIn(signinRequest));
    }
}
