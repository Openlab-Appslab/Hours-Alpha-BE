package hours_alpha.example.hours_alpha.business.employee;

import hours_alpha.example.hours_alpha.business.entity.EntityModelService;
import hours_alpha.example.hours_alpha.dataAccess.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService implements EntityModelService<Employee> {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Employee addNewEmployee(Employee employee) {
        String encodePass = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodePass);
        employee.setRole("ROLE_EMPLOYEE");
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getUserByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
