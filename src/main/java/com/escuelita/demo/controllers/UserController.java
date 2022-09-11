package com.escuelita.demo.controllers;

import com.escuelita.demo.controllers.dtos.requests.CreateUserRequest;
import com.escuelita.demo.controllers.dtos.responses.CreateUserResponse;
import com.escuelita.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("{id}")
    public CreateUserResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<CreateUserResponse> list() {
        return service.list();
    }

    @PostMapping
    public CreateUserResponse create(@RequestBody CreateUserRequest request) {
        return service.create(request);
    }

    @PutMapping("{id}")
    public CreateUserResponse update(@PathVariable Long id, @RequestBody CreateUserRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
