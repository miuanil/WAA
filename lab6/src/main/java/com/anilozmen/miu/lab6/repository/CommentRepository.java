package com.anilozmen.miu.lab6.repository;

import com.anilozmen.miu.lab6.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
