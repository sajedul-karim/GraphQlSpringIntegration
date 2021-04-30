package com.skarim.graphqlspring.graph.mutation;

import com.skarim.graphqlspring.domain.UserEntity;
import com.skarim.graphqlspring.graph.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Service;

@Service
public class CreateUserMutationResolver implements GraphQLMutationResolver {
    private UserService userService;

    public CreateUserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    public UserEntity createUser(final String fullName, final String email, final String dob, String gender, String presentAddress, String permanentAddress) {
        return userService.createUser(fullName, email, gender, dob,presentAddress, permanentAddress);
    }
}
