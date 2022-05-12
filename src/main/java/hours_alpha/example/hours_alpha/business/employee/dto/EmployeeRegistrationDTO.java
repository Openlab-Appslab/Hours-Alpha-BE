package hours_alpha.example.hours_alpha.business.employee.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeRegistrationDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean isEmployer;
}
