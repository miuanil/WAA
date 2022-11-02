package com.anilozmen.miu.lab1.domain;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PostV2 {
    long id;
    String title;
    String content;
    Author author;

    private List<Review> reviews;
}
