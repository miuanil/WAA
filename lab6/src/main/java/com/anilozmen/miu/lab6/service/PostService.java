package com.anilozmen.miu.lab6.service;

import com.anilozmen.miu.lab6.entity.dto.response.PostDetailDto;
import com.anilozmen.miu.lab6.entity.dto.response.PostDto;

import java.util.List;

public interface PostService {

    PostDetailDto findById(long id);

    List<PostDto> findAll();

    List<PostDto> getPostsByAuthorEquals(String author);

    List<PostDto> getPostsByTitle(String title);

    void save(PostDto postDto);

    void addCommentToThePost(long postId, long commentId);

    void update(long id, PostDto postDto);

    void deleteById(long id);
}
