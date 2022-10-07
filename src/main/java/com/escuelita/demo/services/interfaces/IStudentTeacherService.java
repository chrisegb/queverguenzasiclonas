package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.controllers.dtos.responses.BaseResponse;
import com.escuelita.demo.controllers.dtos.responses.StudentResponse;
import com.escuelita.demo.controllers.dtos.responses.TeacherResponse;

import java.util.List;

public interface IStudentTeacherService {

    BaseResponse listAllStudentsByTeacherId(Long teacherId);

    List<TeacherResponse> listAllTeachersByStudentId(Long studentId);
}
