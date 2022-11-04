package com.anilozmen.miu.lab2.service.impl;

import com.anilozmen.miu.lab2.domain.Post;
import com.anilozmen.miu.lab2.domain.dto.response.PostDto;
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
    public PostDto findById(long id) {
        return modelMapper.map(postRepository.findById(id), PostDto.class);
    }

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = ((List<Post>) postRepository.findAll());
        return posts.stream().map(p -> modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByAuthor(String author) {
        return postRepository
                .getPostsByAuthorEquals(author)
                .stream()
                .map(e -> modelMapper.map(e, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(PostDto postDto) {
        postRepository.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void update(long id, PostDto postDto) {
        PostDto p = findById(id);
        if (postDto.getAuthor() != null)
            p.setAuthor(postDto.getAuthor());

        if (postDto.getTitle() != null)
            p.setTitle(postDto.getTitle());

        if (postDto.getContent() != null)
            p.setContent(postDto.getContent());

        postRepository.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}
