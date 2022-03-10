package com.example.Hours_Alpha_v2.employee;

import com.example.Hours_Alpha_v2.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeService extends UserService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

}
