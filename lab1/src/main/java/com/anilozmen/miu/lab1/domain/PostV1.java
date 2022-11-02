package com.anilozmen.miu.lab1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostV1 {
    long id;
    String title;
    String content;
    String author;

    private List<Review> reviews;
}
