package com.anilozmen.miu.lab2.domain.dto.response;

import com.anilozmen.miu.lab2.domain.PostV1;
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
    List<PostV1> posts;
}
