package com.anilozmen.miu.lab1.repository;

import com.anilozmen.miu.lab1.domain.PostV1;

import java.util.List;

public interface PostRepository {
    public List<PostV1> findAll();

    public List<PostV1> findAllByAuthor(String author);

    public PostV1 findById(long id);

    public void updateById(long id, PostV1 post);

    public void save(PostV1 post);

    public void deleteById(long id);
}
