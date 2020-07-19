package com.oyerickshaw.app.repository;

import com.oyerickshaw.app.entity.DriverInfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public interface DriverInfoRepository extends CrudRepository<DriverInfoEntity, Integer> {
    Optional<DriverInfoEntity> findById(Integer id);
}
