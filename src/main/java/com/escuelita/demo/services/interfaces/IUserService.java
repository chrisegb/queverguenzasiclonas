package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.dto.request.PatchUserRequest;
import com.escuelita.demo.dto.response.UserResponse;

public interface IUserService {

    UserResponse getUserById(Long id);

    void patch(Long id, PatchUserRequest request);

    String checarMayoriaEdad(Integer edad);
}
