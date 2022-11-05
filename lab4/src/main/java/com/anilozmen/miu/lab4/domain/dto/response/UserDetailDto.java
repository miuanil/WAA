package com.anilozmen.miu.lab4.domain.dto.response;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDto {
    long id;
    String name;
    List<PostDto> posts;
}
