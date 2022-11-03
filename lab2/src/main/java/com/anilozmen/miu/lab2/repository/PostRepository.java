package com.anilozmen.miu.lab2.repository;

import com.anilozmen.miu.lab2.domain.PostV1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostV1, Long> {

    PostV1 findById(long id);

    List<PostV1> findAll();

    List<PostV1> getPostsByAuthor(String author);
}
