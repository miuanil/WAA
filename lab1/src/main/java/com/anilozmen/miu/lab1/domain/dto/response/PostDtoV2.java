package com.anilozmen.miu.lab1.domain.dto.response;

import com.anilozmen.miu.lab1.domain.Author;
import com.anilozmen.miu.lab1.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PostDtoV2 {
    long id;
    String title;
    String content;
    Author author;

    private List<Review> reviews;
}
