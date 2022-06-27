package com.escuelita.demo.repositories;

import com.escuelita.demo.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {

    @Query(value = "SELECT alumnos.* FROM alumnos_materias " +
            "INNER JOIN alumnos ON alumnos.id = alumnos_materias.alumno_id " +
            "WHERE alumnos_materias.materia_id = :materiaId", nativeQuery = true)
    List<Alumno> getAllAlumnosByMateriaId(Long materiaId);
}
