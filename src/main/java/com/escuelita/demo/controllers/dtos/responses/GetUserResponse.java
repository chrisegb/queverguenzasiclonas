package com.escuelita.demo.controllers.dtos.responses;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetUserResponse {

    private Long id;
    private String email;
    private RoleResponse role;
}
