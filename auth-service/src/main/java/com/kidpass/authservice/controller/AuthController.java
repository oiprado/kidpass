package com.kidpass.authservice.controller;

import com.kidpass.authservice.client.UserClient;
import com.kidpass.authservice.dto.AuthRequest;
import com.kidpass.authservice.dto.AuthResponse;
import com.kidpass.authservice.dto.User;
import com.kidpass.authservice.security.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserClient userClient;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AuthRequest authRequest) {
        logger.info("registerUser method called");
        logger.info("Registering user: {}", authRequest.getUsername());
        if (userClient.getUserByUsername(authRequest.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }

        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(authRequest.getPassword());

        userClient.registerUser(user);

        String jwt = tokenProvider.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}
