package com.escuelita.demo.services.impl;

import com.escuelita.demo.dto.request.CreateUserRequest;
import com.escuelita.demo.dto.request.UpdateUserRequest;
import com.escuelita.demo.dto.response.UserResponse;
import com.escuelita.demo.entities.User;
import com.escuelita.demo.repositories.IUserRepository;
import com.escuelita.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public UserResponse getUser(Long id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserResponse from = this.from(user);
            return from;
        }
        throw new RuntimeException("No esta carnalito");
    }

    @Override
    public void create(CreateUserRequest request) {
        User user = from(request);
        repository.save(user);
    }

    @Override
    public List<UserResponse> list() {
        List<User> users = repository.findAll();
        List<UserResponse> userResponses = from(users);
        return userResponses;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserResponse update(UpdateUserRequest request, Long id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            User updated = from(request, user);
            User saved = repository.save(updated);
            UserResponse response = from(saved);
            return response;
        }
        throw new RuntimeException("No esta carnal no se actualizó");
    }

    private User from(UpdateUserRequest request, User user) {
        user.setEmail(request.getEmail());
        return user;
    }

    private List<UserResponse> from(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            UserResponse response = from(user);
            userResponses.add(response);
        }
        return userResponses;
    }

    private User from(CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    private UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }
}
