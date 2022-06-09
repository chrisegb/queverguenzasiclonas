package com.escuelita.demo.services.impl;

import com.escuelita.demo.dto.request.PatchUserRequest;
import com.escuelita.demo.dto.response.UserResponse;
import com.escuelita.demo.entities.User;
import com.escuelita.demo.repositories.UserRepository;
import com.escuelita.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("original")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserResponse getUserById(Long id) {
        return from(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No esta migue")));
    }

    @Override
    public void patch(Long id, PatchUserRequest request) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            patchUser(user, request);
            repository.save(user);
        }
    }

    @Override
    public String checarMayoriaEdad(Integer edad) {
        if (edad < 0) {
            throw new RuntimeException("Tas mal");
        } else if (edad > 100) {
            throw new RuntimeException("No se puede mayor a 100");
        }
        if (edad > 17) {
            return "Eres mayor de edad";
        }
        return "Eres menor de edad";
    }

    private User patchUser(User user, PatchUserRequest request) {
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        return user;
    }

    private UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }
}
