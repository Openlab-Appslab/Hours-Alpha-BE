package hours_alpha.example.hours_alpha.business.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> getEmployeeByEmail(String email);
    Employee addNewEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
