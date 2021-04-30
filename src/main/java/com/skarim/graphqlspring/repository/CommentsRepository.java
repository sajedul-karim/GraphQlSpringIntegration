package com.skarim.graphqlspring.repository;

import com.skarim.graphqlspring.domain.CommentsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends CrudRepository<CommentsEntity, Integer> {
    @Override
    public List<CommentsEntity> findAll();
}
