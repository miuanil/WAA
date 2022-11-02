package com.anilozmen.miu.lab1.domain.dto.response;

import com.anilozmen.miu.lab1.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PostDtoV2 {
    long id;
    String title;
    String content;
    Author author;
}
