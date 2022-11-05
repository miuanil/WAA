package com.anilozmen.miu.lab4.repository;

import com.anilozmen.miu.lab4.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends CrudRepository<Logger, Long> {
}
