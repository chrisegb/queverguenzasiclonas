package com.escuelita.demo.services.impl;

import com.escuelita.demo.entities.Alumno;
import com.escuelita.demo.repositories.IAlumnoRepository;
import com.escuelita.demo.services.interfaces.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private IAlumnoRepository repository;


    @Override
    public List<Alumno> getAllAlumnosByMateriaId(Long materiaId) {
        return repository.getAllAlumnosByMateriaId(materiaId);
    }
}
