package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.controllers.dtos.requests.CreateUserRequest;
import com.escuelita.demo.controllers.dtos.responses.CreateUserResponse;

import java.util.List;

public interface IUserService {

    CreateUserResponse create(CreateUserRequest request);

    CreateUserResponse get(Long id);

    List<CreateUserResponse> list();

    CreateUserResponse update(Long id, CreateUserRequest request);

    void delete(Long id);
}
