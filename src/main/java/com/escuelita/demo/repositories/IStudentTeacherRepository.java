package com.escuelita.demo.repositories;

import com.escuelita.demo.entities.Student;
import com.escuelita.demo.entities.pivots.StudentTeacher;
import com.escuelita.demo.entities.projections.StudentProjection;
import com.escuelita.demo.entities.projections.TeacherProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentTeacherRepository extends JpaRepository<StudentTeacher, Long> {

    @Query(value = "select students.* from students_teachers " +
            "inner join students on students_teachers.student_id = students.id " +
            "inner join teachers on students_teachers.teacher_id = teachers.id " +
            "where students_teachers.teacher_id = :teacherId", nativeQuery = true)
    List<StudentProjection> listAllStudentsByTeacherId(Long teacherId);


    @Query(value = "select teachers.*, students.name as studentName from students_teachers " +
            "inner join students on students_teachers.student_id = students.id " +
            "inner join teachers on students_teachers.teacher_id = teachers.id " +
            "where students_teachers.student_id = :studentId", nativeQuery = true)
    List<TeacherProjection> listAllTeachersByStudentId(Long studentId);
}
