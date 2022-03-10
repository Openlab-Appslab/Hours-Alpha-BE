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

    public void addNewEmployee(Employee employee){
        Optional<Employee> employeeOptional = employeeRepository
                .findEmployeeByEmail(employee.getEmail());
        if(employeeOptional.isPresent()){
            throw new IllegalStateException("Email has taken");
        }

        if(employee.getTelephone().intValue() != 10)
        {
            throw new IllegalStateException("FORMAT OF TEL. NUMBER IS INCORRECT");
        }

        if(employee.getFirstName().length() < 2 && employee.getFirstName().length() > 25){
            throw new IllegalStateException("FIST NAME IS INCORRECT. FIRST NAME HAVE TO BE BETWEEN 2 - 25");
        }

        if(employee.getLastName().length() < 2 && employee.getLastName().length() > 25){
            throw new IllegalStateException("LAST NAME IS INCORRECT. FIRST NAME HAVE TO BE BETWEEN 2 - 25");
        }

        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists){
            throw new IllegalStateException("Employee with id: "+employeeId+" does not exist");
        }
        employeeRepository.deleteById(employeeId);
    }


}
