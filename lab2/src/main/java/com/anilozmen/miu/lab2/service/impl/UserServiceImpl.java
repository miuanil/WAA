package com.anilozmen.miu.lab2.service.impl;

import com.anilozmen.miu.lab2.domain.Post;
import com.anilozmen.miu.lab2.domain.User;
import com.anilozmen.miu.lab2.domain.dto.response.PostDto;
import com.anilozmen.miu.lab2.domain.dto.response.UserDto;
import com.anilozmen.miu.lab2.repository.PostRepository;
import com.anilozmen.miu.lab2.repository.UserRepository;
import com.anilozmen.miu.lab2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {

        List<User> users = (List<User>) userRepository.findAll();

        return users.stream()
                .map(p -> modelMapper.map(p, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepository.findById(id), UserDto.class);
    }

    @Override
    public List<UserDto> findAllByPosts(Integer postCount) {
        return ((List<User>) userRepository.findAll()).stream()
                .filter(e -> e.getPosts().size() >= postCount)
                .map(e -> modelMapper.map(e, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserDto userDto) {
        userRepository.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public void update(long id, UserDto userDto) {
        User user = userRepository.findById(id).get();

        if (user.getName() != null)
            user.setName(userDto.getName());

        userRepository.save(modelMapper.map(user, User.class));
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<PostDto> findPostsById(long id) {
        return userRepository.findById(id).get()
                .getPosts()
                .stream()
                .map(e -> modelMapper.map(e, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addPostToTheUser(long userId, long postId) {
        User user = modelMapper.map(userRepository.findById(userId), User.class);
        Post post = postRepository.findById(postId).get();

        if (user.getPosts() == null)
            user.setPosts(Arrays.asList(post));
        else
            user.getPosts().add(post);

        userRepository.save(user);
    }
}
