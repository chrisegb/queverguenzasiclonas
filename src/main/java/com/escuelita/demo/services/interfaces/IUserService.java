package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.dto.response.UserResponse;

public interface IUserService {

    UserResponse getUserById(Long id);
}
