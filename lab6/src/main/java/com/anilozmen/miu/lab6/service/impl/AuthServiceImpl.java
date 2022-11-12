package com.anilozmen.miu.lab6.service.impl;

import com.anilozmen.miu.lab6.entity.dto.request.*;
import com.anilozmen.miu.lab6.entity.dto.response.LoginResponse;
import com.anilozmen.miu.lab6.service.AuthService;
import com.anilozmen.miu.lab6.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            Authentication result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }
        return generateTokens(loginRequest.getEmail());
    }

    public LoginResponse generateTokens(String email) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(email);
        return new LoginResponse(accessToken, refreshToken);
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());

        if (isRefreshTokenValid) {

            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());

            if (isAccessTokenExpired) {
                System.out.println("ACCESS TOKEN IS EXPIRED");
                String accessToken = jwtUtil.doGenerateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
                return new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            }

            // TODO (OPTIONAL) When to renew the refresh token?
            return new LoginResponse(refreshTokenRequest.getAccessToken(), refreshTokenRequest.getRefreshToken());
        }

        return new LoginResponse();
    }
}
