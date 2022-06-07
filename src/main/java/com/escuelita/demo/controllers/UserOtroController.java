package com.escuelita.demo.controllers;

import com.escuelita.demo.dto.response.UserResponse;
import com.escuelita.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userOtro")
public class UserOtroController {

    @Autowired @Qualifier("otro")
    private IUserService service;

    @GetMapping("{id}")
    public UserResponse holi(@PathVariable Long id) {
        return service.getUserById(id);
    }
}
