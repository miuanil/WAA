package com.anilozmen.miu.lab4.service.impl;

import com.anilozmen.miu.lab4.domain.Comment;
import com.anilozmen.miu.lab4.domain.Post;
import com.anilozmen.miu.lab4.domain.dto.response.PostDetailDto;
import com.anilozmen.miu.lab4.domain.dto.response.PostDto;
import com.anilozmen.miu.lab4.repository.CommentRepository;
import com.anilozmen.miu.lab4.repository.PostRepository;
import com.anilozmen.miu.lab4.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("default")
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PostDetailDto findById(long id) {
        return modelMapper.map(postRepository.findById(id), PostDetailDto.class);
    }

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = (List<Post>) postRepository.findAll();
        return posts.stream().map(p -> modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByAuthorEquals(String author) {
        return postRepository
                .getPostsByAuthorEquals(author)
                .stream()
                .map(e -> modelMapper.map(e, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByTitle(String title) {
        return postRepository.getPostsByTitleEquals(title)
                .stream()
                .map(e -> modelMapper.map(e, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(PostDto postDto) {
        postRepository.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void addCommentToThePost(long postId, long commentId) {
        Post post = modelMapper.map(findById(postId), Post.class);
        Comment comment = commentRepository.findById(commentId).get();

        if (post.getComments() == null)
            post.setComments(Arrays.asList(comment));
        else
            post.getComments().add(comment);

        postRepository.save(post);
    }

    @Override
    public void update(long id, PostDto postDto) {
        PostDetailDto p = findById(id);
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
