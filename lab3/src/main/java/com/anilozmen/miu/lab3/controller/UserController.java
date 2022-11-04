package com.anilozmen.miu.lab3.controller;

import com.anilozmen.miu.lab3.domain.dto.response.PostDetailDto;
import com.anilozmen.miu.lab3.domain.dto.response.UserDetailDto;
import com.anilozmen.miu.lab3.domain.dto.response.UserDto;
import com.anilozmen.miu.lab3.service.UserService;
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailDto getUser(@PathVariable(name = "id") long id) {
        return userService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserById(@PathVariable(name = "id") long id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @GetMapping("/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDetailDto> getPostsById(@PathVariable(name = "id") long id) {
        return userService.findPostsById(id);
    }

    @PostMapping("/{id}/posts/{postId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(@PathVariable(name = "id") long id, @PathVariable(name = "postId") long postId) {
        userService.addPostToTheUser(id, postId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable(name = "id") long id) {
        userService.deleteById(id);
    }
}
