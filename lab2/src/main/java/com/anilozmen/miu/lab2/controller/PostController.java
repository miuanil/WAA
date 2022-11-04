package com.anilozmen.miu.lab2.controller;

import com.anilozmen.miu.lab2.domain.dto.response.PostDto;
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
    public List<PostDto> getPosts(@RequestParam(value = "filter", required = false) String author) {
        return (author == null) ? postService.findAll() : postService.getPostsByAuthor(author);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPostById(@PathVariable(name = "id") long id) {
        return postService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PostDto post) {
        postService.save(post);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePostById(@PathVariable(name = "id") long id, @RequestBody PostDto post) {
        postService.update(id, post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostById(@PathVariable(name = "id") long id) {
        postService.deleteById(id);
    }
}
