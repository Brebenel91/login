package com.example.login.service;

import com.example.login.enums.Role;
import com.example.login.dao.JwtAuthenticationResponse;
import com.example.login.dao.SignUpRequest;
import com.example.login.dao.SigninRequest;
import com.example.login.model.User;
import com.example.login.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



    @Service
    @RequiredArgsConstructor
    public class AuthenticationService {
        private final AuthUserRepository userRepository;
        private final AuthenticationManager authenticationManager;
        private final PasswordEncoder passwordEncoder;



        public JwtAuthenticationResponse signUp(SignUpRequest request) {
            var user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER).build();
            userRepository.save(user);

            return JwtAuthenticationResponse.builder().build();
        }
        public JwtAuthenticationResponse signIn(SigninRequest request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//            var user = userRepository.findByEmail(request.getEmail())
//                    .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

            return JwtAuthenticationResponse.builder().build();
        }
    }

