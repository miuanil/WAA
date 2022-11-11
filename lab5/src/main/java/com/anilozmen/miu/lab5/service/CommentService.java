package com.anilozmen.miu.lab5.service;

import com.anilozmen.miu.lab5.entity.dto.response.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto findById(long id);

    List<CommentDto> findAll();

    void save(CommentDto commentDto);

    void update(long id, CommentDto commentDto);

    void deleteById(long id);
}
