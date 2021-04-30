package com.skarim.graphqlspring.repository;

import com.skarim.graphqlspring.domain.PostEntity;
import com.skarim.graphqlspring.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {
    @Override
    List<PostEntity> findAll();
}
