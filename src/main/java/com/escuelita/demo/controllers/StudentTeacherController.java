package com.escuelita.demo.controllers;

import com.escuelita.demo.controllers.dtos.responses.BaseResponse;
import com.escuelita.demo.controllers.dtos.responses.StudentResponse;
import com.escuelita.demo.controllers.dtos.responses.TeacherResponse;
import com.escuelita.demo.services.interfaces.IStudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student-teacher")
public class StudentTeacherController {

    @Autowired
    private IStudentTeacherService service;

    @GetMapping("students/teacher/{teacherId}")
    public ResponseEntity<BaseResponse> listAllStudentsByTeacherId(@PathVariable Long teacherId) {
        BaseResponse baseResponse = service.listAllStudentsByTeacherId(teacherId);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("teachers/student/{studentId}")
    public List<TeacherResponse> listAllTeachersByStudentId(@PathVariable Long studentId) {
        return service.listAllTeachersByStudentId(studentId);
    }
}