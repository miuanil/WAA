package com.anilozmen.miu.lab3.service;

import com.anilozmen.miu.lab3.domain.dto.response.PostDetailDto;
import com.anilozmen.miu.lab3.domain.dto.response.UserDetailDto;
import com.anilozmen.miu.lab3.domain.dto.response.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    List<UserDto> findUsersByPostSize(Integer total);

    UserDetailDto findById(long id);

    List<PostDetailDto> findPostsById(long id);

    void save(UserDto userDto);

    void addPostToTheUser(long userId, long postId);

    void update(long id, UserDto userDto);

    void deleteById(long id);

}
