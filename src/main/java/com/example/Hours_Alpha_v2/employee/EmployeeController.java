package com.example.Hours_Alpha_v2.employee;

import com.example.Hours_Alpha_v2.company.Company;
import com.example.Hours_Alpha_v2.hour.Hour;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5432")
@RequestMapping(path = "/employee")
public class EmployeeController {

    final EmployeeService employeeService;

    @GetMapping(path = "/getAllEmployees")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employeeList = employeeService.getEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Employee> getEmployeeId(
            @PathVariable("id") Long employeeId
    ){
        Employee employee = employeeService.findEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping(path = "/registrationOfEmployee")
    public ResponseEntity<Employee> registerNewEmployee(
            @RequestBody Employee employee){
        Employee newEmployee = employeeService.addNewEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{employeeId}")
    public void deleteEmployee(
            @PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = "/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Long telephone
    ){
        Employee employee = employeeService.updateEmployee(employeeId, firstName, lastName, email, telephone);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping(path = "/addCompany/{employeeId}")
    public ResponseEntity<Employee> addCompany(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) Company company
    ){
        Employee employee = employeeService.addCompanyToEmployee(employeeId, company);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping(path = "/addRecordOfHours/{employeeId}")
    public ResponseEntity<Employee> addRecordOfHour(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) Hour hour
    ){
        Employee employee = employeeService.addRecordOfHourToEmployee(employeeId, hour);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}

