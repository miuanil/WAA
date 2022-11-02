package com.anilozmen.miu.lab1.domain.dto.response;

import com.anilozmen.miu.lab1.domain.Review;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailV1Dto {
    long id;
    String title;
    String content;
    String author;

    private List<Review> reviews;
}
