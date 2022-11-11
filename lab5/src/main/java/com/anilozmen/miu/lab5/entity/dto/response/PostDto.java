package com.anilozmen.miu.lab5.entity.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    long id;
    String title;
    String content;
    String author;
}
