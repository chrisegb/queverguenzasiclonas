package com.escuelita.demo.entities;

import org.springframework.stereotype.Component;

@Component
public class Ejecutar {


    public Vehiculo crearVehiculo(String tipo) {
        if (tipo.equalsIgnoreCase("carro")) {
            return new Carro();
        } else if (tipo.equalsIgnoreCase("moto")) {
            return new Moto();
        } else if (tipo.equalsIgnoreCase("lancha")) {
            return new Lancha();
        }
        return null;
    }
}
