package com.escuelita.demo.services.impl;

import com.escuelita.demo.dto.request.PatchUserRequest;
import com.escuelita.demo.dto.response.UserResponse;
import com.escuelita.demo.services.interfaces.IUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("otro")
public class UserServiceOtroImpl implements IUserService {
    @Override
    public UserResponse getUserById(Long id) {
        return new UserResponse();
    }

    @Override
    public void patch(Long id, PatchUserRequest request) {

    }

    @Override
    public String checarMayoriaEdad(Integer edad) {
        return "";
    }
}
