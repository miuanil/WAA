package com.anilozmen.miu.lab4.service;

import com.anilozmen.miu.lab4.domain.dto.response.CommentDto;
import com.anilozmen.miu.lab4.domain.dto.response.PostDetailDto;
import com.anilozmen.miu.lab4.domain.dto.response.PostDto;
import com.anilozmen.miu.lab4.domain.dto.response.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    List<UserDto> findUsersByPostSize(Integer total);

    UserDto findById(long id);

    List<PostDto> findPostsById(long id);

    void save(UserDto userDto);

    void addPostToTheUser(long userId, long postId);

    void update(long id, UserDto userDto);

    void deleteById(long id);

    PostDetailDto findPostById(long id, long postId);

    List<CommentDto> findPostCommentsById(long id, long postId);

    CommentDto findPostCommentById(long id, long postId, long commentId);

    void saveCommentToThePost(long id, long postId, long commentId);

}
