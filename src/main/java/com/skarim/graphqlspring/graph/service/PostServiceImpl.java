package com.skarim.graphqlspring.graph.service;

import com.skarim.graphqlspring.domain.PostEntity;
import com.skarim.graphqlspring.domain.UserEntity;
import com.skarim.graphqlspring.repository.PostRepository;
import com.skarim.graphqlspring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostEntity createPost(Integer userId, String title, String description, String postDate) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if(!userEntityOptional.isPresent()){
            throw new RuntimeException("Invalid user provided");
        }

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(title);
        postEntity.setDescription(description);
        postEntity.setPublishedDate(postDate);
        postEntity.setUserId(userEntityOptional.get().getId());

        return postRepository.save(postEntity);
    }

    @Override
    public PostEntity findByPostId(Integer postId) {
        Optional<PostEntity> postEntityOptional = postRepository.findById(postId);
        return postEntityOptional.orElse(null);
    }

    @Override
    public List<PostEntity> findByUserId(Integer userId) {
        return postRepository.findAllByUserId(userId);
    }

    @Override
    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }
}
