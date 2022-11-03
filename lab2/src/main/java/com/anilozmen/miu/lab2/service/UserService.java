package com.anilozmen.miu.lab2.service;

import com.anilozmen.miu.lab2.domain.dto.response.UserDetailDto;
import com.anilozmen.miu.lab2.domain.dto.response.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    List<UserDto> findAllByPosts(Integer total);

    UserDetailDto getPostsByUser(long id);

    UserDto findById(long id);

    void save(UserDto userDto);

    void update(long id, UserDto userDto);

    void deleteById(long id);
}
