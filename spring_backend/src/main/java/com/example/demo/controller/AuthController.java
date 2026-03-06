package com.example.demo.controller;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.LoginRequest;
import com.example.demo.LoginResponse;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService; // Handles authentication & JWT generation

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //  Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        try {
            // Authenticate and generate JWT
            String token = authService.authenticateAndGenerateToken(
                    loginRequest.getCin(),
                    loginRequest.getPassword(),
                    loginRequest.getFullName()
            );

            // Return token in response
            return ResponseEntity.ok(new LoginResponse(token));

        } catch (RuntimeException e) {
            // Invalid credentials
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", e.getMessage()));
        } 
    }

}


