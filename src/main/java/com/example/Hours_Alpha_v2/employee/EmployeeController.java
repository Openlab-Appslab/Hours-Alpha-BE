package com.example.Hours_Alpha_v2.employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "api/v1/{employeeId}")
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Long telephone
    ){
        employeeService.updateEmployee(employeeId, firstName, lastName, email, telephone);
    }

}

