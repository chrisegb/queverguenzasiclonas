package com.escuelita.demo.services;

import com.escuelita.demo.controllers.dtos.requests.CreateRoleRequest;
import com.escuelita.demo.controllers.dtos.responses.CreateRoleResponse;
import com.escuelita.demo.controllers.exceptions.UpchiapasException;
import com.escuelita.demo.entities.Role;
import com.escuelita.demo.repositories.IRoleRepository;
import com.escuelita.demo.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository repository;

    @Override
    public Role findRoleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UpchiapasException("No se encuentra el role"));
    }

    @Override
    public Role findByRoleName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new UpchiapasException("No se encuentra el role"));
    }

    @Override
    public CreateRoleResponse create(CreateRoleRequest request) {
        Role role = new Role();
        role.setName(request.getName());
        Role savedRole = repository.save(role);
        return from(savedRole);
    }

    private CreateRoleResponse from(Role role) {
        CreateRoleResponse response = new CreateRoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());
        return response;
    }
}
