package com.escuelita.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany
    private List<Alumno> alumnos;
}
