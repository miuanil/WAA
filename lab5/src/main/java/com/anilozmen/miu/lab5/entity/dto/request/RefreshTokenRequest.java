package com.anilozmen.miu.lab5.entity.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequest {
    private String accessToken;
    private String refreshToken;
}
