package com.anilozmen.miu.lab2.domain.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDtoV1 {
    long id;
    String title;
    String content;
    String author;
}
