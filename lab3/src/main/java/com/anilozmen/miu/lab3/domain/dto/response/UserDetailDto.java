package com.anilozmen.miu.lab3.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDto {
    long id;
    String name;
    List<PostDto> posts;
}
