package com.anilozmen.miu.lab3.service.impl;

import com.anilozmen.miu.lab3.domain.Comment;
import com.anilozmen.miu.lab3.domain.Post;
import com.anilozmen.miu.lab3.domain.User;
import com.anilozmen.miu.lab3.domain.dto.response.CommentDto;
import com.anilozmen.miu.lab3.domain.dto.response.PostDetailDto;
import com.anilozmen.miu.lab3.domain.dto.response.PostDto;
import com.anilozmen.miu.lab3.domain.dto.response.UserDto;
import com.anilozmen.miu.lab3.repository.CommentRepository;
import com.anilozmen.miu.lab3.repository.PostRepository;
import com.anilozmen.miu.lab3.repository.UserRepository;
import com.anilozmen.miu.lab3.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream().map(p -> modelMapper.map(p, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepository.findById(id), UserDto.class);
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
    public List<PostDto> findPostsById(long id) {
        return userRepository.findById(id).get()
                .getPosts()
                .stream()
                .map(e -> modelMapper.map(e, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addPostToTheUser(long userId, long postId) {
        User user = modelMapper.map(findById(userId), User.class);
        Post post = postRepository.findById(postId).get();

        if (user.getPosts() == null)
            user.setPosts(Arrays.asList(post));
        else
            user.getPosts().add(post);

        userRepository.save(user);
    }

    @Override
    public void update(long id, UserDto userDto) {
        User u = modelMapper.map(userRepository.findById(id), User.class);

        if (u.getName() != null) {
            u.setName(userDto.getName());
        }
        userRepository.save(modelMapper.map(u, User.class));
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public PostDetailDto findPostById(long id, long postId) {
        User user = userRepository.findById(id).get();
        Post post = user.getPosts().stream().filter(p -> p.getId() == postId).findFirst().get();
        return modelMapper.map(post, PostDetailDto.class);
    }

    @Override
    public List<CommentDto> findPostCommentsById(long id, long postId) {
        User user = userRepository.findById(id).get();

        Post post = user
                .getPosts()
                .stream()
                .filter(p -> p.getId() == postId)
                .findFirst()
                .get();

        return post
                .getComments()
                .stream()
                .map(e -> modelMapper.map(e, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto findPostCommentById(long id, long postId, long commentId) {
        User user = userRepository.findById(id).get();
        Post post = user
                .getPosts()
                .stream()
                .filter(p -> p.getId() == postId)
                .findFirst().get();
        Comment comment = post
                .getComments()
                .stream()
                .filter(c -> c.getId() == commentId)
                .findFirst().get();

        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public void saveCommentToThePost(long id, long postId, long commentId) {
        User user = userRepository.findById(id).get();
        Optional<Post> post = user
                .getPosts()
                .stream()
                .filter(p -> p.getId() == postId)
                .findFirst();

        Post originalPost = postRepository.findById(postId).get();

        if (!post.isPresent())
            user.getPosts().add(originalPost);

        Comment comment = commentRepository.findById(commentId).get();

        originalPost.getComments().add(comment);

        postRepository.save(originalPost);
        userRepository.save(user);
    }
}
