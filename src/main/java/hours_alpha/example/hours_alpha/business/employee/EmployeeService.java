package hours_alpha.example.hours_alpha.business.employee;

import hours_alpha.example.hours_alpha.business.dto.userDTO.UserRegistrationDTO;
import hours_alpha.example.hours_alpha.business.dto.userDTO.UserBasicDTO;
import hours_alpha.example.hours_alpha.business.entity.EntityModelService;
import hours_alpha.example.hours_alpha.dataAccess.employee.EmployeeRepository;
import hours_alpha.example.hours_alpha.exception.EmailAlreadyExistsException;
import hours_alpha.example.hours_alpha.exception.UserNotFoundByEmailException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService implements EntityModelService<Employee> {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public UserBasicDTO addNewEmployee(UserRegistrationDTO employeeRegistrationDTO) {

        Optional<Employee> employeeOptional = employeeRepository.findByEmail(employeeRegistrationDTO.getEmail());

        if(employeeOptional.isEmpty()){
            String encodePass = passwordEncoder.encode(employeeRegistrationDTO.getPassword());

            Employee employee = new Employee(
                    employeeRegistrationDTO.getEmail(),
                    employeeRegistrationDTO.getFirstName(),
                    employeeRegistrationDTO.getLastName(),
                    encodePass);

            employee.setRole("ROLE_EMPLOYEE");

            employeeRepository.save(employee);

            return convertToUserBasicDTO(employee);
        }else{
            throw new EmailAlreadyExistsException("Email is already taken");
        }
    }

    public UserBasicDTO convertToUserBasicDTO(Employee employee){

        return new UserBasicDTO(
                employee.getEmail(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPassword(),
                false);
    }

    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee getUserByEmail(String email) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);

        if(employeeOptional.isPresent()){
            return employeeOptional.get();
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
