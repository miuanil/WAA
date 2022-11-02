package com.anilozmen.miu.lab1.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostV1 {
    long id;
    String title;
    String content;
    String author;
}
