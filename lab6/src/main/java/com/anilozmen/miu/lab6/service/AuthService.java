package com.anilozmen.miu.lab6.service;

import com.anilozmen.miu.lab6.entity.dto.request.LoginRequest;
import com.anilozmen.miu.lab6.entity.dto.request.RefreshTokenRequest;
import com.anilozmen.miu.lab6.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

