package com.h.jamil.api.test.school.feign.external;

import com.h.jamil.api.framework.config.FeignConfig;
import com.h.jamil.api.test.school.domain.Student;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@EnableFeignClients
@FeignClient(value = "http://test-school-api", configuration = FeignConfig.class)
public interface SchoolTestAPIExternalInterface {

    @RequestMapping(value = "/h/jamil/rest/v1/school/test/student/{studentId}", method = RequestMethod.GET, produces = "application/json")
    Student getStudent(@PathVariable(value = "studentId") Integer studentId);

    @RequestMapping(value = "/h/jamil/rest/v1/school/test/students", method = RequestMethod.GET, produces = "application/json")
    List<Student> getStudents();
}
