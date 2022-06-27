package com.escuelita.demo.controllers;

import com.escuelita.demo.entities.Alumno;
import com.escuelita.demo.repositories.IAlumnoRepository;
import com.escuelita.demo.services.interfaces.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("alumno")
public class AlumnoController {

    @Autowired
    private IAlumnoService service;

    @GetMapping("materia/{materiaId}")
    public List<Alumno> getAllAlumnosByMateriaId(@PathVariable Long materiaId) {
        return service.getAllAlumnosByMateriaId(materiaId);
    }
}
