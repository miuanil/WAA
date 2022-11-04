package com.anilozmen.miu.lab2.service;

import com.anilozmen.miu.lab2.domain.dto.response.PostDto;
import com.anilozmen.miu.lab2.domain.dto.response.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    List<UserDto> findAllByPosts(Integer total);

    UserDto findById(long id);

    void save(UserDto userDto);

    void update(long id, UserDto userDto);

    void deleteById(long id);

    List<PostDto> findPostsById(long id);

    void addPostToTheUser(long userId, long postId);
}
