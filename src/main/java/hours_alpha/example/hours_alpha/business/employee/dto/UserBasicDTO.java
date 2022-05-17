package hours_alpha.example.hours_alpha.business.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicDTO {
    private String email;
    private String firstName;
    private String lastName;
    private boolean stateEmployer;
}
