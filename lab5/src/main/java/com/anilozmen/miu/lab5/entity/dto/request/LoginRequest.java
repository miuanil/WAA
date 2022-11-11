package com.anilozmen.miu.lab5.entity.dto.request;

import lombok.*;

@Data
@Builder
public class LoginRequest {
    private String email;
    private String password;
}
