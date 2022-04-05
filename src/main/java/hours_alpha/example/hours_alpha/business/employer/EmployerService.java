package hours_alpha.example.hours_alpha.business.employer;

import hours_alpha.example.hours_alpha.business.entity.EntityModelService;
import hours_alpha.example.hours_alpha.dataAccess.employer.EmployerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployerService implements EntityModelService<Employer> {

    private final EmployerRepository employerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Employer getUserByEmail(String email) {
        return employerRepository.findByEmail(email);
    }

}
