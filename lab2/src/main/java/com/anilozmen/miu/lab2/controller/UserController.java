package com.anilozmen.miu.lab2.controller;

import com.anilozmen.miu.lab2.domain.dto.response.UserDetailDto;
import com.anilozmen.miu.lab2.domain.dto.response.UserDto;
import com.anilozmen.miu.lab2.service.UserService;
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
        return (postCount == null) ? userService.findAll() : userService.findAllByPosts(postCount);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable(name = "id") long id) {
        return userService.findById(id);
    }

    @GetMapping("/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailDto getPostsByUser(@PathVariable(name = "id") long id) {
        return userService.getPostsByUser(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserById(@PathVariable(name = "id") long id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        userService.save(userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable(name = "id") long id) {
        userService.deleteById(id);
    }
}
