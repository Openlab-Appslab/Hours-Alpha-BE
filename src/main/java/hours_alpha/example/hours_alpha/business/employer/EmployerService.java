package hours_alpha.example.hours_alpha.business.employer;

import hours_alpha.example.hours_alpha.business.dto.userDTO.UserRegistrationDTO;
import hours_alpha.example.hours_alpha.business.dto.userDTO.UserBasicDTO;
import hours_alpha.example.hours_alpha.business.employee.Employee;
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

    public Employer loginGetUserByEmail(String email){
        return employerRepository.findByEmail(email);
    }

    public UserBasicDTO addNewEmployer(UserRegistrationDTO employerDTO){


        String encodePassword = passwordEncoder.encode(employerDTO.getPassword());

        Employer employer = new Employer(
                employerDTO.getEmail(),
                employerDTO.getFirstName(),
                employerDTO.getLastName(),
                encodePassword
        );

        employer.setRole("ROLE_EMPLOYER");

        employerRepository.save(employer);

        return convertToUserBasicDTO(employer);
    }

    public UserBasicDTO convertToUserBasicDTO(Employer employer){

        return new UserBasicDTO(
          employer.getEmail(),
          employer.getFirstName(),
          employer.getLastName(),
                employer.getPassword(),
                true
        );

    }

    public Employer updateEmployer(Employer employer){
        return employerRepository.save(employer);
    }

    public void deleteEmployer(String email){
        employerRepository.deleteEmployerByEmail(email);
    }

}
