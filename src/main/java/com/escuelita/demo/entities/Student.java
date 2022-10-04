package com.escuelita.demo.entities;

import com.escuelita.demo.entities.pivots.StudentTeacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student")
    private List<StudentTeacher> studentTeachers;

}
