package com.anilozmen.miu.lab1.domain;

import lombok.*;

@Data
@AllArgsConstructor

public class Review {
    private int id;
    private String comment;
    private int star;
}
