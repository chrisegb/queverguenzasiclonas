package com.escuelita.demo.controllers;

import com.escuelita.demo.controllers.dtos.requests.CreateUserRequest;
import com.escuelita.demo.controllers.dtos.requests.UpdateUserRequest;
import com.escuelita.demo.controllers.dtos.responses.CreateUserResponse;
import com.escuelita.demo.controllers.dtos.responses.GetUserResponse;
import com.escuelita.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    @Qualifier("company")
    private IUserService service;

    @GetMapping
    public List<GetUserResponse> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public GetUserResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public GetUserResponse create(@RequestBody CreateUserRequest request) {
        return service.create(request);
    }

    @PutMapping("{id}")
    public GetUserResponse update(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
