package com.anilozmen.miu.lab3.repository;

import com.anilozmen.miu.lab3.domain.Post;
import com.anilozmen.miu.lab3.domain.dto.response.PostDetailDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    Post findById(long id);

    List<Post> getPostsByAuthor(String author);

    PostDetailDto getPostsById(long id);

    List<Post> getPostsByTitleEquals(String title);
}
