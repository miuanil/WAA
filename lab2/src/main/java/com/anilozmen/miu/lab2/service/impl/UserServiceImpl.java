package com.anilozmen.miu.lab2.service.impl;

import com.anilozmen.miu.lab2.domain.User;
import com.anilozmen.miu.lab2.domain.dto.response.UserDetailDto;
import com.anilozmen.miu.lab2.domain.dto.response.UserDto;
import com.anilozmen.miu.lab2.repository.UserRepository;
import com.anilozmen.miu.lab2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(p -> modelMapper.map(p, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepository.findById(id), UserDto.class);
    }

    @Override
    public UserDetailDto getPostsByUser(long id) {
        return modelMapper.map(userRepository.findById(id), UserDetailDto.class);
    }

    @Override
    public List<UserDto> findAllByPosts(Integer postCount) {
        return userRepository.findAll().stream()
                .filter(e -> e.getPosts().size() > postCount)
                .map(e -> modelMapper.map(e, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserDto userDto) {
        userRepository.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public void update(long id, UserDto userDto) {
        User u = userRepository.findById(id);

        if (u.getName() != null) {
            u.setName(userDto.getName());
        }
        userRepository.save(modelMapper.map(u, User.class));
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
