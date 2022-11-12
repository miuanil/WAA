package com.anilozmen.miu.lab6.repository;

import com.anilozmen.miu.lab6.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> getPostsByAuthor(String author);

    List<Post> getPostsByAuthorEquals(String author);

    List<Post> getPostsByTitleEquals(String title);
}
