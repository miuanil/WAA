package com.anilozmen.miu.lab2.domain.dto.response;

import com.anilozmen.miu.lab2.domain.Author;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class PostDtoV2 {
    long id;
    String title;
    String content;
    Author author;
}
