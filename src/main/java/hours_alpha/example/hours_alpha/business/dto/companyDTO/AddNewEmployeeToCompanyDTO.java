package hours_alpha.example.hours_alpha.business.dto.companyDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddNewEmployeeToCompanyDTO {
    public String email;
    public String name;
}
