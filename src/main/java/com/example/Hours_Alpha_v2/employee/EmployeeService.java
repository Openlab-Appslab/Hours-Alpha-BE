package com.example.Hours_Alpha_v2.employee;

import com.example.Hours_Alpha_v2.company.Company;
import com.example.Hours_Alpha_v2.hour.Hour;
import com.example.Hours_Alpha_v2.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeService extends UserService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new IllegalStateException("User with id does not exists. Id: "+id));
    }

    public Employee addNewEmployee(Employee employee){
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

        return employee;
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists){
            throw new IllegalStateException("Employee with id: "+employeeId+" does not exist");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public Employee updateEmployee(Long employeeId,
                               String firstName,
                               String lastName,
                               String email,
                               Long telephone) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with id: " +employeeId+" does not exist"
                ));

        //Checking if first name is correct!
        if(     firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(employee.getFirstName(), firstName)){
            employee.setFirstName(firstName);
        }else{
            throw new IllegalStateException("Something it is wrong. Try Again");
        }

        //Checking if last name is correct!
        if(     lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(employee.getLastName(), lastName)){
            employee.setLastName(lastName);
        }else{
            throw new IllegalStateException("Something it is wrong. Try Again");
        }

        //Checking if mail is correct
        if( email != null &&
            email.length() > 0 &&
            !Objects.equals(employee.getEmail(), email)
        ){
            if(email.contains("@gmail.com") || email.contains("@azet.sk") || email.contains("@centrum.sk")){
              employee.setEmail(email);
            }else{
                throw new IllegalStateException("Something with your email is wrong. Try again!");
            }
        }else{
            throw new IllegalStateException("Something with your email is wrong. Try again!");
        }

        //Checking if telephone is correct
        if( telephone != null &&
            telephone.toString().length() > 0 &&
            !Objects.equals(employee.getTelephone(), telephone)){
            employee.setTelephone(telephone);
        }else{
            throw new IllegalStateException("Something with your mobile phone is wrong");
        }
        return employee;
    }

    public Employee addCompanyToEmployee(Long employeeId, Company company) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException("Employee with id does not exists. Id: "+employeeId));

        employee.setCompany(company);
        return employee;
    }

    public Employee addRecordOfHourToEmployee(Long employeeId, Hour hour) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new IllegalStateException("Employee with id does not exists. Id: "+employeeId));

        List<Hour> listOfHour = employee.getListOfHour();
        listOfHour.add(hour);

        return employee;
    }
}
