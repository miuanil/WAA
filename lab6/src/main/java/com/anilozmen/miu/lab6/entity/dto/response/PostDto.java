package com.anilozmen.miu.lab6.entity.dto.response;

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
