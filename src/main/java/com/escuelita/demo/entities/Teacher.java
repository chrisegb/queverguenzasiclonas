package com.escuelita.demo.entities;

import com.escuelita.demo.entities.pivots.StudentTeacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter @Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "teacher")
    private List<StudentTeacher> studentTeachers;

}
