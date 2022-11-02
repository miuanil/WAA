package com.anilozmen.miu.lab1.service;

import com.anilozmen.miu.lab1.domain.dto.response.PostDtoV1;

import java.util.List;

public interface PostService {

    public List<PostDtoV1> findAll();

    List<PostDtoV1>findAllByAuthor(String author);

    public PostDtoV1 findById(long id);

    public void save(PostDtoV1 post);

    public void updateById(long id, PostDtoV1 post);

    public void deleteById(long id);
}
