package com.skarim.graphqlspring.repository;

import com.skarim.graphqlspring.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    @Override
    List<UserEntity> findAll();

}
