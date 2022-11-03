package com.anilozmen.miu.lab2.repository;

import com.anilozmen.miu.lab2.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long id);

    List<User> findAll();

    List<User> findAllByPosts(Integer total);
}
