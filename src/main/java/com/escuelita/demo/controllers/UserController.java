package com.escuelita.demo.controllers;

import com.escuelita.demo.dto.request.PatchUserRequest;
import com.escuelita.demo.dto.response.UserResponse;
import com.escuelita.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired @Qualifier("original")
    private IUserService service;

    @GetMapping("{id}")
    public UserResponse holi(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PatchMapping("{id}")
    public void patch(@PathVariable Long id,
                      @RequestBody PatchUserRequest request) {
        service.patch(id, request);
    }

    @PostMapping("mayor-de-edad/{edad}")
    public String mayorDeEdad(@PathVariable Integer edad) {
        return service.checarMayoriaEdad(edad);
    }
}
