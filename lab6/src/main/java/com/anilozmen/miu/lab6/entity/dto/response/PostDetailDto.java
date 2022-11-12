package com.anilozmen.miu.lab6.entity.dto.response;

import com.anilozmen.miu.lab6.entity.Comment;
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
