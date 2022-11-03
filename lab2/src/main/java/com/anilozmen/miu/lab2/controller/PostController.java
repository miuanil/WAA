package com.anilozmen.miu.lab2.controller;

import com.anilozmen.miu.lab2.domain.Author;
import com.anilozmen.miu.lab2.domain.PostV2;
import com.anilozmen.miu.lab2.domain.dto.response.PostDtoV1;
import com.anilozmen.miu.lab2.service.PostService;
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
        return (author == null) ? postService.findAll() : postService.getPostsByAuthor(author);
    }

    @GetMapping(headers = "X-API-VERSION=2")
    public PostV2 getPostsV2() {
        return new PostV2(1, "Title", "Content", new Author("Bob", "Charlie"));
    }

    @GetMapping("/{id}")
    public PostDtoV1 getPostById(@PathVariable(name = "id") long id) {
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePostById(@PathVariable(name = "id") long id, @RequestBody PostDtoV1 post) {
        postService.update(id, post);
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
