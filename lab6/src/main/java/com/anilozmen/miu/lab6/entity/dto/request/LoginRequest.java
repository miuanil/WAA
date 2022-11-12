package com.anilozmen.miu.lab6.entity.dto.request;

import lombok.*;

@Data
@Builder
public class LoginRequest {
    private String email;
    private String password;
}
