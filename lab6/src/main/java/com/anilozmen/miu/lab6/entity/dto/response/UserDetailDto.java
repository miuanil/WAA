package com.anilozmen.miu.lab6.entity.dto.response;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDto {
    long id;
    String name;
    private String email;
    private String firstName;
    private String lastName;
    List<PostDto> posts;
}
