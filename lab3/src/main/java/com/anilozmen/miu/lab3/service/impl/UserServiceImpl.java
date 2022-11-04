package com.anilozmen.miu.lab3.service.impl;

import com.anilozmen.miu.lab3.domain.Post;
import com.anilozmen.miu.lab3.domain.User;
import com.anilozmen.miu.lab3.domain.dto.response.PostDetailDto;
import com.anilozmen.miu.lab3.domain.dto.response.UserDetailDto;
import com.anilozmen.miu.lab3.domain.dto.response.UserDto;
import com.anilozmen.miu.lab3.repository.PostRepository;
import com.anilozmen.miu.lab3.repository.UserRepository;
import com.anilozmen.miu.lab3.service.UserService;
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
        return users.stream().map(p -> modelMapper.map(p, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDetailDto findById(long id) {
        return modelMapper.map(userRepository.findById(id), UserDetailDto.class);
    }

    public List<UserDto> findUsersByPostSize(Integer postCount) {
        return ((List<User>) userRepository.findAll()).stream()
                .filter(e -> e.getPosts().size() > postCount)
                .map(e -> modelMapper.map(e, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserDto userDto) {
        userRepository.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public List<PostDetailDto> findPostsById(long id) {
        return userRepository.findById(id)
                .getPosts()
                .stream()
                .map(e -> modelMapper.map(e, PostDetailDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addPostToTheUser(long userId, long postId) {
        User user = modelMapper.map(findById(userId), User.class);
        Post post = postRepository.findById(postId);

        if (user.getPosts() == null)
            user.setPosts(Arrays.asList(post));
        else
            user.getPosts().add(post);

        userRepository.save(user);
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
