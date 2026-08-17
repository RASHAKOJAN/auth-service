package com.invoiceplatform.auth_service.controller;

import com.invoiceplatform.auth_service.dto.AuthResponse;
import com.invoiceplatform.auth_service.dto.LoginRequest;
import com.invoiceplatform.auth_service.dto.RegisterRequest;
import com.invoiceplatform.auth_service.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return new AuthResponse(authService.register(request));
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return new AuthResponse(authService.login(request));
    }
}