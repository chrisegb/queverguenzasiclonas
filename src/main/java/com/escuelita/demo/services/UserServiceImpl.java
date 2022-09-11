package com.escuelita.demo.services;

import com.escuelita.demo.controllers.dtos.requests.CreateUserRequest;
import com.escuelita.demo.controllers.dtos.responses.CreateUserResponse;
import com.escuelita.demo.entities.User;
import com.escuelita.demo.repositories.IUserRepository;
import com.escuelita.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        User save = repository.save(from(request));
        return from(save);
    }

    @Override
    public CreateUserResponse get(Long id) {
        User user = findAndEnsureExist(id);
        return from(user);
    }

    @Override
    public List<CreateUserResponse> list() {
        return repository.findAll().stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public CreateUserResponse update(Long id, CreateUserRequest request) {
        User user = findAndEnsureExist(id);
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return from(repository.save(user));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    private User from(CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    private CreateUserResponse from(User user) {
        CreateUserResponse response = new CreateUserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }

    private User findAndEnsureExist(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
