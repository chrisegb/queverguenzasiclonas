package com.escuelita.demo.controllers;

import com.escuelita.demo.entities.Ejecutar;
import com.escuelita.demo.entities.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehiculo")
public class VehiculoController {

    @Autowired
    private Ejecutar ejecutar;

    @GetMapping("fabrica/{tipo}")
    public String acelerar(@PathVariable String tipo) {
        Vehiculo vehiculo = ejecutar.crearVehiculo(tipo);
        return vehiculo.acelerar();
    }
}
