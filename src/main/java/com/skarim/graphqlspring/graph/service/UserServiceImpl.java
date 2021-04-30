package com.skarim.graphqlspring.graph.service;

import com.skarim.graphqlspring.domain.UserEntity;
import com.skarim.graphqlspring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(String fullName, String email, String gender, String dob,
                                 String presentAddress,
                                 String permanentAddress) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(fullName);
        userEntity.setEmail(email);
        userEntity.setDob(dob);
        userEntity.setGender(gender);
        userEntity.setPresentAddress(presentAddress);
        userEntity.setPermanentAddress(permanentAddress);

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findById(Integer id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        return userEntityOptional.orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
