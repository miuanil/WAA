package com.anilozmen.miu.lab6.controller;

import com.anilozmen.miu.lab6.entity.dto.response.PostDetailDto;
import com.anilozmen.miu.lab6.entity.dto.response.PostDto;
import com.anilozmen.miu.lab6.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getPosts(@RequestParam(value = "filter", required = false) String title) {
        return (title == null) ? postService.findAll() : postService.getPostsByTitle(title);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDetailDto getPostById(@PathVariable(name = "id") long id) {
        return postService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(@RequestBody PostDto post) {
        postService.save(post);
    }

    @PostMapping("/{id}/comments/{commentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCommentToPost(@PathVariable(name = "id") long id, @PathVariable(name = "commentId") long commentId) {
        postService.addCommentToThePost(id, commentId);
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
