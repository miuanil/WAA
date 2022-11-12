package com.anilozmen.miu.lab6.service.impl;

import com.anilozmen.miu.lab6.entity.Comment;
import com.anilozmen.miu.lab6.entity.dto.response.CommentDto;
import com.anilozmen.miu.lab6.repository.CommentRepository;
import com.anilozmen.miu.lab6.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CommentDto findById(long id) {
        return modelMapper.map(commentRepository.findById(id), CommentDto.class);
    }

    @Override
    public List<CommentDto> findAll() {
        List<Comment> comments = ((List<Comment>) commentRepository.findAll())
                .stream()
                .map(e -> modelMapper.map(e, Comment.class))
                .collect(Collectors.toList());

        return comments
                .stream()
                .map(c -> modelMapper.map(c, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(CommentDto commentDto) {
        commentRepository.save(modelMapper.map(commentDto, Comment.class));
    }

    @Override
    public void update(long id, CommentDto commentDto) {
        CommentDto comment = findById(id);

        if (commentDto.getName() != null)
            comment.setName(commentDto.getName());

        commentRepository.save(modelMapper.map(comment, Comment.class));
    }

    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }
}
