package hours_alpha.example.hours_alpha.business.employer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployerRegistrationDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
