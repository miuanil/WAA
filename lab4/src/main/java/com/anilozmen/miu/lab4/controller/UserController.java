package com.anilozmen.miu.lab4.controller;

import com.anilozmen.miu.lab4.aspect.annotation.ExecutionTime;
import com.anilozmen.miu.lab4.domain.dto.response.CommentDto;
import com.anilozmen.miu.lab4.domain.dto.response.PostDetailDto;
import com.anilozmen.miu.lab4.domain.dto.response.PostDto;
import com.anilozmen.miu.lab4.domain.dto.response.UserDto;
import com.anilozmen.miu.lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers(@RequestParam(value = "filter", required = false) Integer postCount) {
        return (postCount == null) ? userService.findAll() : userService.findUsersByPostSize(postCount);
    }

    @ExecutionTime
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable(name = "id") long id) {
        return userService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserById(@PathVariable(name = "id") long id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @GetMapping("/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getPostsById(@PathVariable(name = "id") long id) {
        return userService.findPostsById(id);
    }

    @PostMapping("/{id}/posts/{postId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(@PathVariable(name = "id") long id, @PathVariable(name = "postId") long postId) {
        userService.addPostToTheUser(id, postId);
    }

    @GetMapping("/{id}/posts/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public PostDetailDto getPostById(@PathVariable(name = "id") long id, @PathVariable(name = "postId") long postId) {
        return userService.findPostById(id, postId);
    }

    @GetMapping("/{id}/posts/{postId}/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getPostComments(@PathVariable(name = "id") long id, @PathVariable(name = "postId") long postId) {
        return userService.findPostCommentsById(id, postId);
    }

    @GetMapping("/{id}/posts/{postId}/comments/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto getPostComment(@PathVariable(name = "id") long id, @PathVariable(name = "postId") long postId, @PathVariable(name = "commentId") long commentId) {
        return userService.findPostCommentById(id, postId, commentId);
    }

    @PostMapping("/{id}/posts/{postId}/comments/{commentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCommentToThePost(@PathVariable(name = "id") long id, @PathVariable(name = "postId") long postId, @PathVariable(name = "commentId") long commentId) {
        userService.saveCommentToThePost(id, postId, commentId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable(name = "id") long id) {
        userService.deleteById(id);
    }
}
