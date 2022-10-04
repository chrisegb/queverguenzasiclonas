package com.escuelita.demo.entities.pivots;

import com.escuelita.demo.entities.Student;
import com.escuelita.demo.entities.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students_teachers")
@Getter
@Setter
public class StudentTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Teacher teacher;
}
