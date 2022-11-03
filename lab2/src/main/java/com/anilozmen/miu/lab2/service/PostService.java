package com.anilozmen.miu.lab2.service;

import com.anilozmen.miu.lab2.domain.dto.response.PostDtoV1;

import java.util.List;

public interface PostService {

    PostDtoV1 findById(long id);

    List<PostDtoV1> findAll();

    List<PostDtoV1> getPostsByAuthor(String author);

    void save(PostDtoV1 postDtoV1);

    void update(long id, PostDtoV1 postDtoV1);

    void deleteById(long id);
}
