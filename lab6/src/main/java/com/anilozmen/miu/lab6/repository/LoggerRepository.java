package com.anilozmen.miu.lab6.repository;

import com.anilozmen.miu.lab6.entity.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends CrudRepository<Logger, Long> {
}
