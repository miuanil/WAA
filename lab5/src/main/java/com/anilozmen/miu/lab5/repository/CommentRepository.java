package com.anilozmen.miu.lab5.repository;

import com.anilozmen.miu.lab5.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
