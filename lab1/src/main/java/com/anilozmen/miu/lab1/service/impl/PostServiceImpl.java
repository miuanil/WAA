package com.anilozmen.miu.lab1.service.impl;

import com.anilozmen.miu.lab1.domain.PostV1;
import com.anilozmen.miu.lab1.domain.dto.response.PostDtoV1;
import com.anilozmen.miu.lab1.repository.PostRepository;
import com.anilozmen.miu.lab1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PostDtoV1> findAll() {
        List<PostV1> posts = postRepository.findAll();
        return posts.stream().map(p -> modelMapper.map(p, PostDtoV1.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDtoV1> findAllByAuthor(String author) {
        return postRepository.findAllByAuthor(author).stream()
                .map(e -> modelMapper.map(e, PostDtoV1.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDtoV1 findById(long id) {
        return modelMapper.map(postRepository.findById(id), PostDtoV1.class);
    }

    @Override
    public void updateById(long id, PostDtoV1 post) {
        postRepository.updateById(id, modelMapper.map(post, PostV1.class));
    }

    @Override
    public void save(PostDtoV1 post) {
        postRepository.save(modelMapper.map(post, PostV1.class));
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}
