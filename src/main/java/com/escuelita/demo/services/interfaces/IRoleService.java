package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.controllers.dtos.requests.CreateRoleRequest;
import com.escuelita.demo.controllers.dtos.responses.CreateRoleResponse;
import com.escuelita.demo.entities.Role;

public interface IRoleService {

    Role findRoleById(Long id);

    Role findByRoleName(String name);

    CreateRoleResponse create(CreateRoleRequest request);
}
