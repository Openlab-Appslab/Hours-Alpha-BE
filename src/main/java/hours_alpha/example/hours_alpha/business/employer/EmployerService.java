package hours_alpha.example.hours_alpha.business.employer;

import hours_alpha.example.hours_alpha.business.company.Company;
import hours_alpha.example.hours_alpha.business.employee.dto.EmployeeRegistrationDTO;
import hours_alpha.example.hours_alpha.business.entity.EntityModelService;
import hours_alpha.example.hours_alpha.dataAccess.employer.EmployerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class  EmployerService implements EntityModelService<Employer> {

    private final EmployerRepository employerRepository;
    private final PasswordEncoder passwordEncoder;

    public Employer getUserByEmail(String email) {
        return employerRepository.findByEmail(email);
    }

    public Employer addNewEmployer(EmployeeRegistrationDTO employerDTO){


        String encodePassword = passwordEncoder.encode(employerDTO.getPassword());

        Employer employer = new Employer(
                employerDTO.getEmail(),
                employerDTO.getFirstName(),
                employerDTO.getLastName(),
                encodePassword
        );

        employer.setRole("ROLE_EMPLOYER");
        return employerRepository.save(employer);
    }

    public Employer updateEmployer(Employer employer){
        return employerRepository.save(employer);
    }

    public void deleteEmployer(String email){
        employerRepository.deleteEmployerByEmail(email);
    }

}
