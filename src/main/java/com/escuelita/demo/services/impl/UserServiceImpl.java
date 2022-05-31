package com.escuelita.demo.services.impl;

import com.escuelita.demo.dto.response.UserResponse;
import com.escuelita.demo.entities.User;
import com.escuelita.demo.repositories.UserRepository;
import com.escuelita.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserResponse getUserById(Long id) {
        return from(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No esta migue")));
    }

    private UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }
}
