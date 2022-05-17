package hours_alpha.example.hours_alpha.business.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRegistrationDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean stateEmployer;

    public boolean getStateEmployer() {
        return stateEmployer;
    }
}
