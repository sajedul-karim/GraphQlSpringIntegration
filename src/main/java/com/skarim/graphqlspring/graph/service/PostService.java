package com.skarim.graphqlspring.graph.service;

import com.skarim.graphqlspring.domain.PostEntity;

import java.util.List;

public interface PostService {
    PostEntity createPost(Integer userId, String title, String description, String postDate);
    PostEntity findByPostId(Integer postId);
    List<PostEntity> findByUserId(Integer userId);

    List<PostEntity> findAll();
}
