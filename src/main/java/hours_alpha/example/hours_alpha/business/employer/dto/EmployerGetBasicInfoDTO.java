package hours_alpha.example.hours_alpha.business.employer.dto;

import hours_alpha.example.hours_alpha.business.company.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployerGetBasicInfoDTO {
    private String email;
    private String firstName;
    private String lastName;
    private Company company;
}
