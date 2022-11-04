package com.anilozmen.miu.lab2.service;

import com.anilozmen.miu.lab2.domain.dto.response.PostDto;

import java.util.List;

public interface PostService {

    PostDto findById(long id);

    List<PostDto> findAll();

    List<PostDto> getPostsByAuthor(String author);

    void save(PostDto postDto);

    void update(long id, PostDto postDto);

    void deleteById(long id);
}
