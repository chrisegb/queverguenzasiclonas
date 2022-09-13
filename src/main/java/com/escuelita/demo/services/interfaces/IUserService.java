package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.controllers.dtos.requests.CreateUserRequest;
import com.escuelita.demo.controllers.dtos.requests.UpdateUserRequest;
import com.escuelita.demo.controllers.dtos.responses.CreateUserResponse;
import com.escuelita.demo.controllers.dtos.responses.GetUserResponse;

import java.util.List;

public interface IUserService {

    GetUserResponse get(Long id);

    List<GetUserResponse> list();

    void delete(Long id);

    GetUserResponse create(CreateUserRequest request);

    GetUserResponse update(Long id, UpdateUserRequest request);
}
