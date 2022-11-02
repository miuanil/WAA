package com.anilozmen.miu.lab1.domain.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailV1Dto {
    long id;
    String title;
    String content;
    String author;
}
