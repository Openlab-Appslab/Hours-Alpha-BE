package com.example.Hours_Alpha_v2.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.JstlUtils;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    final EmployeeService employeeService;

    @GetMapping(path = "api/v1/listOfEmployee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployee();
    }

    @PostMapping(path = "api/v1/registrationOfEmployee")
    public void registerNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

}

