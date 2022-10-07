package com.escuelita.demo.services;

import com.escuelita.demo.controllers.dtos.responses.BaseResponse;
import com.escuelita.demo.controllers.dtos.responses.StudentResponse;
import com.escuelita.demo.controllers.dtos.responses.TeacherResponse;
import com.escuelita.demo.entities.projections.StudentProjection;
import com.escuelita.demo.entities.projections.TeacherProjection;
import com.escuelita.demo.repositories.IStudentTeacherRepository;
import com.escuelita.demo.services.interfaces.IStudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentTeacherServiceImpl implements IStudentTeacherService {

    @Autowired
    private IStudentTeacherRepository repository;


    @Override
    public BaseResponse listAllStudentsByTeacherId(Long teacherId) {

        List<StudentProjection> students = repository.listAllStudentsByTeacherId(teacherId);
        List<StudentResponse> response = students.stream()
                .map(this::from)
                .collect(Collectors.toList());

        return BaseResponse.builder()
                .data(response)
                .message("Student list by teacher id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public List<TeacherResponse> listAllTeachersByStudentId(Long studentId) {
        List<TeacherProjection> teachers = repository.listAllTeachersByStudentId(studentId);
        return teachers.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    private StudentResponse from(StudentProjection student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        return response;
    }

    private TeacherResponse from(TeacherProjection teacher) {
        TeacherResponse response = new TeacherResponse();
        response.setId(teacher.getId());
        response.setName(teacher.getName());
        response.setStudentName(teacher.getStudentName());
        return response;
    }
}
