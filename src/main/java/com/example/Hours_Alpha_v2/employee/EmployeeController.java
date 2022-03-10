package com.example.Hours_Alpha_v2.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping(path = "api/v1/{employeeId}")
    public void deleteEmployee(
            @PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
    

}

