package com.kidpass.authservice;

import com.kidpass.authservice.client.UserClient;
import com.kidpass.authservice.controller.AuthController;
import com.kidpass.authservice.dto.AuthRequest;
import com.kidpass.authservice.dto.AuthResponse;
import com.kidpass.authservice.dto.User;
import com.kidpass.authservice.security.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtTokenProvider tokenProvider;

    @Mock
    private UserClient userClient;

    @InjectMocks
    private AuthController authController;

    private AuthRequest authRequest;
    private User user;

    @BeforeEach
    void setUp() {
        authRequest = new AuthRequest();
        authRequest.setUsername("testuser");
        authRequest.setPassword("password");

        user = new User();
        user.setUsername("testuser");
        user.setPassword("encodedPassword");
    }

    @Test
    void authenticateUser_Success_ReturnsJwtToken() {
        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);
        when(tokenProvider.generateToken("testuser")).thenReturn("jwt_token");

        ResponseEntity<?> response = authController.authenticateUser(authRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("jwt_token", ((AuthResponse) response.getBody()).getToken());
    }

    @Test
    void registerUser_Success_ReturnsJwtToken() {
        when(userClient.getUserByUsername("testuser")).thenReturn(null);
        when(userClient.registerUser(any(User.class))).thenReturn(user);
        when(tokenProvider.generateToken("testuser")).thenReturn("jwt_token");

        ResponseEntity<?> response = authController.registerUser(authRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("jwt_token", ((AuthResponse) response.getBody()).getToken());
    }

    @Test
    void registerUser_UserAlreadyExists_ReturnsBadRequest() {
        when(userClient.getUserByUsername("testuser")).thenReturn(user);

        ResponseEntity<?> response = authController.registerUser(authRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Username is already taken!", response.getBody());
    }
}
