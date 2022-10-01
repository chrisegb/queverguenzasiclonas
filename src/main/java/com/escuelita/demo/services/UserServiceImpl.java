package com.escuelita.demo.services;

import com.escuelita.demo.controllers.dtos.requests.CreateUserRequest;
import com.escuelita.demo.controllers.dtos.requests.UpdateUserRequest;
import com.escuelita.demo.controllers.dtos.responses.GetUserResponse;
import com.escuelita.demo.entities.User;
import com.escuelita.demo.repositories.IUserRepository;
import com.escuelita.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("company")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public GetUserResponse get(Long id) {
        return from(id);
    }

    @Override
    public List<GetUserResponse> list() {
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
        /*List<GetUserResponse> responses = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);

            GetUserResponse response = new GetUserResponse();
            response.setId(user.getId());
            response.setEmail(user.getEmail());

            responses.add(response);
        }

        return responses;*/
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public GetUserResponse create(CreateUserRequest request) {
        User user = from(request);
        return from(repository.save(user));
    }

    @Override
    public GetUserResponse update(Long id, UpdateUserRequest request) {
        User user = findOneAndEnsureExist(id);
        user = update(user, request);
        return from(user);
    }

    @Override
    public User findOneAndEnsureExist(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The user does not exist"));
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void updateUserProfile(String profilePictureUrl, Long idUser) {
        User user = findOneAndEnsureExist(idUser);
        user.setProfilePicture(profilePictureUrl);
        repository.save(user);
    }

    private User update(User user, UpdateUserRequest request) {
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return repository.save(user);
    }

    private User from(CreateUserRequest request) {
        /*return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();*/
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    private GetUserResponse from(User user) {
        GetUserResponse response = new GetUserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }

    private GetUserResponse from(Long idUser) {
        return repository.findById(idUser)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("The user does not exist"));
    }
}
