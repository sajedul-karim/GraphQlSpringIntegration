package com.skarim.graphqlspring.graph.query;

import com.skarim.graphqlspring.domain.UserEntity;
import com.skarim.graphqlspring.graph.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryResolver implements GraphQLQueryResolver {
    private UserService userService;

    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    public List<UserEntity> userAll() {
        return userService.findAll();
    }
    public UserEntity userById(Integer id) {
        return userService.findById(id);
    }
}
