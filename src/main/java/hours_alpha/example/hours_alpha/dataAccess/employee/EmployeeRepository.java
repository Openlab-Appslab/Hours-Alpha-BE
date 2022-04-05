package hours_alpha.example.hours_alpha.dataAccess.employee;

import hours_alpha.example.hours_alpha.business.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        Employee findByEmail(String email);
}
