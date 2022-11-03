package com.anilozmen.miu.lab2.service.impl;

import com.anilozmen.miu.lab2.domain.PostV1;
import com.anilozmen.miu.lab2.domain.dto.response.PostDtoV1;
import com.anilozmen.miu.lab2.repository.PostRepository;
import com.anilozmen.miu.lab2.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("default")
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PostDtoV1 findById(long id) {
        return modelMapper.map(postRepository.findById(id), PostDtoV1.class);
    }

    @Override
    public List<PostDtoV1> findAll() {
        List<PostV1> posts = postRepository.findAll();
        return posts.stream().map(p -> modelMapper.map(p, PostDtoV1.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDtoV1> getPostsByAuthor(String author) {
        return postRepository.getPostsByAuthor(author).stream()
                .map(e -> modelMapper.map(e, PostDtoV1.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(PostDtoV1 postDtoV1) {
        postRepository.save(modelMapper.map(postDtoV1, PostV1.class));
    }

    @Override
    public void update(long id, PostDtoV1 postDtoV1) {
        PostDtoV1 p = findById(id);
        if (postDtoV1.getAuthor() != null)
            p.setAuthor(postDtoV1.getAuthor());

        if (postDtoV1.getTitle() != null)
            p.setTitle(postDtoV1.getTitle());

        if (postDtoV1.getContent() != null)
            p.setContent(postDtoV1.getContent());

        postRepository.save(modelMapper.map(p, PostV1.class));
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}
