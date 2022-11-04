package com.anilozmen.miu.lab3.domain.dto.response;

import com.anilozmen.miu.lab3.domain.Comment;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailDto {
    long id;
    String title;
    String content;
    String author;
    List<Comment> comments;
}
