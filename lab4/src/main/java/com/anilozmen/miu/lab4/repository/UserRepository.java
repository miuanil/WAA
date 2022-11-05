package com.anilozmen.miu.lab4.repository;

import com.anilozmen.miu.lab4.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
