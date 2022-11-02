package com.anilozmen.miu.lab1.domain;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PostV2 {
    long id;
    String title;
    String content;
    Author author;
}
