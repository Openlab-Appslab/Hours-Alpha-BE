package hours_alpha.example.hours_alpha.business.dto.companyDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyBasicDTO{
    private String name;
    private Integer numberOfEmployees;
    private String employerFirstName;
    private String employerLastName;
    private String email;
}
