package hours_alpha.example.hours_alpha.dataAccess.employee;

import hours_alpha.example.hours_alpha.business.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        Optional<Employee> findByEmail(String email);

    void deleteEmployeeByEmail(String email);
}
