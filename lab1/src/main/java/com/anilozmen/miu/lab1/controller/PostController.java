package com.anilozmen.miu.lab1.controller;

import com.anilozmen.miu.lab1.domain.Author;
import com.anilozmen.miu.lab1.domain.PostV2;
import com.anilozmen.miu.lab1.domain.dto.response.PostDetailV1Dto;
import com.anilozmen.miu.lab1.domain.dto.response.PostDtoV1;
import com.anilozmen.miu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PostDtoV1> getPosts(@RequestParam(value = "filter", required = false) String author) {
        return (author == null) ? postService.findAll() : postService.findAllByAuthor(author);
    }

    @GetMapping(headers = "X-API-VERSION=2")
    public PostV2 getPostsV2() {
        return new PostV2(1, "Title", "Content", new Author("Bob", "Charlie"));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDetailV1Dto getPostById(@PathVariable(name = "id") long id) {
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePostById(@PathVariable(name = "id") long id, @RequestBody PostDtoV1 post) {
        postService.updateById(id, post);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PostDtoV1 post) {
        postService.save(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostById(@PathVariable(name = "id") long id) {
        postService.deleteById(id);
    }
}
