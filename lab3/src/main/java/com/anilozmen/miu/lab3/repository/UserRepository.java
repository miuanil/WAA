package com.anilozmen.miu.lab3.repository;

import com.anilozmen.miu.lab3.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
}
