package com.anilozmen.miu.lab1.repository.impl;

import com.anilozmen.miu.lab1.domain.PostV1;
import com.anilozmen.miu.lab1.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private static List<PostV1> posts;
    private static int postId = 106;

    static {
        posts = new ArrayList<>(Arrays.asList(
                new PostV1(100, "Post 1 Title", "Post Content 1", "John Doe"),
                new PostV1(101, "Post 2 Title", "Post Content 2", "Alex Doe"),
                new PostV1(102, "Post 3 Title", "Post Content 3", "Joseph Doe"),
                new PostV1(103, "Post 4 Title", "Post Content 4", "Ethan Doe"),
                new PostV1(104, "Post 5 Title", "Post Content 5", "Henry Doe"),
                new PostV1(105, "Post 6 Title", "Post Content 6", "Lucas Doe")
        ));
    }

    @Override
    public List<PostV1> findAll() {
        return posts;
    }

    @Override
    public List<PostV1> findAllByAuthor(String author) {
        return posts.stream().filter(p -> p.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public PostV1 findById(long id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateById(long id, PostV1 post) {
        PostV1 updatePost = findById(id);

        if (post.getTitle() != null)
            updatePost.setTitle(post.getTitle());

        if (post.getAuthor() != null)
            updatePost.setAuthor(post.getAuthor());

        if (post.getContent() != null)
            updatePost.setContent(post.getContent());
    }

    @Override
    public void save(PostV1 post) {
        post.setId(postId++);
        posts.add(post);
    }

    @Override
    public void deleteById(long id) {
        PostV1 post = posts.stream().filter(p -> p.getId() == id).findFirst().get();
        posts.remove(post);
    }
}
