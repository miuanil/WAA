package com.anilozmen.miu.lab4.repository;

import com.anilozmen.miu.lab4.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
