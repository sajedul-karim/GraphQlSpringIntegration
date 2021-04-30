package com.skarim.graphqlspring.graph.mutation;

import com.skarim.graphqlspring.domain.PostEntity;
import com.skarim.graphqlspring.graph.service.PostService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Service;

@Service
public class PostMutationResolver implements GraphQLMutationResolver {
    private PostService postService;

    public PostMutationResolver(PostService postService) {
        this.postService = postService;
    }

    public PostEntity createPost(final Integer userId, final String title, final String description, String postDate) {
        return postService.createPost(userId, title,description,postDate);
    }
    public boolean deletePostById(Integer postId){
        return postService.deletePostById(postId);
    }

}
