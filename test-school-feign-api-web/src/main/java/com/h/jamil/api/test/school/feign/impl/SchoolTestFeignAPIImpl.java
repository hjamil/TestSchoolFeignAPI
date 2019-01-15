package com.h.jamil.api.test.school.feign.impl;

import com.h.jamil.api.test.school.entity.Student;
import com.h.jamil.api.test.school.feign.external.SchoolTestAPIExternalInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolTestFeignAPIImpl {

    @Autowired
    private SchoolTestAPIExternalInterface schoolTestAPIExternalInterface;


    public Student getStudent(Integer studentId) {

        return schoolTestAPIExternalInterface.getStudent(studentId);
    }

    public List<Student> getStudents() {

        return schoolTestAPIExternalInterface.getStudents();
    }
}
