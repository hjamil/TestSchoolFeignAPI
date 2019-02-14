package com.h.jamil.api.test.school.feign.impl;

import com.h.jamil.api.framework.utility.ELKLogger;
import com.h.jamil.api.test.school.domain.Student;
import com.h.jamil.api.test.school.feign.external.SchoolTestAPIExternalInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolTestFeignAPIImpl {
    // Define Logback
    private static final ELKLogger log = new ELKLogger(SchoolTestFeignAPIImpl.class);

    @Autowired
    private SchoolTestAPIExternalInterface schoolTestAPIExternalInterface;


    public Student getStudent(Integer studentId) {

        log.info(this.getClass().getSimpleName() + " INITIATED...");

        return schoolTestAPIExternalInterface.getStudent(studentId);
    }

    public List<Student> getStudents() {

        log.info(this.getClass().getSimpleName() + " INITIATED...");

        return schoolTestAPIExternalInterface.getStudents();
    }
}
