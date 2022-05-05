package hours_alpha.example.hours_alpha.dataAccess.employer;

import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employer.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    Employer findByEmail(String email);

    void deleteEmployerByEmail(String email);
}
