package com.anilozmen.miu.lab2.repository;

import com.anilozmen.miu.lab2.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> getPostsByAuthorEquals(String author);
}
