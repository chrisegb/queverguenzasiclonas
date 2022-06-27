package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.entities.Alumno;

import java.util.List;

public interface IAlumnoService {

    List<Alumno> getAllAlumnosByMateriaId(Long materiaId);
}
