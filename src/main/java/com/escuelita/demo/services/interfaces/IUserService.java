package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.dto.request.CreateUserRequest;
import com.escuelita.demo.dto.request.UpdateUserRequest;
import com.escuelita.demo.dto.response.UserResponse;

import java.util.List;

public interface IUserService {

    UserResponse getUser(Long id);

    void create(CreateUserRequest request);

    List<UserResponse> list();

    void delete(Long id);

    UserResponse update(UpdateUserRequest request, Long id);
}
