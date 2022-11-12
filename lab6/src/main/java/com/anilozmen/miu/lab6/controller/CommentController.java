package com.anilozmen.miu.lab6.controller;

import com.anilozmen.miu.lab6.entity.dto.response.CommentDto;
import com.anilozmen.miu.lab6.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getComments() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto getCommentById(@PathVariable(name = "id") long id) {
        return commentService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveComment(@RequestBody CommentDto commentDto) {
        commentService.save(commentDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCommentById(@PathVariable(name = "id") long id, @RequestBody CommentDto commentDto) {
        commentService.update(id, commentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommentById(@PathVariable(name = "id") long id) {
        commentService.deleteById(id);
    }

}
