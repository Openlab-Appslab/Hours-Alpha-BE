package hours_alpha.example.hours_alpha.business.employee;

import hours_alpha.example.hours_alpha.business.employee.dto.EmployeeRegistrationDTO;
import hours_alpha.example.hours_alpha.business.employee.dto.UserBasicDTO;
import hours_alpha.example.hours_alpha.business.employer.Employer;
import hours_alpha.example.hours_alpha.business.entity.EntityModelService;
import hours_alpha.example.hours_alpha.business.hour.Hour;
import hours_alpha.example.hours_alpha.dataAccess.employee.EmployeeRepository;
import hours_alpha.example.hours_alpha.exception.UserNotFoundByEmailException;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.desktop.AboutEvent;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService implements EntityModelService<Employee> {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public UserBasicDTO addNewEmployee(EmployeeRegistrationDTO employeeRegistrationDTO) {


        String encodePass = passwordEncoder.encode(employeeRegistrationDTO.getPassword());

        Employee employee = new Employee(
                employeeRegistrationDTO.getEmail(),
                employeeRegistrationDTO.getFirstName(),
                employeeRegistrationDTO.getLastName(),
                encodePass);

        employee.setRole("ROLE_EMPLOYEE");

        employeeRepository.save(employee);

        return convertToUserBasicDTO(employee);
    }

    public UserBasicDTO convertToUserBasicDTO(Employee employee){

        return new UserBasicDTO(
                employee.getEmail(),
                employee.getFirstName(),
                employee.getLastName(),
                false);
    }

    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee getUserByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);

        if(employee != null){
            return employee;
        }else{
            throw new UserNotFoundByEmailException("Použivateľ s emailom: " + email + " nebol najdený!");
        }
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String email){
        employeeRepository.deleteEmployeeByEmail(email);
    }

}
