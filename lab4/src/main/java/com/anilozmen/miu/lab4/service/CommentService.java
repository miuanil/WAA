package com.anilozmen.miu.lab4.service;

import com.anilozmen.miu.lab4.domain.dto.response.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto findById(long id);

    List<CommentDto> findAll();

    void save(CommentDto commentDto);

    void update(long id, CommentDto commentDto);

    void deleteById(long id);
}
