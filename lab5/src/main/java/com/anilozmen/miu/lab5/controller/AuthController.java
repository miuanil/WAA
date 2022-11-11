package com.anilozmen.miu.lab5.controller;

import com.anilozmen.miu.lab5.entity.dto.request.LoginRequest;
import com.anilozmen.miu.lab5.entity.dto.request.RefreshTokenRequest;
import com.anilozmen.miu.lab5.entity.dto.response.LoginResponse;
import com.anilozmen.miu.lab5.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {

        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

}
