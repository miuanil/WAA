package com.anilozmen.miu.lab6.entity.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    long id;
    private String email;
    private String firstName;
    private String lastName;
}
